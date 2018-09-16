package com.skych.fullsystem.model;

/**
 * desc: 
 * table: tbl_account_role_rel
 *
 * @mbg.generated Mon Sep 03 16:11:08 CST 2018
 */
public class AccountRoleRel {
    /**
     * desc: 账户id
     * column: account_id
     * @mbg.generated
     */
    private Integer accountId;

    /**
     * desc: 角色id
     * column: role_id
     * @mbg.generated
     */
    private Integer roleId;

    /**
     * @mbg.generated
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * @mbg.generated
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

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
}