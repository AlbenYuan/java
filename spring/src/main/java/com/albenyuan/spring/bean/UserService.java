package com.albenyuan.spring.bean;

/**
 * @Author Alben Yuan
 * @Date 2018-09-25 15:39
 */
public class UserService {
    public User updateUser(User user) {
        user.setUsername(user.getUsername());
        return user;
    }
}
