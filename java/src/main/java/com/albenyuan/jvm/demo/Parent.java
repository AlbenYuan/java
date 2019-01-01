package com.albenyuan.jvm.demo;

/**
 * @Author Alben Yuan
 * @Date 2018-10-25 17:30
 */
public class Parent {


    {
        System.out.println("Parent() before");
    }


    public Parent() {
        System.out.println("Parent created.");
    }


    {
        System.out.println("Parent() after");
    }

    static {
        System.out.println("static Parent's var before.");
    }

//    private static Child CHILD = new Child();

    static {
        System.out.println("static Parent's var after.");
    }

}
