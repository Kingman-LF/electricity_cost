package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.SubContractCost;
import com.xwkj.cost.util.PageUtil;

public interface SubContractCostService {

    /**
     * @Description : 根据成本合同主键获取成本合同的成本列表
     * @methodName : getSubContractCostListBySubContractId
     * @param pageUtil :
     * @param id :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.SubContractCost>
     * @exception :
     * @author : zyh
     */
    PageInfo<SubContractCost> getSubContractCostListBySubContractId(PageUtil pageUtil, Long id);

    /**
     * @Description : 添加成本合同的成本
     * @methodName : addSubContractCost
     * @param subContractCost :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    Boolean addSubContractCost(SubContractCost subContractCost);

    /**
     * @Description : 修改成本合同的成本
     * @methodName : updateSubContractCost
     * @param subContractCost :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    Boolean updateSubContractCost(SubContractCost subContractCost);

    /**
     * @Description : 删除成本合同的成本
     * @methodName : deleteSubContractCost
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void deleteSubContractCost(Long id);

}
