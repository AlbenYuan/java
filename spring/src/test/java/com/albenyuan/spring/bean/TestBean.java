package com.albenyuan.spring.bean;

import com.albenyuan.spring.common.SpringBaseTestCase;
import com.albenyuan.spring.lifecycle.CleanupBean;
import com.albenyuan.spring.lifecycle.Disposable;
import com.albenyuan.spring.lifecycle.DisposableBeanImpl;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-08-24 16:38
 */
public class TestBean extends SpringBaseTestCase {

    private static Logger logger = LoggerFactory.getLogger(TestBean.class);

    @Test
    public void testCreate() {
        User userByProperty = application.getBean("userByProperty", User.class);
        User userByConstructor = application.getBean("userByConstructor", User.class);
        Assert.assertTrue("通过构造器创建", null != userByConstructor);
        Assert.assertTrue("通过属性创建", null != userByProperty);
    }

    @Test
    public void testScope() {
        User userForDefault1 = application.getBean("userForDefault", User.class);
        User userForDefault2 = application.getBean("userForDefault", User.class);
        Assert.assertTrue("userForDefault1 == userForDefault2", userForDefault1 == userForDefault2);

        User userForSingleton1 = application.getBean("userForSingleton", User.class);
        User userForSingleton2 = application.getBean("userForSingleton", User.class);
        Assert.assertTrue("userForSingleton1 == userForSingleton2", userForSingleton1 == userForSingleton2);


        User userForPrototype1 = application.getBean("userForPrototype", User.class);
        User userForPrototype2 = application.getBean("userForPrototype", User.class);
        Assert.assertTrue("userForPrototype1 != userForPrototype2", userForPrototype1 != userForPrototype2);
    }
    
}
