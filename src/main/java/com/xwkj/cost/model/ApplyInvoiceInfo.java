package com.xwkj.cost.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ApplyInvoiceInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：name，  字段含义：申请发票名称
     */
    private String name;

    /**
     * 对应字段：createtime，  字段含义：发票申请日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /**
     * 对应字段：latetime，  字段含义：发票开具最迟时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date latetime;

    /**
     * 对应字段：type，  字段含义：1 专票  2 普票
     */
    private Integer type;

    /**
     * 对应字段：money，  字段含义：申请开票金额
     */
    private BigDecimal money;

    /**
     * 对应字段：note，  字段含义：申请开票备注
     */
    private String note;

    /**
     * 对应字段：contract_id，  字段含义：合同主键
     */
    private Long contractId;

    /**
     * 对应字段：money_back_id，  字段含义：回款主键
     */
    private Long moneyBackId;

    /**
     * 对应字段：status，  字段含义：状态 0 删除 1 正常
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public ApplyInvoiceInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ApplyInvoiceInfo setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public ApplyInvoiceInfo setCreatetime(Date createtime) {
        this.createtime = createtime;
        return this;
    }

    public Date getLatetime() {
        return latetime;
    }

    public ApplyInvoiceInfo setLatetime(Date latetime) {
        this.latetime = latetime;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public ApplyInvoiceInfo setType(Integer type) {
        this.type = type;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public ApplyInvoiceInfo setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public String getNote() {
        return note;
    }

    public ApplyInvoiceInfo setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public ApplyInvoiceInfo setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public Long getMoneyBackId() {
        return moneyBackId;
    }

    public ApplyInvoiceInfo setMoneyBackId(Long moneyBackId) {
        this.moneyBackId = moneyBackId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ApplyInvoiceInfo setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
