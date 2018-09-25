package com.albenyuan.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-09-25 15:27
 */
public class UserAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserAspect.class);


    public void before() {
        logger.info("before:{}");
    }

    public void after() {
        logger.info("after:{]");
    }

    public void afterReturn() {
        logger.info("after:{}");
    }

    public void afterThrow() {
        logger.info("after:{}");
    }
}
