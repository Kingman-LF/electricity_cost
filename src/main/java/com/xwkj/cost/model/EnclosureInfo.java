package com.xwkj.cost.model;

import java.util.Date;

public class EnclosureInfo {
    /**
     * 对应字段：id，  字段含义：附件主键
     */
    private Long id;

    /**
     * 对应字段：file_path，  字段含义：附件路径
     */
    private String filePath;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    private Date createTime;

    /**
     * 对应字段：contract_id，  字段含义：合同主键
     */
    private Long contractId;

    public Long getId() {
        return id;
    }

    public EnclosureInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public EnclosureInfo setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public EnclosureInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public EnclosureInfo setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }
}
