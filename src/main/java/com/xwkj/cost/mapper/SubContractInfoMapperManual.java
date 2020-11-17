package com.xwkj.cost.mapper;

import com.xwkj.cost.model.SubContractInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubContractInfoMapperManual {


    /**
     * @Description : 根据合同主键获取成本合同列表信息
     * @methodName : getSubContractInfoListByContractId
     * @param subContractInfo :
     * @return : java.util.List<com.xwkj.cost.model.SubContractInfo>
     * @exception : 
     * @author : zyh
     */
    List<SubContractInfo> getSubContractInfoListByContractId(SubContractInfo subContractInfo);

    /**
     * @Description : 根据条件获取成本合同信息
     * @methodName : getSubContractInfoByCondition
     * @param subContractInfo :
     * @return : com.xwkj.cost.model.SubContractInfo
     * @exception :
     * @author : 张永辉
     */
    SubContractInfo getSubContractInfoByCondition(SubContractInfo subContractInfo);
}