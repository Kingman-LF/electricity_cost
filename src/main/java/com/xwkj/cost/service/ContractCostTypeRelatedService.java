package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ContractCostTypeRelated;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

public interface ContractCostTypeRelatedService {

    /**
     * @Description : 获取其他成本列表
     * @methodName : getContractCostTypeRelatedList
     * @param pageUtil :
     * @param contractCostTypeRelated :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.ContractCostTypeRelated>
     * @exception :
     * @author : zyh
     */
    PageInfo<ContractCostTypeRelated> getContractCostTypeRelatedList(PageUtil pageUtil,ContractCostTypeRelated contractCostTypeRelated);

    /**
     * @description: 获取其他成本列表不分页接口
     * @methodName: getContractCostTypeRelatedListWithoutPage
     * @param: [contractId]
     * @return: java.util.List<com.xwkj.cost.model.ContractCostTypeRelated>
     * @exception:
     * @date:  2019-12-13 16:00
     * @author: wanglei
     */
    List<ContractCostTypeRelated> getContractCostTypeRelatedListWithoutPage(Long contractId);

    /**
     * @Description : 添加其他成本信息
     * @methodName : addContractCostTypeRelated
     * @param contractCostTypeRelated :
     * @return : void
     * @exception :
     * @author : zyh
     */
    boolean addContractCostTypeRelated(ContractCostTypeRelated contractCostTypeRelated);

    /**
     * @Description : 修改其他成本信息
     * @methodName : updateContractCostTypeRelated
     * @param contractCostTypeRelated :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void updateContractCostTypeRelated(ContractCostTypeRelated contractCostTypeRelated);

    /**
     * @Description : 删除其他成本信息
     * @methodName : deleteContractCostTypeRelated
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void deleteContractCostTypeRelated(Long id);

    /**
     * @Description : 批量删除其他成本信息
     * @methodName : batchDeleteContractCostTypeRelated
     * @param ids :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void batchDeleteContractCostTypeRelated(String ids);

    /**
     * @Description : 根据主键获取其他成本信息
     * @methodName : getContractCostTypeRelatedById
     * @param id :
     * @return : com.xwkj.cost.model.ContractCostTypeRelated
     * @exception :
     * @author : zyh
     */
    ContractCostTypeRelated getContractCostTypeRelatedById(Long id);

}
