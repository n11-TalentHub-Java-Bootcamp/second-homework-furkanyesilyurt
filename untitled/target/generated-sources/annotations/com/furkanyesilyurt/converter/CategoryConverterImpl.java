package com.furkanyesilyurt.converter;

import com.furkanyesilyurt.dto.CategoryDto;
import com.furkanyesilyurt.entity.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-17T15:56:29+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class CategoryConverterImpl implements CategoryConverter {

    @Override
    public CategoryDto convertKategoriToKategoriDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setUstKategoriId( categoryUstKategoriId( category ) );
        categoryDto.setId( category.getId() );
        categoryDto.setAdi( category.getAdi() );
        categoryDto.setKirilim( category.getKirilim() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> convertAllKategoriListToKategoriDtoList(List<Category> categoryList) {
        if ( categoryList == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categoryList.size() );
        for ( Category category : categoryList ) {
            list.add( convertKategoriToKategoriDto( category ) );
        }

        return list;
    }

    @Override
    public Category convertKategoriDtoToKategori(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( categoryDto.getId() );
        category.setAdi( categoryDto.getAdi() );
        category.setKirilim( categoryDto.getKirilim() );

        return category;
    }

    private Long categoryUstKategoriId(Category category) {
        if ( category == null ) {
            return null;
        }
        Category ustKategori = category.getUstKategori();
        if ( ustKategori == null ) {
            return null;
        }
        Long id = ustKategori.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
