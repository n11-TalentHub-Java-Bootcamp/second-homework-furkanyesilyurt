package com.furkanyesilyurt.springboot.springboottraining.converter;

import com.furkanyesilyurt.springboot.springboottraining.dto.UserDto;
import com.furkanyesilyurt.springboot.springboottraining.entity.User;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mapping(source = "id", target = "id")
    User convertUrunDtoToUrun(UserDto userDto);

    @AfterMapping
    default void setNulls(@MappingTarget final User user, UserDto userDto){
        if (userDto.getKullaniciAdi() == null){
            user.setKullaniciAdi(null);
        }
    }
}
