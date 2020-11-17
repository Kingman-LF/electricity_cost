package com.xwkj.cost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class PersonCost {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：name，  字段含义：人员名称
     */
    private String name;

    /**
     * 对应字段：contract_id，  字段含义：合同主键
     */
    private Long contractId;

    /**
     * 对应字段：cost_type_id，  字段含义：成本类型主键字符串
     */
    private String costTypeId;

    /**
     * 对应字段：start_time，  字段含义：开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 对应字段：end_time，  字段含义：结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 对应字段：cost，  字段含义：成本金额
     */
    private BigDecimal cost;

    /**
     * 对应字段：is_pay，  字段含义：是否付款：1 已付款 0 未付款
     */
    private Integer isPay;

    /**
     * 对应字段：note，  字段含义：备注
     */
    private String note;

    /**
     * 对应字段：is_enable，  字段含义：状态  1：存在  0：删除
     */
    private Integer isEnable;

    /**
     * 成本类型名称
     */
    private String costTypeName;

    public String getCostTypeName() {
        return costTypeName;
    }

    public PersonCost setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public PersonCost setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PersonCost setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public PersonCost setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public String getCostTypeId() {
        return costTypeId;
    }

    public PersonCost setCostTypeId(String costTypeId) {
        this.costTypeId = costTypeId == null ? null : costTypeId.trim();
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public PersonCost setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public PersonCost setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public PersonCost setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public PersonCost setCost(BigDecimal cost) {
        this.cost = cost;
        return this;
    }

    public Integer getIsPay() {
        return isPay;
    }

    public PersonCost setIsPay(Integer isPay) {
        this.isPay = isPay;
        return this;
    }

    public String getNote() {
        return note;
    }

    public PersonCost setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public PersonCost setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }
}
