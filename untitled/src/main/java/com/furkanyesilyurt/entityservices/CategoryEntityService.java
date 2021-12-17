package com.furkanyesilyurt.entityservices;

import com.furkanyesilyurt.dao.CategoryDao;
import com.furkanyesilyurt.entity.Category;

import java.util.List;

public class CategoryEntityService {

    private CategoryDao categoryDao;

    public CategoryEntityService() {
        categoryDao = new CategoryDao();
    }

    public List<Category> findAll(){
        return categoryDao.findAll();
    }

}
