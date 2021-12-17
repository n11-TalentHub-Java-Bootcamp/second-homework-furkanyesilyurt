package com.furkanyesilyurt.apps;

import com.furkanyesilyurt.entity.Product;
import com.furkanyesilyurt.entityservices.ProductEntityService;

import java.util.List;

public class JoinApp {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<Product> productList = service.findAllUrunByKategoriKirilim(3L);

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}