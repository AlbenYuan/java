package com.albenyuan.spring.bean;

import com.albenyuan.spring.autowire.BeanByName;
import com.albenyuan.spring.autowire.BeanByNothing;
import com.albenyuan.spring.autowire.BeanByType;
import com.albenyuan.spring.common.SpringBaseTestCase;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 17:12
 */
public class TestAutowire extends SpringBaseTestCase {

    private static final Logger logger = LoggerFactory.getLogger(TestAutowire.class);

    public TestAutowire() {
        super("classpath:bean-autowire.xml");
    }


    @Test
    public void testByNothing() {
        BeanByNothing bean = application.getBean(BeanByNothing.class);
        logger.info("user:{}", bean.getUser());
        Assert.assertTrue(null != bean.getUser());
    }

    @Test
    public void testByName() {
        BeanByName bean = application.getBean(BeanByName.class);
        Assert.assertTrue(null != bean.getUser());
    }

    @Test
    public void testByType() {
        BeanByType bean = application.getBean(BeanByType.class);
        Assert.assertTrue(null != bean.getAccount());
    }
}
