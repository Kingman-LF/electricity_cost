package com.xwkj.cost.model;

public class PermissionInfo {
    /**
     * 对应字段：id，  字段含义：权限主键
     */
    private Long id;

    /**
     * 对应字段：name，  字段含义：权限名称
     */
    private String name;

    /**
     * 对应字段：perm，  字段含义：权限
     */
    private String perm;

    /**
     * 对应字段：p_id，  字段含义：权限父标识
     */
    private Long pId;

    public Long getId() {
        return id;
    }

    public PermissionInfo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PermissionInfo setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getPerm() {
        return perm;
    }

    public PermissionInfo setPerm(String perm) {
        this.perm = perm == null ? null : perm.trim();
        return this;
    }

    public Long getpId() {
        return pId;
    }

    public PermissionInfo setpId(Long pId) {
        this.pId = pId;
        return this;
    }
}
