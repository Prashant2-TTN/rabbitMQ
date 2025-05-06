package com.prashant.redis.crud.controller;

import com.prashant.redis.crud.UserDao;
import com.prashant.redis.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping("/create")
    public User create(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{id}")
    public User fetch(@PathVariable("id") String userId){
       return userDao.get(userId);
    }

    @GetMapping
    public Map<Object,Object> getAll(){
        return userDao.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String userId){
        userDao.delete(userId);
    }
}