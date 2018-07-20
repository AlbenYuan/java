package com.albenyuan.mybatis.mapper;

import com.albenyuan.mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:51
 */
@Repository
public interface UserMapper {

    List<User> findAll();

    User findById(Long id);

}
