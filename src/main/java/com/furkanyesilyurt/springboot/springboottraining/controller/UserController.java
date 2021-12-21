package com.furkanyesilyurt.springboot.springboottraining.controller;

import com.furkanyesilyurt.springboot.springboottraining.converter.UserConverter;
import com.furkanyesilyurt.springboot.springboottraining.dto.UserDto;
import com.furkanyesilyurt.springboot.springboottraining.entity.User;
import com.furkanyesilyurt.springboot.springboottraining.exception.ProductNotFoundException;
import com.furkanyesilyurt.springboot.springboottraining.services.entityServices.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping("/user")
    public ResponseEntity<Object> saveUser(@Valid @RequestBody UserDto userDto){

        User user = UserConverter.INSTANCE.convertUrunDtoToUrun(userDto);

        user = userEntityService.save(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(user.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{kullaniciAdi}/{telefon}")
    public void deleteById(@PathVariable Long id) {
        userEntityService.deleteById(id);
    }

}
