package com.albenyuan.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @Author Alben Yuan
 * @Date 2018-11-12 10:46
 */
public class Person implements Serializable {

    private final static Logger logger = LoggerFactory.getLogger(Person.class);

    private String name;


    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.albenyuan.reflect.Person");

        Person person = (Person) clazz.newInstance();
        logger.info("person:{}", person);

    }

}
