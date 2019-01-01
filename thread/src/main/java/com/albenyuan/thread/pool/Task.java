package com.albenyuan.thread.pool;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Alben Yuan
 * @Date 2018-12-03 16:47
 */
public class Task implements Callable<SecondKill> {

    private static final AtomicInteger PRODUCT_ID = new AtomicInteger(0);

    private Integer productId;

    private Integer sn;

    public Task(Integer sn) {
        this.sn = sn;
    }

    @Override
    public SecondKill call() throws Exception {
        SecondKill secondKill = new SecondKill();
        secondKill.setUserId(sn);
        if (PRODUCT_ID.get() <= 10) {
            this.productId = PRODUCT_ID.addAndGet(1);
            if (this.productId <= 10) {
                secondKill.setProductId(this.productId);
            }
        }
        return secondKill;
    }
}
