package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.PermissionInfo;

public interface PermissionInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PermissionInfo record);

    int insertSelective(PermissionInfo record);

    PermissionInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PermissionInfo record);

    int updateByPrimaryKey(PermissionInfo record);
}