package com.furkanyesilyurt;

import com.furkanyesilyurt.entity.Category;
import com.furkanyesilyurt.entity.Product;
import com.furkanyesilyurt.services.entityservices.CategoryEntityService;
import com.furkanyesilyurt.services.entityservices.ProductEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootTrainingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootTrainingApplication.class, args);

        CategoryEntityService categoryEntityService = applicationContext.getBean(CategoryEntityService.class);
        ProductEntityService productEntityService = applicationContext.getBean(ProductEntityService.class);

//		Kategori kategori = getTelefonKategori(service);

//		getSamsungM31(kategoriEntityService, urunEntityService);

//		deleteUrunList(urunEntityService);

//		findAllUrunList(urunEntityService);

//		saveKitap(kategoriEntityService);

//		findAllUrunList(kategoriEntityService);
    }

    private static void saveKitap(CategoryEntityService categoryEntityService) {
        Category kitap = new Category();
        kitap.setAdi("Kitap");
        kitap.setKirilim(1L);

        kitap = categoryEntityService.save(kitap);

        Category kitapAlt = new Category();
        kitapAlt.setKirilim(2L);
        kitapAlt.setAdi("Kitap");
        kitapAlt.setUstKategori(kitap);

        categoryEntityService.save(kitapAlt);
    }

    private static void findAllUrunList(ProductEntityService productEntityService) {
        List<Product> productList = productEntityService.findAll();

        for (Product product : productList) {
            System.out.println(product.getAdi());
        }
    }

    private static void findAllUrunList(CategoryEntityService categoryEntityService) {
        List<Category> categoryList = categoryEntityService.findAll();

        for (Category  category : categoryList) {
            System.out.println(category.getAdi());
        }
    }

    private static void deleteUrunList(ProductEntityService productEntityService) {
        List<Long> silinecekUrunIdlist = Arrays.asList(102L, 152L, 202L, 252L, 302L);

        for (Long urunId : silinecekUrunIdlist) {
            productEntityService.deleteById(urunId);
        }
    }

    private static void getSamsungM31(CategoryEntityService categoryEntityService, ProductEntityService productEntityService) {
        Category category = categoryEntityService.findById(502L);

        Product product = new Product();
        product.setAdi("Samsung M31");
        product.setFiyat(new BigDecimal("3000"));
        product.setKayitTarihi(new Date());
        product.setKategori(category);

        product = productEntityService.save(product);

        System.out.println(product);
    }

    private static Category getTelefonKategori(CategoryEntityService service) {
        Category ustKategori = service.findById(2L);

        System.out.println(ustKategori);

        Category category = new Category();
        category.setAdi("Telefon");
        category.setKirilim(2L);
        category.setUstKategori(ustKategori);

        category = service.save(category);

        System.out.println(category);

        return category;
    }

}