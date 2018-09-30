package com.albenyuan.spring.bean;

import com.albenyuan.spring.common.SpringBaseTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-09-28 14:32
 */
public class TestFlow extends SpringBaseTestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestFlow.class);

    public TestFlow() {
        super("classpath:bean-first.xml");
    }


    @Test
    public void init() {
        Assert.assertTrue("Application is't active ", application.isActive());
    }
}
