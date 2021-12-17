package com.furkanyesilyurt;

import com.furkanyesilyurt.entity.Product;
import com.furkanyesilyurt.services.entityservices.ProductEntityService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AnnotationBasedApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext/annotation-based-config.xml");

        ProductEntityService productEntityService = applicationContext.getBean(ProductEntityService.class);

         List<Product> productList = productEntityService.findAll();

         for(Product product : productList){
             System.out.println(product);
         }
    }

}
