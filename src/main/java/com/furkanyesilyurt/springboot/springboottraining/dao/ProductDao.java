package com.furkanyesilyurt.springboot.springboottraining.dao;

import com.furkanyesilyurt.springboot.springboottraining.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends CrudRepository<Product, Long> {
}
