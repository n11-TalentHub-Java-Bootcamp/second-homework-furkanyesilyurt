package com.furkanyesilyurt.springboot.springboottraining.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("XML")
public class XmlResponseConverter implements ResponseConverter {

    @Override
    public void convert(){
        System.out.println("XML");;
    }
}
