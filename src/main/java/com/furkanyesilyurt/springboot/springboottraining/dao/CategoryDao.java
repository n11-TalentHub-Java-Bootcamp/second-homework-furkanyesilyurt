package com.furkanyesilyurt.springboot.springboottraining.dao;

import com.furkanyesilyurt.springboot.springboottraining.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {
}
