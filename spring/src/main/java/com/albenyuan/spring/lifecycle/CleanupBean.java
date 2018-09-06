package com.albenyuan.spring.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 16:03
 */
public class CleanupBean {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public void cleanup() {
        logger.info("destroy CleanupBean");
    }

}
