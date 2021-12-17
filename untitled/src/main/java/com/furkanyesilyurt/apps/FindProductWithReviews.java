package com.furkanyesilyurt.apps;

import com.furkanyesilyurt.dto.ProductReviewDto;
import com.furkanyesilyurt.entityservices.ProductEntityService;

import java.util.List;

public class FindProductWithReviews {
//Bir ürüne ait yorumların görüldüğü uygulama. Ödev-2
    public static void main(String[] args) {

        ProductEntityService service = new ProductEntityService();
        List<ProductReviewDto> productReviewList = service.findAllReview(1L);

        for (ProductReviewDto productReviewDto : productReviewList) {
            System.out.println(productReviewDto);
        }
    }

}
