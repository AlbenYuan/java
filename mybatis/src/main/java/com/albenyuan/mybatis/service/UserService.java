package com.albenyuan.mybatis.service;

import com.albenyuan.mybatis.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:51
 */
@Service
public interface UserService {
    List<User> findAll();

    User findById(Long id);
}
