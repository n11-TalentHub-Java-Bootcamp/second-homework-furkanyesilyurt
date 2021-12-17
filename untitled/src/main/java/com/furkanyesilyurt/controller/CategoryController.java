package com.furkanyesilyurt.controller;

import com.furkanyesilyurt.converter.CategoryConverter;
import com.furkanyesilyurt.converter.ProductConverter;
import com.furkanyesilyurt.dto.CategoryDto;
import com.furkanyesilyurt.dto.ProductDetailDto;
import com.furkanyesilyurt.dto.ProductDto;
import com.furkanyesilyurt.entity.Category;
import com.furkanyesilyurt.entity.Product;
import com.furkanyesilyurt.services.entityservices.CategoryEntityService;
import com.furkanyesilyurt.services.entityservices.ProductEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/kategoriler")
public class CategoryController {

    @Autowired
    private CategoryEntityService categoryEntityService;

    @Autowired
    private ProductEntityService productEntityService;

    @GetMapping("")
    public List<CategoryDto> findAll(){

        List<Category> categoryList = categoryEntityService.findAll();

        List<CategoryDto> kategoriDtoList = CategoryConverter.INSTANCE.convertAllKategoriListToKategoriDtoList(categoryList);

        return kategoriDtoList;
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){

        Category category = categoryEntityService.findById(id);

        return category;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody CategoryDto categoryDto){ //TODO: Input değeri dto tipinde olmalı

        Category category = CategoryConverter.INSTANCE.convertKategoriDtoToKategori(categoryDto);

        //TODO: Check it
        if (category.getUstKategori() != null && category.getUstKategori().getId() == null){
            category.setUstKategori(null);
        }

        category = categoryEntityService.save(category);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(category.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("")
    public CategoryDto update(@RequestBody CategoryDto categoryDto){//TODO: Input değeri dto tipinde olmalı

        Category category = CategoryConverter.INSTANCE.convertKategoriDtoToKategori(categoryDto);

        //TODO: Check it
        if (category.getUstKategori() != null && category.getUstKategori().getId() == null){
            category.setUstKategori(null);
        }

        category = categoryEntityService.save(category);

        CategoryDto kategoriDtoResult = CategoryConverter.INSTANCE.convertKategoriToKategoriDto(category);

        return kategoriDtoResult;
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        categoryEntityService.deleteById(id);
    }

    // localhost:8080/api/kategoriler/{id}/urunler
    @GetMapping("/{id}/urunler")
    public List<ProductDetailDto> findAllUrunByKategoriId(@PathVariable Long id){
        List<Product> productList = productEntityService.findAllByKategoriOrderByIdDesc(id);

        List<ProductDetailDto> urunDetayDtoList = ProductConverter.INSTANCE.convertAllUrunListToUrunDetayDtoList(productList);

        return urunDetayDtoList;
    }
}