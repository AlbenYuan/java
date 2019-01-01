package com.albenyuan.thread.pool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


/**
 * @Author Alben Yuan
 * @Date 2018-12-03 16:48
 */
public class TestCase {

    @Test
    public void testTask() throws ExecutionException, InterruptedException {
        List<FutureTask<SecondKill>> futureTasks = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            FutureTask<SecondKill> future = (FutureTask<SecondKill>) ThreadPool.POOL.submit(new Task(i));
            futureTasks.add(future);
        }
        System.out.println("submit done!!!");
        for (FutureTask<SecondKill> task : futureTasks) {
            if(task.isDone()){
                System.out.println(task.get());
            }
        }
        ThreadPool.POOL.shutdown();
    }

}
