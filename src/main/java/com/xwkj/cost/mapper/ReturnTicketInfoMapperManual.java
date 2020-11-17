package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ReturnTicketInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReturnTicketInfoMapperManual {

    /**
     * @Description : 根据成本合同主键获取回票信息列表
     * @methodName : getReturnTicketInfoList
     * @return : java.util.List<com.xwkj.cost.model.ReturnTicketInfo>
     * @exception : 
     * @author : zyh
     */
    List<ReturnTicketInfo> getReturnTicketInfoListBySubContractId(Long id);

}