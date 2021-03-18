package com.xwkj.cost.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:TODO 合同包含回款信息
 * @Author wanglei
 * @Create 2019-12-11 14:35
 * @Version 1.0
 */
public class ContractInfoAndInvoiceInfoVo {
	/**
	 * 对应字段：id，  字段含义：合同主键
	 */
	private Long id;

	/**
	 * 对应字段：contract_name，  字段含义：合同名称
	 */
	private String contractName;

	/**
	 * 对应字段：contract_num，  字段含义：合同编号
	 */
	private String contractNum;

	/**
	 * 对应字段：item_name，  字段含义：项目名称
	 */
	private String itemName;

	/**
	 * 对应字段：item_manager，  字段含义：项目经理
	 */
	private String itemManager;

	/**
	 * 对应字段：customer，  字段含义：客户姓名
	 */
	private String customer;

	/**
	 * 对应字段：company，  字段含义：客户单位
	 */
	private String company;

	/**
	 * 对应字段：customer_tel，  字段含义：客户电话
	 */
	private String customerTel;

	/**
	 * 对应字段：creat_time，  字段含义：创建时间
	 */
	private Date creatTime;

	/**
	 * 对应字段：last_modified_time，  字段含义：最后修改时间
	 */
	private Date lastModifiedTime;

	/**
	 * 对应字段：creator，  字段含义：创建人
	 */
	private Long creator;

	/**
	 * 对应字段：last_modifier，  字段含义：最后修改人
	 */
	private Long lastModifier;

	/**
	 * 对应字段：contract_cost，  字段含义：合同总成本
	 */
	private BigDecimal contractCost;

	/**
	 * 对应字段：contract_money，  字段含义：合同金额
	 */
	private BigDecimal contractMoney;

	/**
	 * 对应字段：special_instructions，  字段含义：特殊说明
	 */
	private String specialInstructions;

	/**
	 * 对应字段：premium，  字段含义：质保金说明
	 */
	private String premium;

	/**
	 * 对应字段：conclusion，  字段含义：结论
	 */
	private String conclusion;

	/**
	 * 对应字段：status，  字段含义：状态  1：未完成  2：已完成  0：已删除
	 */
	private Integer status;

	private BigDecimal moneySum;

	/**
	 * 创建人
	 */
	private String creatorName;

	public String getCreatorName() {
		return creatorName;
	}

	public ContractInfoAndInvoiceInfoVo setCreatorName(String creatorName) {
		this.creatorName = creatorName;
		return this;
	}

	public Long getId() {
		return id;
	}

	public ContractInfoAndInvoiceInfoVo setId(Long id) {
		this.id = id;
		return this;
	}

	public String getContractName() {
		return contractName;
	}

	public ContractInfoAndInvoiceInfoVo setContractName(String contractName) {
		this.contractName = contractName == null ? null : contractName.trim();
		return this;
	}

	public String getContractNum() {
		return contractNum;
	}

	public ContractInfoAndInvoiceInfoVo setContractNum(String contractNum) {
		this.contractNum = contractNum == null ? null : contractNum.trim();
		return this;
	}

	public String getItemName() {
		return itemName;
	}

	public ContractInfoAndInvoiceInfoVo setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
		return this;
	}

	public String getCustomer() {
		return customer;
	}

	public ContractInfoAndInvoiceInfoVo setCustomer(String customer) {
		this.customer = customer == null ? null : customer.trim();
		return this;
	}

	public String getCompany() {
		return company;
	}

	public ContractInfoAndInvoiceInfoVo setCompany(String company) {
		this.company = company == null ? null : company.trim();
		return this;
	}

	public String getCustomerTel() {
		return customerTel;
	}

	public ContractInfoAndInvoiceInfoVo setCustomerTel(String customerTel) {
		this.customerTel = customerTel == null ? null : customerTel.trim();
		return this;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public ContractInfoAndInvoiceInfoVo setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
		return this;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public ContractInfoAndInvoiceInfoVo setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
		return this;
	}

	public Long getCreator() {
		return creator;
	}

	public ContractInfoAndInvoiceInfoVo setCreator(Long creator) {
		this.creator = creator;
		return this;
	}

	public Long getLastModifier() {
		return lastModifier;
	}

	public ContractInfoAndInvoiceInfoVo setLastModifier(Long lastModifier) {
		this.lastModifier = lastModifier;
		return this;
	}

	public BigDecimal getContractCost() {
		return contractCost;
	}

	public ContractInfoAndInvoiceInfoVo setContractCost(BigDecimal contractCost) {
		this.contractCost = contractCost;
		return this;
	}

	public BigDecimal getContractMoney() {
		return contractMoney;
	}

	public ContractInfoAndInvoiceInfoVo setContractMoney(BigDecimal contractMoney) {
		this.contractMoney = contractMoney;
		return this;
	}

	public String getSpecialInstructions() {
		return specialInstructions;
	}

	public ContractInfoAndInvoiceInfoVo setSpecialInstructions(String specialInstructions) {
		this.specialInstructions = specialInstructions == null ? null : specialInstructions.trim();
		return this;
	}

	public String getPremium() {
		return premium;
	}

	public ContractInfoAndInvoiceInfoVo setPremium(String premium) {
		this.premium = premium == null ? null : premium.trim();
		return this;
	}

	public String getConclusion() {
		return conclusion;
	}

	public ContractInfoAndInvoiceInfoVo setConclusion(String conclusion) {
		this.conclusion = conclusion == null ? null : conclusion.trim();
		return this;
	}

	public Integer getStatus() {
		return status;
	}

	public ContractInfoAndInvoiceInfoVo setStatus(Integer status) {
		this.status = status;
		return this;
	}

	public BigDecimal getMoneySum() {
		return moneySum;
	}

	public void setMoneySum(BigDecimal moneySum) {
		this.moneySum = moneySum;
	}

	public String getItemManager() {
		return itemManager;
	}

	public ContractInfoAndInvoiceInfoVo setItemManager(String itemManager) {
		this.itemManager = itemManager == null ? null : itemManager.trim();
		return this;
	}
}
