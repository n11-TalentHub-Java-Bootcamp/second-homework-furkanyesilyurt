package com.furkanyesilyurt.springboot.springboottraining.controller;

import com.furkanyesilyurt.springboot.springboottraining.entity.User;
import com.furkanyesilyurt.springboot.springboottraining.services.entityServices.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("")
    public List<User> findAllUsers(){
        return userEntityService.findAll();
    }

    @GetMapping("/{userName}")
    public List<User> findByUserName(@PathVariable String userName){
        List<User> userList = userEntityService.findByUserName(userName);

        return userList;
    }

}
