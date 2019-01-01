package com.albenyuan.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Alben Yuan
 * @Date 2018-11-30 10:40
 */
public class ExecutorTest {

    private static final Logger logger = LoggerFactory.getLogger(ExecutorTest.class);

    private static final ExecutorService executor = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            executor.execute(new Task(i));
        }
        executor.shutdown();
        Integer num = -1;
        logger.info("-1:{}", Integer.toBinaryString(-1));
        logger.info(" default:{}", Integer.toBinaryString((-1 << 29) - 1));
        logger.info("-1 << 29:{}", Integer.toBinaryString(-1 << 29));
        logger.info(" 0 << 29:{}", Integer.toBinaryString(0 << 29));
        logger.info(" 1 << 29:{}", Integer.toBinaryString(1 << 29));
        logger.info(" 2 << 29:{}", Integer.toBinaryString(2 << 29));
        logger.info(" 3 << 29:{}", Integer.toBinaryString(3 << 29));
    }

    private static class Task implements Runnable {
        private int sn;

        public Task(int i) {
            this.sn = i;
        }

        @Override
        public void run() {
            logger.info("thread name:{},task:{}", Thread.currentThread().getName(), sn);
        }
    }
}
