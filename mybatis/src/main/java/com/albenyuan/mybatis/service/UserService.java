package com.albenyuan.mybatis.service;

import com.albenyuan.mybatis.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:51
 */
public interface UserService {
    List<User> findAll();

    User findById(Long id);


    User findOneById(Long id);

    User findByMap(Map<String, Object> map);

    User findByEntity(User user);
}
