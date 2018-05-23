package com.albenyuan.thread.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A
 *
 * @Author Alben Yuan
 * @Date 2018-05-23 14:24
 */
public class ThreadMessage {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private Object lock = new Object();

    private Integer number = 0;

    private Integer count = 100;


    public void run() {
        try {
            Thread threadA = new ThreadA(this);
            Thread threadB = new ThreadA(this);
            threadA.start();
            threadB.start();
            threadA.join();
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void action() {
        synchronized (lock) {
            while (number < count) {
                try {
                    logger.info("{} is running. The number is {}.", Thread.currentThread().getName(), ++number);
                    lock.notifyAll();
                    if (number < count) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private class ThreadA extends Thread {

        private ThreadMessage threadMessage;

        public ThreadA(ThreadMessage message) {
            this.threadMessage = message;
        }

        @Override
        public void run() {
            threadMessage.action();
        }
    }
}
