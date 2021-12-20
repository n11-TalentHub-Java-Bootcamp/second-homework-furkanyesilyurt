package com.furkanyesilyurt.springboot.springboottraining.controller;

import com.furkanyesilyurt.springboot.springboottraining.dto.ProductDto;
import com.furkanyesilyurt.springboot.springboottraining.entity.Category;
import com.furkanyesilyurt.springboot.springboottraining.entity.Product;
import com.furkanyesilyurt.springboot.springboottraining.exception.ProductNotFoundException;
import com.furkanyesilyurt.springboot.springboottraining.services.entityServices.CategoryEntityService;
import com.furkanyesilyurt.springboot.springboottraining.services.entityServices.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductEntityService productEntityService;

    @Autowired
    private CategoryEntityService categoryEntityService;

    @GetMapping("")
    public List<Product> findAllProducts() {
        return productEntityService.findAll();
    }

    @GetMapping("/{id}")
    public EntityModel<Product> findProductById(@PathVariable Long id) {

        Product product = productEntityService.findById(id);

        if (product == null) {
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        WebMvcLinkBuilder webMvcLinkBuilder = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass()).findAllProducts());

        EntityModel entityModel = EntityModel.of(product);

        entityModel.add(webMvcLinkBuilder.withRel("All products"));

        return entityModel;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto) {

        Product product = convertProductDtoToProduct(productDto);

        product = productEntityService.save(product);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}").buildAndExpand(product.getId()).toUri();

        //System.out.println(product.getAdi());

        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productEntityService.deleteById(id);
    }

    private Product convertProductDtoToProduct(ProductDto productDto) {
        Category category = categoryEntityService.findById(productDto.getKategoriId());

        Product product = new Product();
        product.setAdi(productDto.getAdi());
        product.setFiyat(productDto.getFiyat());
        product.setKayitTarihi(productDto.getKayitTarihi());
        product.setKategori(category);

        return product;
    }
}
