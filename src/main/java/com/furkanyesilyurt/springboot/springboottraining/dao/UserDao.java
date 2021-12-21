package com.furkanyesilyurt.springboot.springboottraining.dao;

import com.furkanyesilyurt.springboot.springboottraining.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    @Query("select user from User user where user.kullaniciAdi = :userName")
    List<User> findByUserName(String userName);
}
