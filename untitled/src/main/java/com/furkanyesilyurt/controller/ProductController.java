package com.furkanyesilyurt.controller;

import com.furkanyesilyurt.converter.ProductConverter;
import com.furkanyesilyurt.dto.ProductDetailDto;
import com.furkanyesilyurt.dto.ProductDto;
import com.furkanyesilyurt.entity.Product;
import com.furkanyesilyurt.exception.ProductNotFoundException;
import com.furkanyesilyurt.services.entityservices.CategoryEntityService;
import com.furkanyesilyurt.services.entityservices.ProductEntityService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.furkanyesilyurt.services.entityservices.CategoryEntityService;
import com.furkanyesilyurt.services.entityservices.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/urunler/")
public class ProductController {

    @Autowired
    private ProductEntityService productEntityService;

    @Autowired
    private CategoryEntityService categoryEntityService;

    @GetMapping("")
    public MappingJacksonValue findAllUrunList() {

        List<Product> productList = productEntityService.findAll();

        String filterName = "ProductFilter";

        SimpleFilterProvider filters = getUrunFilterProvider(filterName);

        MappingJacksonValue mapping = new MappingJacksonValue(productList);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findUrunById(@PathVariable Long id){

        Product product = productEntityService.findById(id);

        if (product == null){
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        WebMvcLinkBuilder linkToUrun = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAllUrunList()
        );

        ProductDto productDto = ProductConverter.INSTANCE.convertUrunToUrunDto(product);

        String filterName = "ProductDtoFilter";

        SimpleFilterProvider filters = getUrunFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(productDto);

        entityModel.add(linkToUrun.withRel("All-products"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/detail/{id}")
    public ProductDetailDto findUrunDtoById(@PathVariable Long id){

        Product product = productEntityService.findById(id);

        if (product == null){
            throw new ProductNotFoundException("Product not found. id: " + id);
        }

        ProductDetailDto urunDetayDto = ProductConverter.INSTANCE.convertUrunToUrunDetayDto(product);

        return urunDetayDto;
    }

    @PostMapping("")
    public ResponseEntity<Object> saveUrun(@RequestBody ProductDto urunDto){

        Product product = ProductConverter.INSTANCE.convertUrunDtoToUrun(urunDto);

        product = productEntityService.save(product);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("{id}")
    public void deleteUrun(@PathVariable Long id){

        productEntityService.deleteById(id);
    }

    @GetMapping("kategoriler/{kategoriId}")
    public List<ProductDetailDto> findAllUrunByKategoriId(@PathVariable Long kategoriId){

        List<Product> productList = productEntityService.findAllByKategoriOrderByIdDesc(kategoriId);

        List<ProductDetailDto> productDetailDtoList = ProductConverter.INSTANCE.convertAllUrunListToUrunDetayDtoList(productList);

        return productDetailDtoList;
    }

    private SimpleFilterProvider getUrunFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getUrunFilter();

        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getUrunFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "adi", "fiyat", "kayitTarihi");
    }
}