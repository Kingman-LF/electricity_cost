package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.PersonCost;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonCostMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PersonCost record);

    int insertSelective(PersonCost record);

    PersonCost selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PersonCost record);

    int updateByPrimaryKey(PersonCost record);
}