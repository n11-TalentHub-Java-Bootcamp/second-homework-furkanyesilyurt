package com.furkanyesilyurt.converter;

import com.furkanyesilyurt.dto.CategoryDto;
import com.furkanyesilyurt.entity.Category;
import com.furkanyesilyurt.dto.CategoryDto;
import com.furkanyesilyurt.entity.Category;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryConverter {

    CategoryConverter INSTANCE = Mappers.getMapper(CategoryConverter.class);

    @Mapping(target = "ustKategoriId", source = "ustKategori.id")
    CategoryDto convertKategoriToKategoriDto(Category category);

    @Mapping(target = "ustKategoriId", source = "ustKategori.id")
    List<CategoryDto> convertAllKategoriListToKategoriDtoList(List<Category> categoryList);

//    @Mapping(target = "ustKategori.id", source = "ustKategoriId", expression = "java(null))
//    @Mapping(target = "ustKategori.id", source = "ustKategoriId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)

    //    @Mapping(target = "ustKategori.id", expression = "java(kategoriDto.getUstKategoriId() == null ? null : " +
//            "kategoriDto.getUstKategoriId())")
    Category convertKategoriDtoToKategori(CategoryDto categoryDto);
}