package com.skych.fullsystem.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Test;

import com.skych.fullsystem.model.Right;
import com.skych.fullsystem.model.Role;
import com.skych.fullsystem.util.CollectionUtil;

public class RoleDaoTest extends BaseDaoTest {

    private SqlSession sqlSession;
    @Override
    protected SqlSession getCurrentSqlSession() {
        return this.sqlSession;
    }
    /*@After
    public void closeSession() {
        if (null != sqlSession) {
            sqlSession.close();
        }
        sqlSession = null;
    }*/
    
    @Test
    public void testGetRoleRight() {
        sqlSession = getSqlSession();
        Role role = sqlSession.selectOne("getRoleRight", 1);
        System.out.println(role.getName());
        if (CollectionUtil.isNotEmpty(role.getRightList())) {
            for (Right right : role.getRightList()) {
                System.out.println("  " + right.getName() + ": " + right.getUrl());
            }
        }
    }
    
    @Test
    public void testGetRoleByAccountId() {
        sqlSession = getSqlSession();
        List<Role> list = sqlSession.selectList("getRoleByAccountId", 1);
        if (CollectionUtil.isNotEmpty(list)) {
            for (Role role : list) {
                System.out.println("  " + role.getName());
            }
        }
    }
    
    @Test
    public void testGetRoleByAccountIdSelect() {
        sqlSession = getSqlSession();
        Role role = sqlSession.selectOne("getRoleByAccountIdSelect", 6);
        role.equals(null);//触发加载right
        System.out.println(role.getName());
    }
}
