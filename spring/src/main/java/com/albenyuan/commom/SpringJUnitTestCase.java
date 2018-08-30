package com.albenyuan.commom;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 16:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:beans.xml"
})
public class SpringJUnitTestCase {
}
