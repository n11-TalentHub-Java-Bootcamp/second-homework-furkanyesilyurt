package com.furkanyesilyurt.springboot.springboottraining;

import com.furkanyesilyurt.springboot.springboottraining.entity.Category;
import com.furkanyesilyurt.springboot.springboottraining.entity.Product;
import com.furkanyesilyurt.springboot.springboottraining.services.WebService;
import com.furkanyesilyurt.springboot.springboottraining.services.entityServices.CategoryEntityService;
import com.furkanyesilyurt.springboot.springboottraining.services.entityServices.ProductEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootTrainingApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootTrainingApplication.class, args);



	}

	public static void saveSporCategory(){
//		CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);
//
//		Category spor = new Category();
//		spor.setAdi("Spor");
//		spor.setKirilim(1L);
//
//		categoryEntityService.save(spor);
//
//		Category fitness = new Category();
//		fitness.setAdi("Fitness");
//		fitness.setKirilim(2L);
//		fitness.setUstKategori(spor);
//
//		categoryEntityService.save(fitness);
//
//		categoryEntityService.findAll();

	}
	public static void saveProduct(){
//		ProductEntityService productEntityService = applicationContext.getBean(ProductEntityService.class);
//		CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);
//
//		Category category = categoryEntityService.findById(152L);
//
//		Product product = new Product();
//		product.setAdi("Iphone");
//		product.setFiyat(new BigDecimal("109"));
//		product.setKategori(category);
//		product.setKayitTarihi(new Date());
//
//		product = productEntityService.save(product);

//		System.out.println(product);
	}
	public static void saveCategory(){
//		CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);
//
//		Category ustCategory = categoryEntityService.findById(2L);
//
//		Category category = new Category();
//		category.setAdi("Telefon");
//		category.setKirilim(2L);
//		category.setUstKategori(ustCategory);
//
//		category = categoryEntityService.save(category);
//
//		System.out.println(category);
	}

}
