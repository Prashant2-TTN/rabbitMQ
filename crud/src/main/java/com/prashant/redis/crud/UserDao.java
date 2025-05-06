package com.prashant.redis.crud;

import com.prashant.redis.crud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.UUID;

@Repository
public class UserDao {

    private static final String key="USER";

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    public User save(User user){
        redisTemplate.opsForHash().put(key,user.getUserId(),user);
        return user;
    }


    public User get(String id){
        return (User)redisTemplate.opsForHash().get(key,id);
    }

    public Map<Object,Object> getAll(){
       return redisTemplate.opsForHash().entries(key);
    }

    public void delete(String id){
        redisTemplate.opsForHash().delete(key,id);
    }

}
