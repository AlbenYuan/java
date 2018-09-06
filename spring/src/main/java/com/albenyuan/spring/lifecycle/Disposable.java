package com.albenyuan.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 16:06
 */
public class Disposable implements DisposableBean {


    Logger logger = LoggerFactory.getLogger(getClass());


    public void cleanup() {
        logger.info("cleanup Disposable");
    }

    @Override
    public void destroy() throws Exception {
        logger.info("destroy Disposable");
    }
}
