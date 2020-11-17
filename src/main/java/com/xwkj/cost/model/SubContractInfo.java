package com.xwkj.cost.model;

import java.math.BigDecimal;
import java.util.Date;

public class SubContractInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：sub_contract_name，  字段含义：成本合同名称
     */
    private String subContractName;

    /**
     * 对应字段：sub_contract_num，  字段含义：成本合同编号
     */
    private String subContractNum;

    /**
     * 对应字段：sub_contract_cost，  字段含义：成本合同总付款
     */
    private BigDecimal subContractCost;

    /**
     * 对应字段：pay_item，  字段含义：支出项
     */
    private String payItem;

    /**
     * 对应字段：cost_money，  字段含义：成本金额
     */
    private BigDecimal costMoney;

    /**
     * 对应字段：status，  字段含义：状态  1：未完成  2：已完成  0：已删除
     */
    private Integer status;

    /**
     * 对应字段：payee，  字段含义：收款方
     */
    private String payee;

    /**
     * 对应字段：payee_tel，  字段含义：收款方电话
     */
    private String payeeTel;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    private Date createTime;

    /**
     * 对应字段：company，  字段含义：乙方单位
     */
    private String company;

    /**
     * 对应字段：contract_id，  字段含义：合同主键
     */
    private Long contractId;

    /**
     * 对应字段：cost_type_id，  字段含义：成本类型标识
     */
    private String costTypeId;

    /**
     * 成本类型名称
     */
    private String costTypeName;

    /**
     * 未付款总金额
     */
    private BigDecimal unpaid;

    /**
     * 上传文件路径
     */
    private String fileUploads;

    /**
     * 总回票金额
     */
    private BigDecimal returnTicketMoney;

    public BigDecimal getReturnTicketMoney() {
        return returnTicketMoney;
    }

    public SubContractInfo setReturnTicketMoney(BigDecimal returnTicketMoney) {
        this.returnTicketMoney = returnTicketMoney;
        return this;
    }

    public String getFileUploads() {
        return fileUploads;
    }

    public SubContractInfo setFileUploads(String fileUploads) {
        this.fileUploads = fileUploads;
        return this;
    }

    public BigDecimal getUnpaid() {
        return unpaid;
    }

    public SubContractInfo setUnpaid(BigDecimal unpaid) {
        this.unpaid = unpaid;
        return this;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public SubContractInfo setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SubContractInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getSubContractName() {
        return subContractName;
    }

    public SubContractInfo setSubContractName(String subContractName) {
        this.subContractName = subContractName == null ? null : subContractName.trim();
        return this;
    }

    public String getSubContractNum() {
        return subContractNum;
    }

    public SubContractInfo setSubContractNum(String subContractNum) {
        this.subContractNum = subContractNum == null ? null : subContractNum.trim();
        return this;
    }

    public BigDecimal getSubContractCost() {
        return subContractCost;
    }

    public SubContractInfo setSubContractCost(BigDecimal subContractCost) {
        this.subContractCost = subContractCost;
        return this;
    }

    public String getPayItem() {
        return payItem;
    }

    public SubContractInfo setPayItem(String payItem) {
        this.payItem = payItem == null ? null : payItem.trim();
        return this;
    }

    public BigDecimal getCostMoney() {
        return costMoney;
    }

    public SubContractInfo setCostMoney(BigDecimal costMoney) {
        this.costMoney = costMoney;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public SubContractInfo setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getPayee() {
        return payee;
    }

    public SubContractInfo setPayee(String payee) {
        this.payee = payee == null ? null : payee.trim();
        return this;
    }

    public String getPayeeTel() {
        return payeeTel;
    }

    public SubContractInfo setPayeeTel(String payeeTel) {
        this.payeeTel = payeeTel == null ? null : payeeTel.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public SubContractInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public SubContractInfo setCompany(String company) {
        this.company = company == null ? null : company.trim();
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public SubContractInfo setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public String getCostTypeId() {
        return costTypeId;
    }

    public SubContractInfo setCostTypeId(String costTypeId) {
        this.costTypeId = costTypeId == null ? null : costTypeId.trim();
        return this;
    }
}
