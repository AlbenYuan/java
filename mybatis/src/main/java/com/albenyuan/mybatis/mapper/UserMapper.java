package com.albenyuan.mybatis.mapper;

import com.albenyuan.mybatis.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:51
 */
@Repository
public interface UserMapper {

    List<User> findAll();

    User findById(Long id);

    User findOneById(Long id);

    User findByEntity(User user);

    User findByMap(Map<String, Object> map);

}
