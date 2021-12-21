package com.furkanyesilyurt.springboot.springboottraining.services.entityServices;

import com.furkanyesilyurt.springboot.springboottraining.dao.UserDao;
import com.furkanyesilyurt.springboot.springboottraining.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return (List<User>) userDao.findAll();
    }

    public List<User> findByUserName(String userName){
        return (List<User>) userDao.findByUserName(userName);
    }

    public User save(User user){
        user = userDao.save(user);
        return user;
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }
}
