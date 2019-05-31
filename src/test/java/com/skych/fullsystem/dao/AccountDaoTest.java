package com.skych.fullsystem.dao;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.UTFDataFormatException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.spi.CharsetProvider;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.mchange.v2.sql.filter.SynchronizedFilterDataSource;
import com.skych.fullsystem.controller.AccountController;
import com.skych.fullsystem.model.Account;
import com.skych.fullsystem.model.Customer;
import com.skych.fullsystem.model.Right;
import com.skych.fullsystem.model.Role;
import com.skych.fullsystem.util.Encoder;
import com.skych.fullsystem.util.SignatureUtils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;

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
      @Test
      public void learning() {
          String pre = "JXSXZ";
          String code = "JXSXZ20190505001";
          System.out.println(code.substring(pre.length()-1));
          
          String path = "/1/1235/5456/";
          System.out.println(path.substring(0, path.length() -1));
          
          System.out.println(UUID.randomUUID().toString().replace("-", ""));
          
          System.out.println(new Sha256Hash("admin").toHex());
          //212c8d392b02492b97e1871bdf9e554a
      }
    
    
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
    
    @Test
    public void paraseAra() {
        
//        
//        Customer orig = new Customer();
//        orig.setName("name");
//        
//        BeanUtil.copyProperties(orig, dest, CopyOptions.create().setIgnoreNullValue(true));
//        System.out.println(dest.getCode());
        
//        nubiashop();
        
        //*********先保留，勿删除******
        
//        System.out.println("md5: " + Encoder.md5("cs_prm"));
//        System.out.println("md5: " + Encoder.md5("cs_rms_store"));
//        System.out.println("md5: " + Encoder.md5("cs_itmonitor"));
        System.out.println("key: " + Encoder.md5("sprm_oa_1558668839"));
        System.out.println("pwd: " + Encoder.md5("sprm_oa_20160630"));
        System.out.println("key: " + Encoder.md5("sprm_oa_1558678265"));
        System.out.println("pwd: " + Encoder.md5("sprm_oa_nubia123"));
        
        
//        try {
//            pushCustomer();
//        } catch (NoSuchAlgorithmException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        
//        File file = new File("area201809.txt");
//        File sql = new File("area02.sql");
//        try {
//            BufferedReader reafer = new BufferedReader(new FileReader(file));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(sql));
//            String str = null;
//            String[] strArray = new String[2];
//            String insert = "insert into regions (`code`, `name`) values\n";
//            writer.write(insert);
//            while (null != (str = reafer.readLine())) {
//                strArray = str.trim().split(" ");
//                insert = "(\"" + strArray[0] + "\", \"" + strArray[1] + "\"),\n";
//                writer.write(insert);
//                writer.flush();
//            }
//            System.out.println(insert);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    
    public String sign(Map<String, Object> param, String appKey) {
        Set<String> keySet = new TreeSet<>(param.keySet());

        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            sb.append(key).append("=").append(param.get(key));
        }
        sb.append(appKey);

        String encrypt = encrypt(sb.toString());

        return encrypt;

    }

    public String encrypt(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte[] messageDigest = digest.digest();
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
        }

        return "";

    }
    
    private void nubiashop() {
        //http://nubia-shop-admin.nubia.com/server_api/monitor/sale_order_query
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", time);
        String sign = sign(map, "4b0880a77d9248bcbbc2b7721311408c");
        map.put("signature", sign);
        
        System.out.println(sign);
        String result = "";
        try {
            result = Request.Get("http://nubia-shop-admin.nubia.com/server_api/monitor/sale_order_query?timestamp=" + time + "&signature=" + sign)
                    .connectTimeout(30000)
                    .socketTimeout(30000)
                    .execute()
                    .returnContent()
                    .asString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(result);
    }
    
    private void pushCustomer() throws NoSuchAlgorithmException {
        
        Customer customer = new Customer();
        customer.setCode("20003386");
        customer.setName("合肥文鑫通讯器材有限公司");
        customer.setAddressCountry("中国");
        customer.setAddressProvince("安徽省");
        customer.setAddressCity("合肥市");
        customer.setAddressStreet("莲湖区唐延路北段63号唐延鑫苑1幢12308室");
        customer.setContact("测试");
        customer.setPhone("13618113842");
        customer.setContractNumber("N2HF18012601HF");
        customer.setContractStartTime("2018-01-01 00:00:00.0");
        customer.setContractEndTime("2018-12-31 00:00:00.0");
        customer.setCooperationState("hzkh");
        customer.setCountry("国内");
        customer.setIsSupervised("N");
        customer.setType("CS");
        customer.setType2("");
        customer.setType3("");
        customer.setRemark("应业务要求，手动修改客户属性为平台商客户");
        customer.setPrmProperty("clskh");
        customer.setRelateCustomer("hehe");
        customer.setPartyId("001");
        customer.setInvoiceToAddressId("007");
        customer.setShipToAddressId("007");
        customer.setTaxCode("16%");
        
        customer.setPushType(2);
        
        
//        Customer customer1 = new Customer();
//        customer1.setCode("20181213002");
//        customer1.setName("测试客户002");
//        customer1.setAddressCity("福州市");
//        customer1.setAddressCountry("中国");
//        customer1.setAddressProvince("福建省");
//        customer1.setAddressStreet("华林路");
//        customer1.setContact("Emma");
//        customer1.setPhone("18305968092");
//        customer1.setContractNumber("CS0016004011");
//        customer1.setCooperationState("hzkh");
//        customer1.setCountry("中国");
//        customer1.setIsSupervised("Y");
//        customer1.setType("CS");
//        customer1.setRemark("测试客户");
//        customer1.setPrmProperty("yd");
        
        List<Customer> list = new ArrayList<>();
        list.add(customer);
//        list.add(customer1);
        
        Map<String, Object> map = new HashMap<>();
        String str = new Gson().toJson(list);
        map.put("customers", str);
        map.put("timestamp", 1558489286);
        String sign = SignatureUtils.getSignature(map, "0f1ea885d875f53d879dc9b82f61801d");
        map.put("signature", sign);
        
        System.out.println(str);
        
//        try {
////            System.out.println(SignatureUtils.getSignature(map, "0f1ea885d875f53d879dc9b82f61801d"));
//        } catch (NoSuchAlgorithmException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        
        NameValuePair kv1 = new BasicNameValuePair("customers", str);
        NameValuePair kv2 = new BasicNameValuePair("timestamp", "1558489286");
        NameValuePair kv3 = new BasicNameValuePair("signature", sign);
        
        try {
            String result = Request.Post("http://localhost:8080/nubia-cloud-shop/api/customer/push_customer")
//            String result = Request.Post("https://testcloudshop.nubia.com/api/customer/push_customer")
//            String result = Request.Post("https://cloudshop.nubia.com/api/customer/push_customer")  
                    .bodyForm(Arrays.asList(kv1, kv2, kv3), Consts.UTF_8)
                    .connectTimeout(30000)
                    .socketTimeout(30000)
                    .setHeader("content-type", "application/x-www-form-urlencoded;charset=utf-8")
                    .execute()
                    .returnContent()
                    .asString();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("请求失败");
            e.printStackTrace();
        }
    }
}
