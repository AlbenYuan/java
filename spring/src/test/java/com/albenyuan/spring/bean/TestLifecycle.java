package com.albenyuan.spring.bean;

import com.albenyuan.spring.common.SpringBaseTestCase;
import com.albenyuan.spring.lifecycle.CleanupBean;
import com.albenyuan.spring.lifecycle.Disposable;
import com.albenyuan.spring.lifecycle.DisposableBeanImpl;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 16:46
 */
public class TestLifecycle extends SpringBaseTestCase {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public TestLifecycle() {
        super("classpath:bean-lifecycle.xml");
    }


    @Test
    public void testInit() {
        logger.info("bean:{}", application.getBean("initBean"));
        logger.info("bean:{}", application.getBean("initializingBeanImpl"));
        logger.info("bean:{}", application.getBean("initializing"));
    }

    @Test
    public void testDestroy() {
        logger.info("CleanupBean:{}", application.getBean(CleanupBean.class));
        logger.info("Disposable:{}", application.getBean(Disposable.class));
        logger.info("DisposableBeanImpl:{}", application.getBean(DisposableBeanImpl.class));
    }


}
