package com.albenyuan.jvm.demo;

import org.junit.Test;

/**
 * @Author Alben Yuan
 * @Date 2018-10-25 17:33
 */


public class DemoTest {


    @Test
    public void test() {
//        new Child();
        new Parent();
        new Parent();
    }

    @Test
    public void testStaticClass() {
        new InnerClass().innerClass();
//        new InnerClass.StaticClass();

    }


}
