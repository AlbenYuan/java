package com.albenyuan.mybatis;

import com.albenyuan.mybatis.common.SpringJUnitTestCase;
import com.albenyuan.mybatis.entity.User;
import com.albenyuan.mybatis.service.UserService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @Author Alben Yuan
 * @Date 2018-07-20 15:49
 */
public class UserTester extends SpringJUnitTestCase {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Test
    public void findAll() {
        logger.info("findAll:{}", userService.findAll());
    }

    @Test
    public void findById() {
        logger.info("findById:{}", userService.findById(1l));
    }

    @Test
    public void findOneById() {
        logger.info("findById:{}", userService.findOneById(1l));
    }

    @Test
    public void findByMap() {
        logger.info("findByMap:{}", userService.findByMap(new HashMap<String, Object>() {
            {
                this.put("id", 1l);
            }
        }));
    }

    @Test
    public void findByEntity() {
        User user = new User();
        logger.info("findByEntity:{}", userService.findByEntity(user));
        user.setId(1l);
        logger.info("findByEntity:{}", userService.findByEntity(user));
    }
}
