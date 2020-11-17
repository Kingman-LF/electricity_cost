package com.xwkj.cost.model;

public class CostTypeInfo {
    /**
     * 对应字段：id，  字段含义：成本分类主键
     */
    private Long id;

    /**
     * 对应字段：name，  字段含义：成本分类名称
     */
    private String name;

    /**
     * 对应字段：p_id，  字段含义：成本分类父标识
     */
    private Long pId;

    /**
     * 对应字段：is_enable，  字段含义：成本分类状态  1：启用  0：禁用
     */
    private Integer isEnable;

    /**
     * 对应字段：sort，  字段含义：排序
     */
    private Long sort;

    public Long getId() {
        return id;
    }

    public CostTypeInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CostTypeInfo setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Long getpId() {
        return pId;
    }

    public CostTypeInfo setpId(Long pId) {
        this.pId = pId;
        return this;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public CostTypeInfo setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
        return this;
    }

    public Long getSort() {
        return sort;
    }

    public CostTypeInfo setSort(Long sort) {
        this.sort = sort;
        return this;
    }
}
