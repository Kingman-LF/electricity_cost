package com.xwkj.cost.model;

public class DictionaryInfo {
    /**
     * 对应字段：id，  字段含义：id
     */
    private Long id;

    /**
     * 对应字段：dic_parentid，  字段含义：父级id
     */
    private Long dicParentid;

    /**
     * 对应字段：dic_name，  字段含义：变量名称
     */
    private String dicName;

    /**
     * 对应字段：dic_remark，  字段含义：备注信息
     */
    private String dicRemark;

    /**
     * 对应字段：dic_status，  字段含义：变量状态（0.删除 1.使用 2 停用）
     */
    private Integer dicStatus;

    public Long getId() {
        return id;
    }

    public DictionaryInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getDicParentid() {
        return dicParentid;
    }

    public DictionaryInfo setDicParentid(Long dicParentid) {
        this.dicParentid = dicParentid;
        return this;
    }

    public String getDicName() {
        return dicName;
    }

    public DictionaryInfo setDicName(String dicName) {
        this.dicName = dicName == null ? null : dicName.trim();
        return this;
    }

    public String getDicRemark() {
        return dicRemark;
    }

    public DictionaryInfo setDicRemark(String dicRemark) {
        this.dicRemark = dicRemark == null ? null : dicRemark.trim();
        return this;
    }

    public Integer getDicStatus() {
        return dicStatus;
    }

    public DictionaryInfo setDicStatus(Integer dicStatus) {
        this.dicStatus = dicStatus;
        return this;
    }
}
