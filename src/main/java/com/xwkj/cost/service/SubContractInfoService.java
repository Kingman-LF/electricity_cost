package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.SubContractInfo;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

public interface SubContractInfoService {

    /**
     * @Description : 根据合同主键获取成本合同列表信息
     * @methodName : getSubContractInfoList
     * @param pageUtil :
     * @param subContractInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.SubContractInfo>
     * @exception :
     * @author : zyh
     */
    PageInfo<SubContractInfo> getSubContractInfoList(PageUtil pageUtil, SubContractInfo subContractInfo);

    /**
     * @description: 根据合同主键获取成本合同列表信息不分页
     * @methodName: getSubContractInfoListWithoutPage
     * @param: [contractId]
     * @return: java.util.List<com.xwkj.cost.model.SubContractInfo>
     * @exception:
     * @date:  2019-12-13 16:18
     * @author: wanglei
     */
    List<SubContractInfo> getSubContractInfoListWithoutPage(Long contractId);

    /**
     * @Description : 修改成本合同信息
     * @methodName : updateSubContractInfo
     * @param subContractInfo : 
     * @return : void
     * @exception : 
     * @author : zyh
     */
    void updateSubContractInfo(SubContractInfo subContractInfo);

    /**
     * @Description : 删除成本合同信息
     * @methodName : deleteSubContractInfo
     * @param id :
     * @return : void
     * @exception : 
     * @author : zyh
     */
    void deleteSubContractInfo(Long id);

    /**
     * @Description : 批量删除成本合同信息
     * @methodName : batchDeleteSubContractInfo
     * @param ids : 
     * @return : void
     * @exception : 
     * @author : zyh
     */
    void batchDeleteSubContractInfo(String ids);

    /**
     * @Description : 添加成本合同信息
     * @methodName : addSubContractInfo
     * @param subContractInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    boolean addSubContractInfo(SubContractInfo subContractInfo);

    /**
     * @Description : 根据主键获取成本合同信息
     * @methodName : getSubContractInfo
     * @param id :
     * @return : com.xwkj.cost.model.SubContractInfo
     * @exception :
     * @author : zyh
     */
    SubContractInfo getSubContractInfo(Long id);

}
