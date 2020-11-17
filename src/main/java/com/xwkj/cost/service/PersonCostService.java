package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.PersonCost;
import com.xwkj.cost.util.PageUtil;

/**
 * @program: electricity_cost
 * @description: 人员成本服务层
 * @author: 张永辉
 * @create: 2020-06-28 13:42
 **/
public interface PersonCostService {

    /**
     * @Description : 添加人员成本信息
     * @methodName : addPersonCost
     * @param personCost :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void addPersonCost(PersonCost personCost);

    /**
     * @Description : 修改人员成本
     * @methodName : updatePersonCost
     * @param personCost :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void updatePersonCost(PersonCost personCost);

    /**
     * @Description : 删除人员成本信息
     * @methodName : deletePersonCost
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void deletePersonCost(Long id);

    /**
     * @Description : 批量删除人员成本信息
     * @methodName : batchDeletePersonCost
     * @param ids :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void batchDeletePersonCost(String ids);

    /**
     * @Description : 获取人员成本列表
     * @methodName : getPersonCostList
     * @param personCost :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.PersonCost>
     * @exception :
     * @author : 张永辉
     */
    PageInfo<PersonCost> getPersonCostList(PageUtil pageUtil, PersonCost personCost);

    /**
     * @Description : 根据主键获取人员成本信息
     * @methodName : getPersonCostById
     * @param id :
     * @return : com.xwkj.cost.model.PersonCost
     * @exception :
     * @author : 张永辉
     */
    PersonCost getPersonCostById(Long id);

}
