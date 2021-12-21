package com.furkanyesilyurt.springboot.springboottraining.services.entityServices;

import com.furkanyesilyurt.springboot.springboottraining.dao.CommentDao;
import com.furkanyesilyurt.springboot.springboottraining.entity.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentEntityService {

    @Autowired
    private CommentDao commentDao;

    public List<ProductReview> findAll(){
        return commentDao.findAll();
    }
}
