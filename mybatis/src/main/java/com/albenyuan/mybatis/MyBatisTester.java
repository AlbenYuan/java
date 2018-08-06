package com.albenyuan.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author Alben Yuan
 * @Date 2018-08-01 14:26
 */
public class MyBatisTester {

    public static SqlSessionFactory getSessionFactory() {
        return InnerEnum.INSTANCE.getSqlSessionFactory();
    }

    private enum InnerEnum {

        INSTANCE();
        private SqlSessionFactory sqlSessionFactory;

        InnerEnum() {
            try {
                String resource = "mybatis-base.xml";
                InputStream reader = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public SqlSessionFactory getSqlSessionFactory() {
            return sqlSessionFactory;
        }
    }

    <T> T getMapper(Class<T> clazz) {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.getMapper(clazz);
    }

    SqlSession getSqlSession() {
        return getSessionFactory().openSession();
    }

}
