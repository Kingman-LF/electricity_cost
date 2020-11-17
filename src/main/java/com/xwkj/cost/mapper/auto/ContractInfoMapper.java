package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ContractInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContractInfo record);

    int insertSelective(ContractInfo record);

    ContractInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractInfo record);

    int updateByPrimaryKey(ContractInfo record);
}