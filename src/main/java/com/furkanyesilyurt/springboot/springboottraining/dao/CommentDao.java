package com.furkanyesilyurt.springboot.springboottraining.dao;

import com.furkanyesilyurt.springboot.springboottraining.entity.ProductReview;
import com.furkanyesilyurt.springboot.springboottraining.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<ProductReview, Long> {

    @Query("select prouctReview from ProductReview prouctReview where prouctReview.kullaniciId = :kullaniciId")
    List<User> findByKullaniciId(String kullaniciId);
}
