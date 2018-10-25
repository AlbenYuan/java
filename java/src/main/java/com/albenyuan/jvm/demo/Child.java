package com.albenyuan.jvm.demo;

/**
 * @Author Alben Yuan
 * @Date 2018-10-25 17:29
 */
public class Child extends Parent {
    public Child(){
        System.out.println("Child created.");
    }

    static {
        System.out.println("Child's var before.");
    }

    private static Parent PARENT = new Parent();

    static {
        System.out.println("Child's var after.");
    }

}
