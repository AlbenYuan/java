package com.albenyuan.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author Alben Yuan
 * @Date 2018-09-03 15:37
 */
public class InitializingBeanImpl implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(InitializingBeanImpl.class);

    @Override
    public void afterPropertiesSet() throws Exception {

        logger.info("调用重写InitializingBean的afterPropertiesSet方法");
    }
}
