package com.albenyuan.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 16:05
 */
public class DisposableBeanImpl implements DisposableBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void destroy() throws Exception {
        logger.info("destroy DisposableBeanImpl");
    }
}
