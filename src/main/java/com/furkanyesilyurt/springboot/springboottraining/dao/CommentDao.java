package com.furkanyesilyurt.springboot.springboottraining.dao;

import com.furkanyesilyurt.springboot.springboottraining.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<ProductReview, Long> {
}
