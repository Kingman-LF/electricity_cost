package com.xwkj.cost.model;

import java.util.Date;

public class SubEnclosureInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：file_path，  字段含义：附件路径
     */
    private String filePath;

    /**
     * 对应字段：creat_time，  字段含义：创建时间
     */
    private Date creatTime;

    /**
     * 对应字段：sub_contract_id，  字段含义：成本合同主键
     */
    private Long subContractId;

    public Long getId() {
        return id;
    }

    public SubEnclosureInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public SubEnclosureInfo setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
        return this;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public SubEnclosureInfo setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
        return this;
    }

    public Long getSubContractId() {
        return subContractId;
    }

    public SubEnclosureInfo setSubContractId(Long subContractId) {
        this.subContractId = subContractId;
        return this;
    }
}
