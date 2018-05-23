package com.albenyuan.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author Alben Yuan
 * @Date 2018-05-23 15:01
 */
public class ThreadPool {

    private static final Integer MAX_THREAD = 10;

    private static final ExecutorService POOL = Executors.newFixedThreadPool(MAX_THREAD);


}
