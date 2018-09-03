package com.albenyuan.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author Alben Yuan
 * @Date 2018-09-03 15:40
 */
public class Initializing implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(Initializing.class);


    public void initializing() {

        logger.info("调用了配置的初始化方法");
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("调用了InitializingBean的afterPropertiesSet的实现方法");

    }
}
