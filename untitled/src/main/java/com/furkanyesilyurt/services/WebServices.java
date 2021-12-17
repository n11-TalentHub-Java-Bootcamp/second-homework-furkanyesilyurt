package com.furkanyesilyurt.services;

import com.furkanyesilyurt.converter.ResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WebServices {

    @Autowired
//    @Qualifier("xml")
    private ResponseConverter xmlResponseConverter;

    public void covertResponse(){
        xmlResponseConverter.convert();
    }
}