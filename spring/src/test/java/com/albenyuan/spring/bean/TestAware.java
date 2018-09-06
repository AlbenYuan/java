package com.albenyuan.spring.bean;

import com.albenyuan.spring.aware.AwareSequence;
import com.albenyuan.spring.common.SpringBaseTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-09-06 16:41
 */

public class TestAware extends SpringBaseTestCase {

    public TestAware() {
        super("classpath:bean-aware.xml");
    }

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void aware() {
        /**
         * 1. setBeanName
         * 2. setBeanClassLoader
         * 3. setBeanFactory
         * 4. setEnvironment
         * 5. setEmbeddedValueResolver
         * 6. setResourceLoader
         * 7. setApplicationEventPublisher
         * 8. setMessageSource
         * 9. setApplicationContext
         */
        logger.info("AwareSequence:{}", application.getBean(AwareSequence.class));
    }
}
