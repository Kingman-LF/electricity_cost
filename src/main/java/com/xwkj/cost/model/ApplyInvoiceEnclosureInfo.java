package com.xwkj.cost.model;

import java.util.Date;

public class ApplyInvoiceEnclosureInfo {
    /**
     * 对应字段：id，  字段含义：主键
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
     * 对应字段：apply_invoice_id，  字段含义：开票申请主键
     */
    private Long applyInvoiceId;

    public Long getId() {
        return id;
    }

    public ApplyInvoiceEnclosureInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public ApplyInvoiceEnclosureInfo setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ApplyInvoiceEnclosureInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getApplyInvoiceId() {
        return applyInvoiceId;
    }

    public ApplyInvoiceEnclosureInfo setApplyInvoiceId(Long applyInvoiceId) {
        this.applyInvoiceId = applyInvoiceId;
        return this;
    }
}
