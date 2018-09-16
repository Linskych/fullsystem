package com.skych.fullsystem.model;

import java.util.List;

/**
 * desc: 
 * table: tbl_role
 *
 * @mbg.generated Mon Sep 03 16:35:35 CST 2018
 */
public class Role {
    /**
     * desc: 主键
     * column: id
     * @mbg.generated
     */
    private Integer id;

    /**
     * desc: 角色名称
     * column: name
     * @mbg.generated
     */
    private String name;

    private List<Right> rightList;
    
    /**
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public List<Right> getRightList() {
        return rightList;
    }

    public void setRightList(List<Right> rightList) {
        this.rightList = rightList;
    }
}