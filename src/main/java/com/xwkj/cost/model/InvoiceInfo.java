package com.xwkj.cost.model;

public class InvoiceInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：ti_num，  字段含义：纳税人识别号
     */
    private String tiNum;

    /**
     * 对应字段：account_name，  字段含义：开户名称
     */
    private String accountName;

    /**
     * 对应字段：public_account_num，  字段含义：对公账号
     */
    private String publicAccountNum;

    /**
     * 对应字段：opening_bank，  字段含义：开户行
     */
    private String openingBank;

    /**
     * 对应字段：place_of_opening，  字段含义：开户地点
     */
    private String placeOfOpening;

    /**
     * 对应字段：mailing_addr，  字段含义：发票邮寄地址
     */
    private String mailingAddr;

    /**
     * 对应字段：contact_name，  字段含义：联系人姓名
     */
    private String contactName;

    /**
     * 对应字段：tel，  字段含义：联系电话
     */
    private String tel;

    /**
     * 对应字段：contract_id，  字段含义：合同主键
     */
    private Long contractId;

    public Long getId() {
        return id;
    }

    public InvoiceInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTiNum() {
        return tiNum;
    }

    public InvoiceInfo setTiNum(String tiNum) {
        this.tiNum = tiNum == null ? null : tiNum.trim();
        return this;
    }

    public String getAccountName() {
        return accountName;
    }

    public InvoiceInfo setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
        return this;
    }

    public String getPublicAccountNum() {
        return publicAccountNum;
    }

    public InvoiceInfo setPublicAccountNum(String publicAccountNum) {
        this.publicAccountNum = publicAccountNum == null ? null : publicAccountNum.trim();
        return this;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public InvoiceInfo setOpeningBank(String openingBank) {
        this.openingBank = openingBank == null ? null : openingBank.trim();
        return this;
    }

    public String getPlaceOfOpening() {
        return placeOfOpening;
    }

    public InvoiceInfo setPlaceOfOpening(String placeOfOpening) {
        this.placeOfOpening = placeOfOpening == null ? null : placeOfOpening.trim();
        return this;
    }

    public String getMailingAddr() {
        return mailingAddr;
    }

    public InvoiceInfo setMailingAddr(String mailingAddr) {
        this.mailingAddr = mailingAddr == null ? null : mailingAddr.trim();
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public InvoiceInfo setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
        return this;
    }

    public String getTel() {
        return tel;
    }

    public InvoiceInfo setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public InvoiceInfo setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }
}
