package com.albenyuan.mybatis;

import com.albenyuan.mybatis.common.SpringJUnitTestCase;
import com.albenyuan.mybatis.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:49
 */
public class UserTester extends SpringJUnitTestCase {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private UserService userService;

    @Test
    public void findAll() {
        logger.info("findAll:{}", userService.findAll());
    }

    @Test
    public void findById() {
        logger.info("findById:{}", userService.findById(1l));
    }
}
