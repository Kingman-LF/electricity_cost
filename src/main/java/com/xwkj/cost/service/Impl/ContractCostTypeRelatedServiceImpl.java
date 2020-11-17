package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ContractCostTypeRelatedMapperManual;
import com.xwkj.cost.mapper.auto.ContractCostTypeRelatedMapper;
import com.xwkj.cost.mapper.auto.CostTypeInfoMapper;
import com.xwkj.cost.model.ContractCostTypeRelated;
import com.xwkj.cost.model.CostTypeInfo;
import com.xwkj.cost.service.ContractCostTypeRelatedService;
import com.xwkj.cost.util.PageUtil;
import org.apache.tools.ant.util.facade.FacadeTaskHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractCostTypeRelatedServiceImpl implements ContractCostTypeRelatedService {

    @Autowired
    ContractCostTypeRelatedMapper contractCostTypeRelatedMapper;
    @Autowired
    ContractCostTypeRelatedMapperManual contractCostTypeRelatedMapperManual;
    @Autowired
    CostTypeInfoMapper costTypeInfoMapper;

    /**
     * @Description : 获取其他成本列表
     * @methodName : getContractCostTypeRelatedList
     * @param pageUtil :
     * @param contractCostTypeRelated :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.ContractCostTypeRelated>
     * @exception :
     * @author : zyh
     */
    @Override
    public PageInfo<ContractCostTypeRelated> getContractCostTypeRelatedList(PageUtil pageUtil, ContractCostTypeRelated contractCostTypeRelated) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<ContractCostTypeRelated> list = contractCostTypeRelatedMapperManual.getContractCostTypeRelatedListByContractId(contractCostTypeRelated);
        if (list != null ){
            for (ContractCostTypeRelated c : list){
                String str = c.getCostTypeId();
                String[] split = str.split(",");
                CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length-1]));
                if (costTypeInfo != null){
                    c.setCostTypeName(costTypeInfo.getName());
                }
            }
        }
        return new PageInfo<>(list);
    }

    /**
     * @description: 获取其他成本列表不分页接口实现
     * @methodName: getContractCostTypeRelatedListWithoutPage
     * @param: [contractId]
     * @return: java.util.List<com.xwkj.cost.model.ContractCostTypeRelated>
     * @exception:
     * @date:  2019-12-13 16:00
     * @author: wanglei
     */
    @Override
    public List<ContractCostTypeRelated> getContractCostTypeRelatedListWithoutPage(Long contractId) {
        List<ContractCostTypeRelated> list = contractCostTypeRelatedMapperManual.getContractCostTypeRelatedListByContractId(new ContractCostTypeRelated().setContractId(contractId));
        if (list != null ){
            for (ContractCostTypeRelated c : list){
                String str = c.getCostTypeId();
                String[] split = str.split(",");
                CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length-1]));
                if (costTypeInfo != null){
                    c.setCostTypeName(costTypeInfo.getName());
                }
            }
        }
        return list;
    }

    /**
     * @Description : 添加其他成本信息
     * @methodName : addContractCostTypeRelated
     * @param contractCostTypeRelated :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public boolean addContractCostTypeRelated(ContractCostTypeRelated contractCostTypeRelated) {
        if (contractCostTypeRelated.getContractId()==null){
            contractCostTypeRelated.setContractId((long) -1);
        }
        //根据成本类型、成本金额和日期去重
        ContractCostTypeRelated info = contractCostTypeRelatedMapperManual.getContractCostTypeRelatedByCondition(contractCostTypeRelated);
        if (info != null){
            return false;
        }
        contractCostTypeRelatedMapper.insertSelective(contractCostTypeRelated);
        return true;
    }

    /**
     * @Description : 修改其他成本信息
     * @methodName : updateContractCostTypeRelated
     * @param contractCostTypeRelated :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void updateContractCostTypeRelated(ContractCostTypeRelated contractCostTypeRelated) {
        contractCostTypeRelatedMapper.updateByPrimaryKeySelective(contractCostTypeRelated);
    }

    /**
     * @Description : 删除其他成本信息
     * @methodName : deleteContractCostTypeRelated
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteContractCostTypeRelated(Long id) {
        ContractCostTypeRelated contractCostTypeRelated = new ContractCostTypeRelated();
        contractCostTypeRelated.setId(id).setIsEnable(0);
        contractCostTypeRelatedMapper.updateByPrimaryKeySelective(contractCostTypeRelated);
    }

    /**
     * @Description : 批量删除其他成本信息
     * @methodName : batchDeleteContractCostTypeRelated
     * @param ids :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void batchDeleteContractCostTypeRelated(String ids) {
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            ContractCostTypeRelated contractCostTypeRelated = new ContractCostTypeRelated();
            contractCostTypeRelated.setId(Long.parseLong(split[i])).setIsEnable(0);
            contractCostTypeRelatedMapper.updateByPrimaryKeySelective(contractCostTypeRelated);
        }
    }

    /**
     * @Description : 根据主键获取其他成本信息
     * @methodName : getContractCostTypeRelatedById
     * @param id :
     * @return : com.xwkj.cost.model.ContractCostTypeRelated
     * @exception :
     * @author : zyh
     */
    @Override
    public ContractCostTypeRelated getContractCostTypeRelatedById(Long id) {
        ContractCostTypeRelated contractCostTypeRelated = contractCostTypeRelatedMapper.selectByPrimaryKey(id);
        String costTypeId = contractCostTypeRelated.getCostTypeId();
        String[] split = costTypeId.split(",");
        CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length - 1]));
        contractCostTypeRelated.setCostTypeName(costTypeInfo.getName());
        return contractCostTypeRelated;
    }
}
