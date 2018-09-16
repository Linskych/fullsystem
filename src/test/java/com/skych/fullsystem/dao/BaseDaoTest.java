package com.skych.fullsystem.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.BeforeClass;

public abstract class BaseDaoTest {

    private static SqlSessionFactory sqlSessionFactory;
    
    @BeforeClass
    public static void init() {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml");){
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @After
    public void closeSession() {
        if (null != getCurrentSqlSession()) {
            getCurrentSqlSession().close();
            System.out.println("close sqlSession.");
        }
    }
    
    protected SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
    
    protected abstract SqlSession getCurrentSqlSession();
}
