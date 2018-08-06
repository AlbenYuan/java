package com.albenyuan.mybatis;

import com.albenyuan.mybatis.entity.User;
import com.albenyuan.mybatis.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author Alben Yuan
 * @Date 2018-07-30 15:57
 */
public class MyBatis extends MyBatisTester {

    private static Logger logger = LoggerFactory.getLogger(MyBatis.class);

    public static void main(String[] args) throws IOException {
        SqlSessionFactory factoryByXml = getByXml();
        SqlSessionFactory factoryByConfiguration = getConfiguration();
        logger.info("xml:{}", factoryByXml);
        logger.info("configuration:{}", factoryByConfiguration);
//        execute(factoryByConfiguration);
        execute(factoryByXml);
    }

    public static SqlSessionFactory getByXml() throws IOException {
        String resource = "mybatis-base.xml";
        InputStream reader = null;
        reader = Resources.getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        logger.info("factory:{}", sessionFactory);
        return sessionFactory;
    }

    public static SqlSessionFactory getConfiguration() throws IOException {
        SqlSessionFactory factory;
        DataSource dataSource = getDataSource();

        TransactionFactory transactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        /*
         * 装载映射：
         * 1. 通过注解实现简单的sql
         * 2. 通过完全限定名查找对应映射文件
         *
         */
        configuration.addMapper(UserMapper.class);
        factory = new SqlSessionFactoryBuilder().build(configuration);
        return factory;
    }

    private static DataSource getDataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.driver.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/mybatis");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }

    private static Object execute(SqlSessionFactory factory) {
        SqlSession session = factory.openSession();
        List<User> list = null;
        try {
//            session.delete();
//            session.insert();
//            session.update();
//            session.select();
//            session.selectList();
//            session.selectOne();

            list = session.selectList("com.albenyuan.mybatis.mapper.UserMapper.findAll");
            logger.info("list:{}", list);
            UserMapper mapper = session.getMapper(UserMapper.class);
            list = mapper.findAll();
            logger.info("list:{}", list);
        } catch (Exception e) {
            logger.error("error:", e);
        } finally {
            session.close();
        }
        return list;
    }

}
