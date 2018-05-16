package com.albenyuan.thread.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-15 15:18
 */
public class RunnableThread implements Runnable {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void run() {
        // 线程的执行体
        logger.info("runnableThread.run()");


    }
}
