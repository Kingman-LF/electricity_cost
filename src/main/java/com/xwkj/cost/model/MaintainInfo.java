package com.xwkj.cost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class MaintainInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：name，  字段含义：维护名称
     */
    private String name;

    /**
     * 对应字段：money，  字段含义：维护金额
     */
    private BigDecimal money;

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
     * 对应字段：contract_id，  字段含义：合同主键
     */
    private Long contractId;

    /**
     * 对应字段：note，  字段含义：备注
     */
    private String note;

    /**
     * 对应字段：status，  字段含义：状态：0删除 1未处理 2已处理
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public MaintainInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MaintainInfo setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public MaintainInfo setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public Date getStartTime() {
        return startTime;
    }

    public MaintainInfo setStartTime(Date startTime) {
        this.startTime = startTime;
        return this;
    }

    public Date getEndTime() {
        return endTime;
    }

    public MaintainInfo setEndTime(Date endTime) {
        this.endTime = endTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public MaintainInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Long getContractId() {
        return contractId;
    }

    public MaintainInfo setContractId(Long contractId) {
        this.contractId = contractId;
        return this;
    }

    public String getNote() {
        return note;
    }

    public MaintainInfo setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public MaintainInfo setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
