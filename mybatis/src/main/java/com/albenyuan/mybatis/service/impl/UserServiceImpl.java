package com.albenyuan.mybatis.service.impl;

import com.albenyuan.mybatis.entity.User;
import com.albenyuan.mybatis.mapper.UserMapper;
import com.albenyuan.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:51
 */
@Service
@Component
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
}
