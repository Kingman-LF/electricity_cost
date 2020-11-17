package com.xwkj.cost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserInfo {
    /**
     * 对应字段：id，  字段含义：用户主键
     */
    private Long id;

    /**
     * 对应字段：user_name，  字段含义：用户名
     */
    private String userName;

    /**
     * 对应字段：password，  字段含义：用户密码
     */
    private String password;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    private Date createTime;

    /**
     * 对应字段：is_enable，  字段含义：用户状态  1：启用  0：禁用
     */
    private Integer isEnable;

    /**
     * 对应字段：name，  字段含义：用户姓名
     */
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date endTime;
    public Long getId() {
        return id;
    }

    public UserInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserInfo setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserInfo setPassword(String password) {
        this.password = password == null ? null : password.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public UserInfo setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserInfo setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public UserInfo setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public UserInfo setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }
    public byte[] getCredentialsSalt(){
        return String.valueOf(this.userName + this.password).getBytes();
    }
}
