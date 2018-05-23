package com.albenyuan.thread.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Alben Yuan
 * @Date 2018-05-21 09:42
 */
public class UtilLock {

    private static Logger logger = LoggerFactory.getLogger(UtilLock.class);


    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private Condition otherCondition = lock.newCondition();

    public void useLock() {

        final UtilLock utilLock = this;

        new Thread() {

            @Override
            public void run() {
                utilLock.lock(false);
            }
        }.start();
        new Thread() {

            @Override
            public void run() {
                utilLock.lock(true);
            }
        }.start();

    }

    public void lockAndSy() {
        final UtilLock utilLock = this;
        new Thread() {

            @Override
            public void run() {
                String name = Thread.currentThread().getName();

                synchronized (lock) {
                    logger.info("{} get synchronized lock", name);
                    logger.info("{} beginning sleep", name);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    logger.info("{} wakeup ", name);
                }
            }
        }.start();
        new Thread() {

            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                lock.lock();
                logger.info("{} get lock lock", name);
                logger.info("{} beginning sleep", name);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("{} wakeup ", name);
                lock.unlock();


            }
        }.start();
    }

    private void lock(boolean exception) {

        try {
            if (!exception) {
                Thread.sleep(100);
            }
            // 手动获取锁
            lock.lock();
            String threadName = Thread.currentThread().getName();
            logger.info("{} is running and lock.", threadName);

            if (exception) {
                throw new RuntimeException("业务出现异常");
            }
//            lock.unlock(); //  如果业务异常，则不会手动释放锁

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            // 应当在此处手动释放锁
            lock.unlock();
        }

        logger.info("method  is end!");
    }

    public void useCondition() {
        final UtilLock utilLock = this;
        new Thread() {

            @Override
            public void run() {
                utilLock.conditionAwait(true);
            }
        }.start();

        new Thread() {

            @Override
            public void run() {
                utilLock.conditionAwait(false);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                utilLock.conditionSignal(false);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                utilLock.conditionSignal(true);
            }
        }.start();
    }

    private void conditionAwait(boolean other) {

        lock.lock();
        String threadName = Thread.currentThread().getName();
        logger.info("{} is running.", threadName);
        try {
            if (other) {
                logger.info("{} other condition await...", threadName);
                otherCondition.await();
                logger.info("{} other condition restart running.", threadName);
            } else {
                logger.info("{} condition await...", threadName);
                condition.await();
                logger.info("{} other condition restart running.", threadName);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();

    }

    private void conditionSignal(boolean other) {
        String threadName = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.lock();
        if (other) {
            logger.info("{} other condition signalAll...", threadName);
            otherCondition.signalAll();
        } else {
            logger.info("{} condition signalAll...", threadName);
            condition.signalAll();
        }
        lock.unlock();

    }

    public static void main(String[] args) {

        UtilLock lock = new UtilLock();
//        lock.useLock();

//        lock.useCondition();

        lock.lockAndSy();
    }


}
