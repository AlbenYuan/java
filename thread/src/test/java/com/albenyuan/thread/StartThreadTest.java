package com.albenyuan.thread;

import com.albenyuan.thread.start.CallableThread;
import com.albenyuan.thread.start.ExtendThread;
import com.albenyuan.thread.start.RunnableThread;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author Alben Yuan
 * @Date 2018-05-15 15:22
 */
public class StartThreadTest {


    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void createThread() throws Exception {

        // 1. 继承Thread类，重写run方法
        Thread thread = new ExtendThread();
        thread.start();

        // 2. 实现Runnable接口， 实现run方法
        Runnable runnable = new RunnableThread();
        new Thread(runnable) {
            Logger logger = LoggerFactory.getLogger(getClass());

            @Override
            public void run() {
                logger.info("new Thread().run()");
                super.run();
            }
        }.start();


        // 3. 实现Callable接口，实现call方法
        Callable callable = new CallableThread();
        FutureTask future = new FutureTask<Integer>(callable);
        new Thread(future) {
            Logger logger = LoggerFactory.getLogger(getClass());

            @Override
            public void run() {
                logger.info("new Thread().run()");
                super.run();
            }
        }.start();
        logger.info("task get:{}", future.get());

    }
}
