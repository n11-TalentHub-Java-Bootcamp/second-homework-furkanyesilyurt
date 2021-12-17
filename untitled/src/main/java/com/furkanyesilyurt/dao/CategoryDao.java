package com.furkanyesilyurt.dao;

import com.furkanyesilyurt.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, Long> {

    List<Category> findAllByUstKategoriIsNullOrderByAdiDesc();

    List<Category> findAllByAdiEndsWith(String adi);

}