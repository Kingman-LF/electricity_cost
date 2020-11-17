package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.SubContractCost;
import org.springframework.stereotype.Repository;

@Repository
public interface SubContractCostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubContractCost record);

    int insertSelective(SubContractCost record);

    SubContractCost selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubContractCost record);

    int updateByPrimaryKey(SubContractCost record);
}