package com.albenyuan.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-05-21 16:49
 */
public class ThreadTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Object object = new Object();

    @Test
    public void testWait() throws Exception {

        Thread thread1 = new Thread() {
            @Override
            public void run() {

                logger.info("thread: {} ", Thread.currentThread().getName());
                synchronized (object) {
                    logger.info("thread begin wait...");
                    try {
                        object.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    logger.info("thread restart...");

                }

            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                logger.info("thread: {} ", Thread.currentThread().getName());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object) {
                    object.notify();
                    logger.info("have notified!!!");
                }

            }
        };
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        logger.info("application end!");


    }


    @Test
    public void testJoin() throws Exception {

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    try {
                        logger.info("thread1: {}", i);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        logger.info("thread2: {}", i);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        thread1.start();
        thread2.start();
        thread1.join(4000);

    }
}
