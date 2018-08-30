package com.albenyuan.spring.flow;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author Alben Yuan
 * @Date 2018-03-09 17:27
 */

public class BeanLifeCycle {
    private static Logger logger = LoggerFactory.getLogger(BeanLifeCycle.class);

    public static void main(String[] args) {

        logger.info("现在开始初始化容器");

        ApplicationContext factory = new ClassPathXmlApplicationContext("classpath:beans.xml");
        logger.info("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person", Person.class);
        logger.info("person:{}", person);

        logger.info("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}