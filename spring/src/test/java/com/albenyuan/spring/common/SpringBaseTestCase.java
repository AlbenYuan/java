package com.albenyuan.spring.common;

import com.albenyuan.commom.SpringJUnitTestCase;
import org.junit.After;
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

    protected ClassPathXmlApplicationContext application;

    protected SpringBaseTestCase() {
        this("classpath:bean-test.xml");
    }

    protected SpringBaseTestCase(String xml) {
        application = new ClassPathXmlApplicationContext(xml.split("[,\\s]+"));
        application.start();
    }

    @After
    public void after() {
        if (null != application) {
            application.destroy();
        }
    }

}
