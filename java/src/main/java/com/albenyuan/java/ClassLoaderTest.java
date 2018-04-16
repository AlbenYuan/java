package com.albenyuan.java;

import com.albenyuan.java.classloader.FileClassLoader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-04-16 16:51
 */
public class ClassLoaderTest {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Test
    public void relation() {
        FileClassLoader loader1 = new FileClassLoader("");

        logger.info("自定义类加载器的父加载器: {}", loader1.getParent());
        logger.info("系统默认的AppClassLoader: {}", ClassLoader.getSystemClassLoader());
        logger.info("AppClassLoader的父类加载器: {}", ClassLoader.getSystemClassLoader().getParent());
        logger.info("ExtClassLoader的父类加载器: {}", ClassLoader.getSystemClassLoader().getParent().getParent());

    }

}
