package com.albenyuan.mybatis;

import com.albenyuan.mybatis.entity.Menu;
import com.albenyuan.mybatis.entity.User;
import com.albenyuan.mybatis.mapper.MenuMapper;
import com.albenyuan.mybatis.mapper.UserMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Map;

/**
 * @Author Alben Yuan
 * @Date 2018-08-01 14:32
 */
public class SqlTest extends MyBatisTester {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private MenuMapper menuMapper;

    private UserMapper userMapper;


    @Before
    public void before() {
        menuMapper = getMapper(MenuMapper.class);
        userMapper = getMapper(UserMapper.class);
    }

    @Test
    public void testParam() {
        logger.debug("find one by null: {}", userMapper.findById(null));
        logger.debug("find one by null: {}", userMapper.findOneById(null));
        logger.debug("find one by 1l  : {}", userMapper.findById(1l));
        logger.debug("find one by 1l  : {}", userMapper.findOneById(1l));
    }

    @Test
    public void testFetchSize() {
        // select  from  db
        logger.debug("find one by null: {}", userMapper.findOneById(null));
        // select from db
        logger.debug("find one by 1l  : {}", userMapper.findOneById(1l));

        // select from cache
        logger.debug("find one by 1l  : {}", userMapper.findOneById(1l));
    }

    @Test
    @Rollback
    public void testList() {
        Menu menu;
        logger.debug("1l  :{}", menuMapper.selectChildByFatherId(1l));
        logger.debug("null:{}", menuMapper.selectChildByFatherId(null));
        logger.debug("tree:{}", menuMapper.selectTree());
        menu = menuMapper.selectTreeById(1l);
        logger.debug("1 tree:{}", menu);
        menu = menuMapper.selectDetailById(3l);
        logger.debug("detail:{}", menu);
    }


    @Test
    public void testPage() {
        PageHelper.startPage(1, 2);
        List<User> list = userMapper.findAll();
        PageInfo<User> page = new PageInfo(list, 2);
        logger.info("page:{}", page);

    }

    @Test
    public void testMapKey() {
        Map<Integer, User> map = userMapper.selectUserMap();
        logger.debug("map key:{}", map);
    }
}
