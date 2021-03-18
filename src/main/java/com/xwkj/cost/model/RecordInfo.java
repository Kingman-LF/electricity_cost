package com.xwkj.cost.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RecordInfo {
    /**
     * 对应字段：id，  字段含义：主键
     */
    private Long id;

    /**
     * 对应字段：name，  字段含义：名称
     */
    private Long name;

    /**
     * 对应字段：count，  字段含义：数量
     */
    private Integer count;

    /**
     * 对应字段：unit，  字段含义：单位
     */
    private Long unit;

    /**
     * 对应字段：price，  字段含义：单价
     */
    private String price;

    /**
     * 对应字段：item，  字段含义：项目
     */
    private String item;

    /**
     * 对应字段：time，  字段含义：时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     * 对应字段：note，  字段含义：备注
     */
    private String note;

    /**
     * 对应字段：create_time，  字段含义：创建时间
     */
    private Date createTime;

    /**
     * 对应字段：is_enable，  字段含义：状态：1启用 0禁用
     */
    private Integer isEnable;


    private String nameStr;

    private String unitName;

    public String getNameStr() {
        return nameStr;
    }

    public RecordInfo setNameStr(String nameStr) {
        this.nameStr = nameStr;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public RecordInfo setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public Long getId() {
        return id;
    }

    public RecordInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getName() {
        return name;
    }

    public RecordInfo setName(Long name) {
        this.name = name;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public RecordInfo setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Long getUnit() {
        return unit;
    }

    public RecordInfo setUnit(Long unit) {
        this.unit = unit;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public RecordInfo setPrice(String price) {
        this.price = price == null ? null : price.trim();
        return this;
    }

    public String getItem() {
        return item;
    }

    public RecordInfo setItem(String item) {
        this.item = item == null ? null : item.trim();
        return this;
    }

    public Date getTime() {
        return time;
    }

    public RecordInfo setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getNote() {
        return note;
    }

    public RecordInfo setNote(String note) {
        this.note = note == null ? null : note.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public RecordInfo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public RecordInfo setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }
}
