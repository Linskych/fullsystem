package com.skych.fullsystem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import com.skych.fullsystem.model.Right;
import com.skych.fullsystem.util.CollectionUtil;

public class RightDaoTest extends BaseDaoTest {

    private SqlSession sqlSession;
    @Override
    protected SqlSession getCurrentSqlSession() {
        return this.sqlSession;
    }
//    @After
//    public void closeSession() {
//        if (null != sqlSession) {
//            sqlSession.close();
//        }
//        sqlSession = null;
//    }
    
    @Test
    public void testGetRightByRoleId() {
        sqlSession = getSqlSession();
        List<Right> list = sqlSession.selectList("getRightByRoleId", 1);
        if (CollectionUtil.isNotEmpty(list)) {
            for (Right right : list) {
                System.out.println("  " + right.getName() + ":" + right.getUrl());
            }
        }
    }
}
