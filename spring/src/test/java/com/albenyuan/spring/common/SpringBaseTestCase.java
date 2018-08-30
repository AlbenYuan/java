package com.albenyuan.spring.common;

import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Alben Yuan
 * @Date 2018-08-24 16:31
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class SpringBaseTestCase {

    protected ApplicationContext application = new ClassPathXmlApplicationContext("classpath:bean-test.xml");

    protected void setContext(String xml) {
        application = new ClassPathXmlApplicationContext(xml);
    }

}
