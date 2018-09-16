package com.skych.fullsystem.model;

/**
 * desc: 
 * table: tbl_right
 *
 * @mbg.generated Mon Sep 03 16:11:25 CST 2018
 */
public class Right {
    /**
     * desc: 权限表主键
     * column: id
     * @mbg.generated
     */
    private Integer id;

    /**
     * desc: 权限类型(10菜单、20页面元素、30操作)
     * column: type
     * @mbg.generated
     */
    private Integer type;

    /**
     * desc: 权限名称(包含菜单名称)
     * column: name
     * @mbg.generated
     */
    private String name;

    /**
     * desc: 该权限的访问地址(页面元素类型的，使用元素id)
     * column: url
     * @mbg.generated
     */
    private String url;

    /**
     * desc: 依赖的权限
     * column: rely_right
     * @mbg.generated
     */
    private Integer relyRight;

    /**
     * desc: 互斥的权限
     * column: exclude_right
     * @mbg.generated
     */
    private Integer excludeRight;

    /**
     * desc: 权限说明
     * column: remark
     * @mbg.generated
     */
    private String remark;

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
    public Integer getType() {
        return type;
    }

    /**
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
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

    /**
     * @mbg.generated
     */
    public String getUrl() {
        return url;
    }

    /**
     * @mbg.generated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @mbg.generated
     */
    public Integer getRelyRight() {
        return relyRight;
    }

    /**
     * @mbg.generated
     */
    public void setRelyRight(Integer relyRight) {
        this.relyRight = relyRight;
    }

    /**
     * @mbg.generated
     */
    public Integer getExcludeRight() {
        return excludeRight;
    }

    /**
     * @mbg.generated
     */
    public void setExcludeRight(Integer excludeRight) {
        this.excludeRight = excludeRight;
    }

    /**
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}