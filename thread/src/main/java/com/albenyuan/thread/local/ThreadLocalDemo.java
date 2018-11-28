package com.albenyuan.thread.local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Author Alben Yuan
 * @Date 2018-11-27 11:04
 */
public class ThreadLocalDemo {

    private static final ThreadLocal LOCAL = new ThreadLocal();


    private static final ExecutorService POOL = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {



    }
}
