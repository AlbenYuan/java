package com.albenyuan.spring.flow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @Author Alben Yuan
 * @Date 2018-03-09 17:24
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    public MyBeanPostProcessor() {
        super();
        logger.info("这是BeanPostProcessor实现类构造器！！");
    }

    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        logger.info("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        logger.info("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg0;
    }
}
