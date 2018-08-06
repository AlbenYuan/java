package com.albenyuan.mybatis;

import com.albenyuan.mybatis.entity.Menu;
import com.albenyuan.mybatis.mapper.MenuMapper;
import com.albenyuan.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author Alben Yuan
 * @Date 2018-08-01 14:32
 */
public class SqlTest extends MyBatisTester {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void testFetchSize() {
        UserMapper userMapper = getMapper(UserMapper.class);
        logger.info("find one by null: {}", userMapper.findOneById(null));
        logger.info("find one by 1l  : {}", userMapper.findOneById(1l));
        logger.info("find one by 1l  : {}", userMapper.findOneById(1l));
    }

    @Test
    public void testList() {
        Menu menu;
        MenuMapper menuMapper = getMapper(MenuMapper.class);
        logger.debug("1l  :{}", menuMapper.selectChildByFatherId(1l));
        logger.debug("null:{}", menuMapper.selectChildByFatherId(null));
        logger.debug("tree:{}", menuMapper.selectTree());
        menu = menuMapper.selectTreeById(1l);
        logger.debug("1 tree:{}", menu);
        menu = menuMapper.selectDetailById(3l);
        logger.debug("detail:{}", menu);
    }

}
