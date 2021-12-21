package com.furkanyesilyurt.springboot.springboottraining.services.entityServices;

import com.furkanyesilyurt.springboot.springboottraining.dao.CommentDao;
import com.furkanyesilyurt.springboot.springboottraining.entity.ProductReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentEntityService {

    @Autowired
    private CommentDao commentDao;

    public List<ProductReview> findAll(){
        return (List<ProductReview>) commentDao.findAll();
    }

    public void deleteById(Long id){
        commentDao.deleteById(id);
    }

    public ProductReview save(ProductReview productReview){
        productReview = commentDao.save(productReview);
        return productReview;
    }

    public ProductReview findByKullaniciId(String kullaniciId){
        Optional<ProductReview> optionalUrun = commentDao.findByKullaniciId(kullaniciId);

        ProductReview productReview = null;
        if (optionalUrun.isPresent()){
            productReview = optionalUrun.get();
        }

        return productReview;
    }

}
