package com.skych.fullsystem.model;

import java.util.List;

public class Account {

    private Integer id;
    private String realname;
    private String username;
    private String password;
    private String email;
    private String mobile;
    private byte[] headImg;
    
    private List<Role> roleList;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getRealname() {
        return realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public byte[] getHeadImg() {
        return headImg;
    }
    public void setHeadImg(byte[] headImg) {
        this.headImg = headImg;
    }
    public List<Role> getRoleList() {
        return roleList;
    }
    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
