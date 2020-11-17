package com.xwkj.cost.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class SubContractCost {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：cost，  字段含义：成本
     */
    private BigDecimal cost;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 对应字段：sub_contract_id，  字段含义：子合同标识
     */
    private Long subContractId;

    /**
     * 对应字段：payee，  字段含义：收款方
     */
    private String payee;

    /**
     * 对应字段：note，  字段含义：备注
     */
    private String note;

    /**
     * 对应字段：is_enbale，  字段含义：状态  1：存在  0：删除
     */
    private Integer isEnbale;

    /**
     * 修改之前的成本
     */
    private BigDecimal beforeCost;

    public BigDecimal getBeforeCost() {
        return beforeCost;
    }

    public SubContractCost setBeforeCost(BigDecimal beforeCost) {
        this.beforeCost = beforeCost;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SubContractCost setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public SubContractCost setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SubContractCost setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getSubContractId() {
        return subContractId;
    }

    public SubContractCost setSubContractId(Long subContractId) {
        this.subContractId = subContractId;
        return this;
    }

    public String getPayee() {
        return payee;
    }

    public SubContractCost setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
        return this;
    }

    public String getNote() {
        return note;
    }

    public SubContractCost setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Integer getIsEnbale() {
        return isEnbale;
    }

    public SubContractCost setIsEnbale(Integer isEnbale) {
        this.isEnbale = isEnbale;
        return this;
    }
}
