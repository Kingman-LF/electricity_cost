package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ReturnTicketInfo;
import com.xwkj.cost.util.PageUtil;

public interface ReturnTicketInfoService {

    /**
     * @Description : 根据成本合同主键获取回票信息列表
     * @methodName : getReturnTicketInfoList
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.ReturnTicketInfo>
     * @exception : 
     * @author : zyh
     */
    PageInfo<ReturnTicketInfo> getReturnTicketInfoList(PageUtil pageUtil,Long id);

    /**
     * @Description : 添加回票信息
     * @methodName : addReturnTicketInfo
     * @param returnTicketInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void addReturnTicketInfo(ReturnTicketInfo returnTicketInfo);

    /**
     * @Description : 修改回票信息
     * @methodName : updateReturnTicketInfo
     * @param returnTicketInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void updateReturnTicketInfo(ReturnTicketInfo returnTicketInfo);

    /**
     * @Description : 删除回票信息
     * @methodName : deleteReturnTicketInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void deleteReturnTicketInfo(Long id);

}
