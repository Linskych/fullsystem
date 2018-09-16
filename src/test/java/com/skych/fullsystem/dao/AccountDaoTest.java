package com.skych.fullsystem.dao;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;
import com.skych.fullsystem.controller.AccountController;
import com.skych.fullsystem.model.Account;
import com.skych.fullsystem.model.Right;
import com.skych.fullsystem.model.Role;
import static com.skych.fullsystem.util.CollectionUtil.isNotEmpty;

//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(Suite.class)
//@RunWith(Parameterized.class)
public class AccountDaoTest extends BaseDaoTest{

    private SqlSession sqlSession;
    @Override
    protected SqlSession getCurrentSqlSession() {
        return this.sqlSession;
    }
//    private int a,b,sum;
//    
//    public AccountDaoTest(int a, int b, int sum) {
//        this.a = a;
//        this.b = b;
//        this.sum = sum;
//    }
//    
//    @Parameters(name="{index}: add({0}+{1})={2}")
//    public static Iterable<Object[]> data() {
//        return Arrays.asList(new Object[][] {
//            {1,2,3},{2,3,5},{3,4,7},{4,5,9}
//        });
//    }
//    
//    @Test
//    public void testAdd() {
//        assertEquals(sum, AccountController.add(a, b));
//    }
    
//    @After
//    public void closeSession() {
//        if (null != sqlSession) {
//            sqlSession.close();
//        }
//        sqlSession = null;
//    }
    
    @Test
    public void testUpdateById() {
        sqlSession = getSqlSession();
        Map<String, Object> param = new HashMap<>();
        param.put("id", 1);
        param.put("realname", "Skych");
        param.put("username", "lintianyu");
        sqlSession.update("updateById", param);
        Account account = sqlSession.selectOne("getAccount", 1);
        System.out.println(account.getUsername());
    }
    
    @Test
    public void testGetAccount() {
        sqlSession = getSqlSession();
//        Account param = new Account();
//        param.setId(1);
//        Account account = sqlSession.getMapper(AccountDao.class).getAccount(1, "skych");
        Account account = sqlSession.selectOne("getAccount", 1);
        assertNotNull(account);
        System.out.println(account.getRealname());
    }
    
    @Test
    public void testGetAccountRole() {
        sqlSession = getSqlSession();
        Account account = sqlSession.selectOne("getAccountRole", 1);
        System.out.println("用户名：" + account.getRealname());
        if(isNotEmpty(account.getRoleList())) {
            for (Role role : account.getRoleList()) {
                System.out.println("  角色：" + role.getName());
                if (isNotEmpty(role.getRightList())) {
                    for (Right right : role.getRightList()) {
                        System.out.println("    权限：" + right.getName());
                    }
                }
            }
        }
    }
    
    @Test
    public void testGetAccountRoleRight() {
        sqlSession = getSqlSession();
        Account account = sqlSession.selectOne("getAccountRoleRight", 1);
        System.out.println("用户名：" + account.getRealname());
        if(isNotEmpty(account.getRoleList())) {
            for (Role role : account.getRoleList()) {
                System.out.println("  角色：" + role.getName());
                if (isNotEmpty(role.getRightList())) {
                    for (Right right : role.getRightList()) {
                        System.out.println("    权限：" + right.getName());
                    }
                }
            }
        }
    }
    
    
    @Test
    public void testListAccountByIds() {
        sqlSession = getSqlSession();
//        Map<String, List<Integer>> param = new HashMap<>();
//        param.put("ids", Arrays.asList(1,6,7,8,10));
        List<Account> list = sqlSession.selectList("listAccountByIds", Arrays.asList(1,6,7,8,10));
        assertNotNull(list);
        System.out.println(list.size());
    }
    
    @Test
    public void testSaveAccount() {
        sqlSession = getSqlSession();
        Account account = new Account();
        account.setRealname("Skych Lin");
        account.setUsername("0016004060");
        account.setPassword("root");
        account.setEmail("0016004058@163.com");
        account.setMobile("18759128102");
        account.setHeadImg(new byte[] {1,2,3});
        int insertRows = sqlSession.insert("saveAccount", account);
//        sqlSession.commit();
        System.out.println("insertRows = " + insertRows + ", id = " + account.getId());
    }
    
    @Test
    public void testGetAccountByUsername() {
        sqlSession = getSqlSession();
        Account account = sqlSession.getMapper(AccountDao.class).getAccountByUsername("0016004057");
//        Account account = sqlSession.selectOne("getAccountByUsername", "0016004057");
        System.out.println(account.getRealname());
    }
    
    @Test
    public void testListAccounts() {
        sqlSession = getSqlSession();
        List<Account> list = sqlSession.getMapper(AccountDao.class).listAccounts();
        System.out.println(list.get(4).getHeadImg());
    }
    
    @Test
    public void testUnderLine2Camel() {
        sqlSession = getSqlSession();
        List<Map<String, Object>> list = sqlSession.selectList("underLine2Camel");
        for (Map<String, Object> map : list) {
            for (String key : map.keySet()) {
                System.out.println(key + ": " + map.get(key));
            }
        }
    }
    
    @Test
    public void testListAccountPageMemory() {
        sqlSession = getSqlSession();
        List<Account> list = sqlSession.selectList("listAccountPageMemory", null, new RowBounds(1, 2));
        assertNotNull(list);
        for (Account account : list) {
            System.out.println(account.getRealname());
        }
    }
}
