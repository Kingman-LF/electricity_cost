package com.xwkj.cost.mapper;

import com.xwkj.cost.model.SubEnclosureInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubEnclosureInfoMapperManual {

    /**
     * @Description : 根据成本合同主键获取成本合同的附件列表
     * @methodName : getSubEnclosureInfoBySubContractId
     * @param subContractId :
     * @return : java.util.List<com.xwkj.cost.model.SubEnclosureInfo>
     * @exception :
     * @author : zyh
     */
    List<SubEnclosureInfo> getSubEnclosureInfoBySubContractId(Long subContractId);
}