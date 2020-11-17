package com.xwkj.cost.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class MoneyBackInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：money，  字段含义：回款金额
     */
    private BigDecimal money;

    /**
     * 对应字段：contract_id，  字段含义：合同标识
     */
    private Long contractId;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    private Date createTime;

    /**
     * 对应字段：has_invoice，  字段含义：是否有发票  1：有  0：无
     */
    private Integer hasInvoice;

    /**
     * 对应字段：invoice_type，  字段含义：发票类型：1.专票 2.普票
     */
    private Integer invoiceType;

    /**
     * 对应字段：arrival_money，  字段含义：到款时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivalMoney;

    /**
     * 对应字段：creator，  字段含义：创建人
     */
    private Long creator;

    private String creatorName;

    /**
     * 对应字段：invaice_remark，  字段含义：发票备注
     */
    private String invaiceRemark;

    /**
     * 对应字段：status，  字段含义：发票状态:1.使用 2.删除
     */
    private Integer status;

    private Long applyInvoiceId;

    public Long getApplyInvoiceId() {
        return applyInvoiceId;
    }

    public MoneyBackInfo setApplyInvoiceId(Long applyInvoiceId) {
        this.applyInvoiceId = applyInvoiceId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public MoneyBackInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public MoneyBackInfo setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public MoneyBackInfo setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MoneyBackInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getHasInvoice() {
        return hasInvoice;
    }

    public MoneyBackInfo setHasInvoice(Integer hasInvoice) {
        this.hasInvoice = hasInvoice;
        return this;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public MoneyBackInfo setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
        return this;
    }

    public Date getArrivalMoney() {
        return arrivalMoney;
    }

    public MoneyBackInfo setArrivalMoney(Date arrivalMoney) {
        this.arrivalMoney = arrivalMoney;
        return this;
    }

    public Long getCreator() {
        return creator;
    }

    public MoneyBackInfo setCreator(Long creator) {
        this.creator = creator;
        return this;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public MoneyBackInfo setCreatorName(String creatorName) {
        this.creatorName = creatorName;
        return this;
    }

    public String getInvaiceRemark() {
        return invaiceRemark;
    }

    public MoneyBackInfo setInvaiceRemark(String invaiceRemark) {
        this.invaiceRemark = invaiceRemark;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public MoneyBackInfo setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
