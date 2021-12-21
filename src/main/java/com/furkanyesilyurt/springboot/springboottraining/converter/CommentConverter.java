package com.furkanyesilyurt.springboot.springboottraining.converter;

import com.furkanyesilyurt.springboot.springboottraining.dto.CommentDto;
import com.furkanyesilyurt.springboot.springboottraining.entity.ProductReview;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentConverter {

    CommentConverter INSTANCE = Mappers.getMapper(CommentConverter.class);

    @Mapping(source = "id", target =   "id")
    ProductReview convertCommentDtoToComment(CommentDto commentDto);

    @Mapping(target = "kategoriId", source = "kategori.id")
    CommentDto convertCommentToCommentDto(ProductReview productReview);

    @AfterMapping
    default void setNulls(@MappingTarget final ProductReview productReview, CommentDto commentDto){
        if(commentDto.getYorum() == null){
            productReview.setYorum(null);
        }
    }
}
