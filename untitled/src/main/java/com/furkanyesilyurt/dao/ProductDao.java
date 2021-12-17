package com.furkanyesilyurt.dao;

import com.furkanyesilyurt.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {

    @Query("select product from Product product where product.kategori.id = :kategoriId")
    List<Product> findAllByKategoriOrderByIdDesc(Long kategoriId);

}