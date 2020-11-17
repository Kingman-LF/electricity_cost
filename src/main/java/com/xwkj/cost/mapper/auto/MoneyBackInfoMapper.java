package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.MoneyBackInfo;

public interface MoneyBackInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MoneyBackInfo record);

    int insertSelective(MoneyBackInfo record);

    MoneyBackInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MoneyBackInfo record);

    int updateByPrimaryKey(MoneyBackInfo record);
}