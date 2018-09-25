package com.albenyuan.spring.autowire;

import com.albenyuan.spring.bean.User;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 17:04
 */
public class BeanByName {


    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
