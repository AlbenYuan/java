package com.albenyuan.spring.autowire;

import com.albenyuan.spring.bean.User;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 17:04
 */
public class BeanByType {
    private User account;

    public User getAccount() {
        return account;
    }

    public void setAccount(User account) {
        this.account = account;
    }
}
