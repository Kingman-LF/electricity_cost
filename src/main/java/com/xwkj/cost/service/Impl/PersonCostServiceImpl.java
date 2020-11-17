package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.PersonCostMapperManual;
import com.xwkj.cost.mapper.auto.CostTypeInfoMapper;
import com.xwkj.cost.mapper.auto.PersonCostMapper;
import com.xwkj.cost.model.CostTypeInfo;
import com.xwkj.cost.model.PersonCost;
import com.xwkj.cost.service.PersonCostService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: electricity_cost
 * @description: 人员成本服务层
 * @author: 张永辉
 * @create: 2020-06-28 13:42
 **/
@Service
public class PersonCostServiceImpl implements PersonCostService {

    @Autowired
    private PersonCostMapper personCostMapper;
    @Autowired
    private PersonCostMapperManual personCostMapperManual;
    @Autowired
    private CostTypeInfoMapper costTypeInfoMapper;



    /**
     * @Description : 添加人员成本信息
     * @methodName : addPersonCost
     * @param personCost :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void addPersonCost(PersonCost personCost) {
        personCostMapper.insertSelective(personCost);
    }


    /**
     * @Description : 修改人员成本
     * @methodName : updatePersonCost
     * @param personCost :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void updatePersonCost(PersonCost personCost) {
        personCostMapper.updateByPrimaryKeySelective(personCost);
    }

    /**
     * @Description : 删除人员成本信息
     * @methodName : deletePersonCost
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void deletePersonCost(Long id) {
        PersonCost personCost = new PersonCost();
        personCost.setId(id).setIsEnable(0);
        personCostMapper.updateByPrimaryKeySelective(personCost);
    }

    /**
     * @Description : 批量删除人员成本信息
     * @methodName : batchDeletePersonCost
     * @param ids :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    @Override
    public void batchDeletePersonCost(String ids) {
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            PersonCost personCost = new PersonCost();
            personCost.setId(Long.parseLong(split[i])).setIsEnable(0);
            personCostMapper.updateByPrimaryKeySelective(personCost);
        }
    }

    /**
     * @Description : 获取人员成本列表
     * @methodName : getPersonCostList
     * @param personCost :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.PersonCost>
     * @exception :
     * @author : 张永辉
     */
    @Override
    public PageInfo<PersonCost> getPersonCostList(PageUtil pageUtil, PersonCost personCost) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<PersonCost> personCostList = personCostMapperManual.getPersonCostList(personCost);
        for (PersonCost cost : personCostList) {
            String str = cost.getCostTypeId();
            String[] split = str.split(",");
            CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length-1]));
            cost.setCostTypeName(costTypeInfo.getName());
        }
        return new PageInfo<>(personCostList);
    }

    /**
     * @Description : 根据主键获取人员成本信息
     * @methodName : getPersonCostById
     * @param id :
     * @return : com.xwkj.cost.model.PersonCost
     * @exception :
     * @author : 张永辉
     */
    @Override
    public PersonCost getPersonCostById(Long id) {
        PersonCost personCost = personCostMapper.selectByPrimaryKey(id);
        String costTypeId = personCost.getCostTypeId();
        String[] split = costTypeId.split(",");
        CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length - 1]));
        personCost.setCostTypeName(costTypeInfo.getName());
        return personCost;
    }
}
