package com.albenyuan.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-09-03 14:58
 */
public class InitBean {

    private static Logger logger = LoggerFactory.getLogger(InitBean.class);

    public void init() {
        logger.info("调用配置的初始化方法");
    }

}
