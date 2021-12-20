package com.furkanyesilyurt.springboot.springboottraining.services;

import com.furkanyesilyurt.springboot.springboottraining.converter.ResponseConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WebService {

    @Autowired
    @Qualifier("XML")
    private ResponseConverter responseConverter;

    public void convertResponse(){

        responseConverter.convert();
    }
}
