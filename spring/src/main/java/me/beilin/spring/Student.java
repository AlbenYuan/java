package me.beilin.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-03-21 23:34
 */

public class Student {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    {
//        System.out.println("Student1");
//    }
//
//    static {
//        System.out.println("Student Static");
//    }
//
//    {
//        System.out.println("Student2");
//    }


    public Student() {
        logger.info("[构造器]Student");
    }


    public static void main(String[] args) {
        Student person = new Student();

    }
}
