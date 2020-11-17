package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.CostTypeInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface CostTypeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CostTypeInfo record);

    int insertSelective(CostTypeInfo record);

    CostTypeInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CostTypeInfo record);

    int updateByPrimaryKey(CostTypeInfo record);
}