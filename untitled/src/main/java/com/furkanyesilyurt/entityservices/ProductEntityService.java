package com.furkanyesilyurt.entityservices;

import com.furkanyesilyurt.dao.ProductDao;
import com.furkanyesilyurt.dto.ProductDetailDto;
import com.furkanyesilyurt.dto.ProductReviewAllDto;
import com.furkanyesilyurt.dto.ProductReviewDto;
import com.furkanyesilyurt.dto.UserReviewsDto;
import com.furkanyesilyurt.entity.Product;
//import com.furkanyesilyurt.entity.UrunYorum;

import java.math.BigDecimal;
import java.util.List;

public class ProductEntityService {

    private ProductDao productDao;

    public ProductEntityService() {
        productDao = new ProductDao();
    }

    public List<Product> findAll(){
        return productDao.findAll();
    }

    public Product findById(Long id){
        return productDao.findById(id);
    }

    public List<Product> findAllUrunListByFiyatGeAndFiyatLe(BigDecimal fiyatGe, BigDecimal fiyatLe){
        return productDao.findAllUrunListByFiyatGeAndFiyatLe(fiyatGe, fiyatLe);
    }

    public List<Product> findAllUrunListByFiyatBetween(BigDecimal fiyatGe, BigDecimal fiyatLe){
        return productDao.findAllUrunListByFiyatBetween(fiyatGe, fiyatLe);
    }

    public List<Product> findAllUrunByKategoriKirilim(Long kirilim){
        return productDao.findAllUrunByKategoriKirilim(kirilim);
    }

    public List<ProductDetailDto> findAllUrunDetayDtoByKategoriKirilim(Long kirilim) {
        return productDao.findAllUrunDetayDtoByKategoriKirilim(kirilim);
    }

    public List<ProductReviewDto> findAllReview(Long id){
        return productDao.findAllReview(id);
    }

    public List<ProductReviewAllDto> findAllProductsWithReview(){
        return productDao.findAllProductsWithReview();
    }

    public List<UserReviewsDto> findUsersReview(){
        return productDao.findUsersReview();
    }

}
