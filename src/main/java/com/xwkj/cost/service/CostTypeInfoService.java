package com.xwkj.cost.service;

import com.xwkj.cost.model.CostTypeInfo;

import java.util.List;

public interface CostTypeInfoService {

    /**
     * @Description : 获取成本分类列表
     * @methodName : getCostTypeInfoList
     * @return : java.util.List<com.xwkj.cost.model.CostTypeInfo>
     * @exception :
     * @author : zyh
     */
    List<CostTypeInfo> getCostTypeInfoList(String typeName);

    /**
     * @Description : 增加成本分类信息
     * @methodName : addCostTypeInfo
     * @param costTypeInfo :
     * @return : java.lang.Long
     * @exception :
     * @author : zyh
     */
    Long addCostTypeInfo(CostTypeInfo costTypeInfo);

    /**
     * @Description : 修改成本分类信息
     * @methodName : updateCostTypeInfo
     * @param costTypeInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void updateCostTypeInfo(CostTypeInfo costTypeInfo);

    /**
     * @Description : 删除成本分类信息
     * @methodName : deleteCostTypeInfo
     * @param ids :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void deleteCostTypeInfo(String ids);

    /**
     * @Description : 根据合同主键获取成本类型树
     * @methodName : getCostTypeInfoListByContractId
     * @param contractId :
     * @return : java.util.List<com.xwkj.cost.model.CostTypeInfo>
     * @exception : 
     * @author : zyh
     */
    List<CostTypeInfo> getCostTypeInfoListByContractId(Long contractId, String name);

    /**
     * @Description : 根据类型主键获取树主键组成的字符串
     * @methodName : getCostTypeInfosStr
     * @param id :
     * @return : java.lang.String
     * @exception :
     * @author : 张永辉
     */
    String getCostTypeInfosStr(Long id);

}
