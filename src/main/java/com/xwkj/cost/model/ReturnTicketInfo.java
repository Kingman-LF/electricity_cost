package com.xwkj.cost.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ReturnTicketInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：money，  字段含义：回票金额
     */
    private BigDecimal money;

    /**
     * 对应字段：create_time，  字段含义：回票时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 对应字段：ticket_holder，  字段含义：回票人
     */
    private String ticketHolder;

    /**
     * 对应字段：note，  字段含义：备注
     */
    private String note;

    /**
     * 对应字段：sub_contract_id，  字段含义：成本合同主键
     */
    private Long subContractId;

    /**
     * 对应字段：is_enable，  字段含义：是否启用  1 启用  0 删除
     */
    private Integer isEnable;

    /**
     * 对应字段：create_user，  字段含义：创建人
     */
    private String createUser;

    public Long getId() {
        return id;
    }

    public ReturnTicketInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public ReturnTicketInfo setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ReturnTicketInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getTicketHolder() {
        return ticketHolder;
    }

    public ReturnTicketInfo setTicketHolder(String ticketHolder) {
        this.ticketHolder = ticketHolder == null ? null : ticketHolder.trim();
        return this;
    }

    public String getNote() {
        return note;
    }

    public ReturnTicketInfo setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Long getSubContractId() {
        return subContractId;
    }

    public ReturnTicketInfo setSubContractId(Long subContractId) {
        this.subContractId = subContractId;
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public ReturnTicketInfo setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public ReturnTicketInfo setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
        return this;
    }
}
