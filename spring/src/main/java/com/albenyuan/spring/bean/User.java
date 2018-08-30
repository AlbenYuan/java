package com.albenyuan.spring.bean;

/**
 * @Author Alben Yuan
 * @Date 2018-08-24 16:43
 */
public class User {

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
