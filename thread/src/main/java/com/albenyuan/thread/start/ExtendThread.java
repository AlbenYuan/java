package com.albenyuan.thread.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-10 13:27
 */
public class ExtendThread extends Thread {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run() {
        logger.info("extendThread.run()");
    }

}
