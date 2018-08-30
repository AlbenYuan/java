package com.albenyuan.spring.aware;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @Author Alben Yuan
 * @Date 2018-08-29 16:25
 */
public class BeanNameAwarer implements BeanNameAware {

    private String name;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
