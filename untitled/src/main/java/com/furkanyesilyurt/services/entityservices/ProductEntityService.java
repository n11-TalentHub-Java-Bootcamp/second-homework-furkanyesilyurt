package com.furkanyesilyurt.services.entityservices;

import com.furkanyesilyurt.dao.ProductDao;
import com.furkanyesilyurt.dto.ProductDetailDto;
import com.furkanyesilyurt.dto.ProductReviewAllDto;
import com.furkanyesilyurt.dto.ProductReviewDto;
import com.furkanyesilyurt.dto.UserReviewsDto;
import com.furkanyesilyurt.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
//import com.furkanyesilyurt.entity.UrunYorum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductEntityService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll(){
        return (List<Product>) productDao.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optionalProduct = productDao.findById(id);

        Product product = null;
        if (optionalProduct.isPresent()){
            product = optionalProduct.get();
        }

        return product;
    }

    public Product save(Product product){
        product = productDao.save(product);

        return product;
    }

    public void delete(Product product){
        productDao.delete(product);
    }

    public void deleteById(Long id){
        productDao.deleteById(id);
    }

    public long count(){
        return productDao.count();
    }

    public List<Product> findAllByKategoriOrderByIdDesc(Long kategoriId){
        return productDao.findAllByKategoriOrderByIdDesc(kategoriId);
    }

}
