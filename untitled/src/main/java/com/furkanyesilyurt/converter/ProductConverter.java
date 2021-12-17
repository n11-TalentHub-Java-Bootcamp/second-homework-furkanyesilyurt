package com.furkanyesilyurt.converter;

import com.furkanyesilyurt.dto.ProductDetailDto;
import com.furkanyesilyurt.dto.ProductDto;
import com.furkanyesilyurt.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    @Mapping(source = "kategoriId", target = "kategori.id")
    Product convertUrunDtoToUrun(ProductDto productDto);

    @Mapping(target = "kategoriId", source = "kategori.id")
    ProductDto convertUrunToUrunDto(Product product);

    @Mapping(source = "fiyat", target = "urunFiyati")
    @Mapping(source = "adi", target = "urunAdi")
    @Mapping(source = "kategori.adi", target = "kategoriAdi")
    ProductDetailDto convertUrunToUrunDetayDto(Product product);

    @Mapping(source = "fiyat", target = "urunFiyati")
    @Mapping(source = "adi", target = "urunAdi")
    @Mapping(source = "kategori.adi", target = "kategoriAdi")
    List<ProductDetailDto> convertAllUrunListToUrunDetayDtoList(List<Product> urunList);
}