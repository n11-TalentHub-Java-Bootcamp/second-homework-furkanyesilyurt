package com.furkanyesilyurt.converter;

import com.furkanyesilyurt.dto.ProductDetailDto;
import com.furkanyesilyurt.dto.ProductDto;
import com.furkanyesilyurt.entity.Category;
import com.furkanyesilyurt.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-17T15:56:29+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
public class ProductConverterImpl implements ProductConverter {

    @Override
    public Product convertUrunDtoToUrun(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setKategori( productDtoToCategory( productDto ) );
        product.setId( productDto.getId() );
        product.setAdi( productDto.getAdi() );
        product.setFiyat( productDto.getFiyat() );
        product.setKayitTarihi( productDto.getKayitTarihi() );

        return product;
    }

    @Override
    public ProductDto convertUrunToUrunDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setKategoriId( productKategoriId( product ) );
        productDto.setId( product.getId() );
        productDto.setAdi( product.getAdi() );
        productDto.setFiyat( product.getFiyat() );
        productDto.setKayitTarihi( product.getKayitTarihi() );

        return productDto;
    }

    @Override
    public ProductDetailDto convertUrunToUrunDetayDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDetailDto productDetailDto = new ProductDetailDto();

        productDetailDto.setUrunFiyati( product.getFiyat() );
        productDetailDto.setUrunAdi( product.getAdi() );
        productDetailDto.setKategoriAdi( productKategoriAdi( product ) );

        return productDetailDto;
    }

    @Override
    public List<ProductDetailDto> convertAllUrunListToUrunDetayDtoList(List<Product> urunList) {
        if ( urunList == null ) {
            return null;
        }

        List<ProductDetailDto> list = new ArrayList<ProductDetailDto>( urunList.size() );
        for ( Product product : urunList ) {
            list.add( convertUrunToUrunDetayDto( product ) );
        }

        return list;
    }

    protected Category productDtoToCategory(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( productDto.getKategoriId() );

        return category;
    }

    private Long productKategoriId(Product product) {
        if ( product == null ) {
            return null;
        }
        Category kategori = product.getKategori();
        if ( kategori == null ) {
            return null;
        }
        Long id = kategori.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String productKategoriAdi(Product product) {
        if ( product == null ) {
            return null;
        }
        Category kategori = product.getKategori();
        if ( kategori == null ) {
            return null;
        }
        String adi = kategori.getAdi();
        if ( adi == null ) {
            return null;
        }
        return adi;
    }
}
