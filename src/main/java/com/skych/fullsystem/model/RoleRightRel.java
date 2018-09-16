package com.skych.fullsystem.model;

/**
 * desc: 
 * table: tbl_role_right_rel
 *
 * @mbg.generated Mon Sep 03 16:10:38 CST 2018
 */
public class RoleRightRel {
    /**
     * desc: 角色id
     * column: role_id
     * @mbg.generated
     */
    private Integer roleId;

    /**
     * desc: 菜单id
     * column: right_id
     * @mbg.generated
     */
    private Integer rightId;

    /**
     * @mbg.generated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @mbg.generated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @mbg.generated
     */
    public Integer getRightId() {
        return rightId;
    }

    /**
     * @mbg.generated
     */
    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }
}