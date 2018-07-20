package com.albenyuan.mybatis.service.impl;

import com.albenyuan.mybatis.entity.User;
import com.albenyuan.mybatis.mapper.UserMapper;
import com.albenyuan.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findById(Long id) {
        return null == id ? null : userMapper.findById(id);
    }

    @Override
    public User findOneById(Long id) {
        return userMapper.findOneById(id);
    }

    @Override
    public User findByMap(Map<String, Object> map) {
        return userMapper.findByMap(map);
    }

    @Override
    public User findByEntity(User user) {
        return userMapper.findByEntity(user);
    }
}
