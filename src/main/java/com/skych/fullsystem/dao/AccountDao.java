package com.skych.fullsystem.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.skych.fullsystem.model.Account;

public interface AccountDao {

//    Account getAccount(Account account);
//    Account getAccount(@Param("idValue")int id, @Param("realname") String realname);
    
    Account getAccount(@Param("idValue")int id);
    
    Account getAccountRole(int id);
    
    List<Account> listAccountByIds(List<Integer> list);
    
    void updateById(Map<String, Object> param);
    
//    @Results(id="accountResult", value= {
//            @Result(property="id", column="id", id=true),
//            @Result(property="realname", column="realname"),
//            @Result(property="username", column="username"),
//            @Result(property="password", column="password"),
//            @Result(property="email", column="email"),
//            @Result(property="mobile", column="mobile"),
//            @Result(property="headImg", column="head_img")
//    })
    @Select("select * from tbl_account where username = #{username}")
    Account getAccountByUsername(String sd);
    
//    @ResultMap("accountResult")//不添加映射关系时，mybatis会尽力而为的映射属性
    @Select("select id,realname,username,password,email,mobile,head_img from tbl_account")
    List<Account> listAccounts();
    
//    以下注解与xml的配置功能一致(@Delete和@Update只有一个value[]属性，sql语句)
//    @Insert({"insert tbl_account(realname, username, password, email, mobile, head_img)",
//        "values(#{realname}, #{username}, #{password}, #{email}, #{mobile}, #{headImg, jdbcType=BLOB})"})
//    自增的主键配置
//    @Options(useGeneratedKeys=true, keyProperty="id")
//    非自增的主键配置
//    @SelectKey(before=false, resultType=Integer.class, statement= {"select last_insert_id()"}, keyProperty="id")
    void saveAccount(Account account);
}
