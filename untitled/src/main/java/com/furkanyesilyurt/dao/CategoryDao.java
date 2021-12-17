package com.furkanyesilyurt.dao;

import com.furkanyesilyurt.base.BaseDao;
import com.furkanyesilyurt.entity.Category;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao extends BaseDao {

    public List<Category> findAll(){

        Query query = getCurrentSession().createQuery(
                "select kategori from Kategori kategori");

        return query.list();
    }
}