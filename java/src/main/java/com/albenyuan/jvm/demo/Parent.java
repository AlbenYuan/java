package com.albenyuan.jvm.demo;

/**
 * @Author Alben Yuan
 * @Date 2018-10-25 17:30
 */
public class Parent {

    public Parent() {
        System.out.println("Parent created.");
    }

    static {
        System.out.println("Parent's var before.");
    }

    private static Child CHILD = new Child();

    static {
        System.out.println("Parent's var after.");
    }

}
