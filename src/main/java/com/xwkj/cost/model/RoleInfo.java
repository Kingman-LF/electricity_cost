package com.xwkj.cost.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RoleInfo {
    /**
     * 对应字段：id，  字段含义：角色主键
     */
    private Long id;

    /**
     * 对应字段：role_name，  字段含义：角色名称
     */
    private String roleName;

    /**
     * 对应字段：role_desc，  字段含义：角色描述
     */
    private String roleDesc;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    private Date createTime;

    /**
     * 对应字段：creator，  字段含义：创建人
     */
    private Long creator;

    /**
     * 对应字段：is_enable，  字段含义：用户状态  1：启用  0：禁用
     */
    private Integer isEnable;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 对应字段：create_user，  字段含义：创建人
     */
    private String createUser;

    public Date getStartTime() {
        return startTime;
    }

    public RoleInfo setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public RoleInfo setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RoleInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRoleName() {
        return roleName;
    }

    public RoleInfo setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
        return this;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public RoleInfo setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc == null ? null : roleDesc.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public RoleInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getCreator() {
        return creator;
    }

    public RoleInfo setCreator(Long creator) {
        this.creator = creator;
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public RoleInfo setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public RoleInfo setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
        return this;
    }
}
