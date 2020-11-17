package com.xwkj.cost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ContractCostTypeRelated {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：contract_id，  字段含义：合同标识
     */
    private Long contractId;

    /**
     * 对应字段：cost_type_id，  字段含义：成本类型标识
     */
    private String costTypeId;

    /**
     * 对应字段：cost，  字段含义：成本金额
     */
    private BigDecimal cost;

    /**
     * 对应字段：payee，  字段含义：收款人
     */
    private String payee;

    /**
     * 对应字段：payee_tel，  字段含义：收款人电话
     */
    private String payeeTel;

    /**
     * 对应字段：is_pay，  字段含义：是否支付  1：已支付  0：未支付
     */
    private Integer isPay;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 对应字段：note，  字段含义：备注
     */
    private String note;

    /**
     * 对应字段：is_enable，  字段含义：状态：  1：正常  0：已删除
     */
    private Integer isEnable;

    /**
     * 成本类型名称
     */
    private String costTypeName;

    /**
     * 支付总金额
     */
    private BigDecimal payment;

    public String getCostTypeName() {
        return costTypeName;
    }

    public ContractCostTypeRelated setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
        return this;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public ContractCostTypeRelated setPayment(BigDecimal payment) {
        this.payment = payment;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ContractCostTypeRelated setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public ContractCostTypeRelated setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public String getCostTypeId() {
        return costTypeId;
    }

    public ContractCostTypeRelated setCostTypeId(String costTypeId) {
        this.costTypeId = costTypeId == null ? null : costTypeId.trim();
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public ContractCostTypeRelated setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public String getPayee() {
        return payee;
    }

    public ContractCostTypeRelated setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
        return this;
    }

    public String getPayeeTel() {
        return payeeTel;
    }

    public ContractCostTypeRelated setPayeeTel(String payeeTel) {
        this.payeeTel = payeeTel == null ? null : payeeTel.trim();
        return this;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public ContractCostTypeRelated setIsPay(Integer isPay) {
        this.isPay = isPay;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ContractCostTypeRelated setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getNote() {
        return note;
    }

    public ContractCostTypeRelated setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public ContractCostTypeRelated setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }
}
