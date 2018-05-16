package com.albenyuan.thread.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @Author Alben Yuan
 * @Date 2018-05-15 15:19
 */
public class CallableThread implements Callable<Integer> {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Integer call() throws Exception {
        logger.info("callableThread.call()");
        return 1;
    }
}
