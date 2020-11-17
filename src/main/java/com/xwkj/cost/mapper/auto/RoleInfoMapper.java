package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.RoleInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    RoleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);
}