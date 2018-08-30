package com.albenyuan.spring.aware;

import org.springframework.beans.factory.BeanClassLoaderAware;

/**
 * @Author Alben Yuan
 * @Date 2018-08-29 16:22
 */
public class BeanClassLoaderAwarer implements BeanClassLoaderAware {

    private ClassLoader classLoader;

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;

    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }
}
