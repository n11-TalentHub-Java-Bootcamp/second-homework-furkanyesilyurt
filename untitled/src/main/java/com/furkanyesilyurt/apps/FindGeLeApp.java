package com.furkanyesilyurt.apps;

import com.furkanyesilyurt.entity.Product;
import com.furkanyesilyurt.entityservices.ProductEntityService;

import java.math.BigDecimal;
import java.util.List;

public class FindGeLeApp {

    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<Product> productList = service.findAllUrunListByFiyatGeAndFiyatLe(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}