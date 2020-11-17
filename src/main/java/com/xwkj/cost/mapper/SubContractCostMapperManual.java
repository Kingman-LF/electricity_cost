package com.xwkj.cost.mapper;

import com.xwkj.cost.model.SubContractCost;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubContractCostMapperManual {

    /**
     * @Description : 根据成本合同获取成本合同的成本列表
     * @methodName : getSubContractCostListBySubContractId
     * @param id : 
     * @return : java.util.List<com.xwkj.cost.model.SubContractCost>
     * @exception : 
     * @author : zyh
     */
    List<SubContractCost> getSubContractCostListBySubContractId(Long id);
}