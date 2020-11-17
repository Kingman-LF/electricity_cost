package com.xwkj.cost.mapper;

import com.xwkj.cost.model.PersonCost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonCostMapperManual {

    /**
     * @Description : 获取人员成本列表
     * @methodName : getPersonCostList
     * @param personCost :
     * @return : java.util.List<com.xwkj.cost.model.PersonCost>
     * @exception :
     * @author : 张永辉
     */
    List<PersonCost> getPersonCostList(PersonCost personCost);

}