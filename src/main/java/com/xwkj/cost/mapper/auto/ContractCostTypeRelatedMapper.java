package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ContractCostTypeRelated;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractCostTypeRelatedMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContractCostTypeRelated record);

    int insertSelective(ContractCostTypeRelated record);

    ContractCostTypeRelated selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContractCostTypeRelated record);

    int updateByPrimaryKey(ContractCostTypeRelated record);
}