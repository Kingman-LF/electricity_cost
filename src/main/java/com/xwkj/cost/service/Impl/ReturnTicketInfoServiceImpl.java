package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ReturnTicketInfoMapperManual;
import com.xwkj.cost.mapper.auto.ReturnTicketInfoMapper;
import com.xwkj.cost.model.ReturnTicketInfo;
import com.xwkj.cost.service.ReturnTicketInfoService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnTicketInfoServiceImpl implements ReturnTicketInfoService {

    @Autowired
    ReturnTicketInfoMapper returnTicketInfoMapper;
    @Autowired
    ReturnTicketInfoMapperManual returnTicketInfoMapperManual;


    /**
     * @Description : 根据成本合同主键获取回票信息列表
     * @methodName : getReturnTicketInfoList
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.ReturnTicketInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public PageInfo<ReturnTicketInfo> getReturnTicketInfoList(PageUtil pageUtil,Long id) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<ReturnTicketInfo> list = returnTicketInfoMapperManual.getReturnTicketInfoListBySubContractId(id);
        return new PageInfo<>(list);
    }

    /**
     * @Description : 添加回票信息
     * @methodName : addReturnTicketInfo
     * @param returnTicketInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void addReturnTicketInfo(ReturnTicketInfo returnTicketInfo) {
        returnTicketInfoMapper.insertSelective(returnTicketInfo);
    }

    /**
     * @Description : 修改回票信息
     * @methodName : updateReturnTicketInfo
     * @param returnTicketInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void updateReturnTicketInfo(ReturnTicketInfo returnTicketInfo) {
        returnTicketInfoMapper.updateByPrimaryKeySelective(returnTicketInfo);
    }

    /**
     * @Description : 删除回票信息
     * @methodName : deleteReturnTicketInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteReturnTicketInfo(Long id) {
        ReturnTicketInfo returnTicketInfo = new ReturnTicketInfo();
        returnTicketInfo.setId(id).setIsEnable(0);
        returnTicketInfoMapper.updateByPrimaryKeySelective(returnTicketInfo);
    }
}
