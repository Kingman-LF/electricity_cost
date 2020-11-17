package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ReturnTicketInfoMapperManual;
import com.xwkj.cost.mapper.SubContractCostMapperManual;
import com.xwkj.cost.mapper.SubContractInfoMapperManual;
import com.xwkj.cost.mapper.auto.CostTypeInfoMapper;
import com.xwkj.cost.mapper.auto.SubContractInfoMapper;
import com.xwkj.cost.mapper.auto.SubEnclosureInfoMapper;
import com.xwkj.cost.model.CostTypeInfo;
import com.xwkj.cost.model.ReturnTicketInfo;
import com.xwkj.cost.model.SubContractInfo;
import com.xwkj.cost.model.SubEnclosureInfo;
import com.xwkj.cost.service.SubContractInfoService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class SubContractInfoServiceImpl implements SubContractInfoService {

    @Autowired
    SubContractInfoMapper subContractInfoMapper;
    @Autowired
    SubContractInfoMapperManual subContractInfoMapperManual;
    @Autowired
    CostTypeInfoMapper costTypeInfoMapper;
    @Autowired
    SubContractCostMapperManual subContractCostMapperManual;
    @Autowired
    SubEnclosureInfoMapper subEnclosureInfoMapper;
    @Autowired
    ReturnTicketInfoMapperManual returnTicketInfoMapperManual;

    /**
     * @Description : 根据合同主键获取成本合同列表信息
     * @methodName : getSubContractInfoList
     * @param pageUtil :
     * @param subContractInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.SubContractInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public PageInfo<SubContractInfo> getSubContractInfoList(PageUtil pageUtil, SubContractInfo subContractInfo) {

        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<SubContractInfo> list = subContractInfoMapperManual.getSubContractInfoListByContractId(subContractInfo);
        if (list != null){
            for(SubContractInfo s : list){
                String str = s.getCostTypeId();
                String[] split = str.split(",");
                CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length-1]));
                //计算未付款金额
                BigDecimal unpaid= s.getCostMoney().subtract(s.getSubContractCost());
                //获取成本合同回票信息
                List<ReturnTicketInfo> returnTicketInfoList = returnTicketInfoMapperManual.getReturnTicketInfoListBySubContractId(s.getId());
                //存储回票总金额
                BigDecimal returnTicketMoney = new BigDecimal(0);
                if (returnTicketInfoList != null && returnTicketInfoList.size() != 0 ){
                    for (ReturnTicketInfo r : returnTicketInfoList){
                        returnTicketMoney = returnTicketMoney.add(r.getMoney());
                    }
                }
                s.setCostTypeName(costTypeInfo.getName()).setUnpaid(unpaid).setReturnTicketMoney(returnTicketMoney);
            }
        }
        return new PageInfo<>(list);
    }

    /**
     * @description: 根据合同主键获取成本合同列表信息不分页
     * @methodName: getSubContractInfoListWithoutPage
     * @param: [contractId]
     * @return: java.util.List<com.xwkj.cost.model.SubContractInfo>
     * @exception:
     * @date:  2019-12-13 16:18
     * @author: wanglei
     */
	@Override
	public List<SubContractInfo> getSubContractInfoListWithoutPage(Long contractId) {
        List<SubContractInfo> list = subContractInfoMapperManual.getSubContractInfoListByContractId(new SubContractInfo().setContractId(contractId));
        if (list != null){
            for(SubContractInfo s : list){
                String str = s.getCostTypeId();
                String[] split = str.split(",");
                CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length-1]));
                //计算未付款金额
                BigDecimal unpaid= s.getCostMoney().subtract(s.getSubContractCost());
                s.setCostTypeName(costTypeInfo.getName()).setUnpaid(unpaid);
            }
        }
        return list;
    }

	/**
     * @Description : 修改成本合同信息
     * @methodName : updateSubContractInfo
     * @param subContractInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void updateSubContractInfo(SubContractInfo subContractInfo) {
        subContractInfoMapper.updateByPrimaryKeySelective(subContractInfo);
    }

    /**
     * @Description : 删除成本合同信息
     * @methodName : deleteSubContractInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteSubContractInfo(Long id) {
        SubContractInfo subContractInfo = new SubContractInfo();
        subContractInfo.setId(id).setStatus(0);
        subContractInfoMapper.updateByPrimaryKeySelective(subContractInfo);
    }

    /**
     * @Description : 批量删除成本合同信息
     * @methodName : batchDeleteSubContractInfo
     * @param ids :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void batchDeleteSubContractInfo(String ids) {
        String[] split = ids.split(",");
        for (int i = 0; i < split.length; i++) {
            SubContractInfo subContractInfo = new SubContractInfo();
            subContractInfo.setId(Long.parseLong(split[i])).setStatus(0);
            subContractInfoMapper.updateByPrimaryKeySelective(subContractInfo);
        }
    }

    /**
     * @Description : 添加成本合同信息
     * @methodName : addSubContractInfo
     * @param subContractInfo :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public boolean addSubContractInfo(SubContractInfo subContractInfo) {
        if (subContractInfo.getContractId()==null){
            subContractInfo.setContractId((long) -1);
        }

        //根据成本类型、成本金额和日期去重
        SubContractInfo info = subContractInfoMapperManual.getSubContractInfoByCondition(subContractInfo);
        if (info != null){
            return false;
        }

        Date date = new Date();
        //插入成本合同信息
        subContractInfo.setCreateTime(date).setSubContractCost(new BigDecimal(0));
        subContractInfoMapper.insertSelective(subContractInfo);
        //插入成本合同附带的附件信息
        String fileUploads = subContractInfo.getFileUploads();
        if (fileUploads != null && !"".equals(fileUploads)){
            fileUploads = fileUploads.substring(0 , fileUploads.length() - 1);
            String[] split = fileUploads.split(",");
            for (int i = 0; i < split.length; i++) {
                SubEnclosureInfo subEnclosureInfo = new SubEnclosureInfo();
                subEnclosureInfo.setFilePath(split[i]).setCreatTime(date).setSubContractId(subContractInfo.getId());
                subEnclosureInfoMapper.insertSelective(subEnclosureInfo);
            }
        }
        return true;
    }

    /**
     * @Description : 根据主键获取成本合同信息
     * @methodName : getSubContractInfo
     * @param id :
     * @return : com.xwkj.cost.model.SubContractInfo
     * @exception :
     * @author : zyh
     */
    @Override
    public SubContractInfo getSubContractInfo(Long id) {
        SubContractInfo subContractInfo = subContractInfoMapper.selectByPrimaryKey(id);
        String costTypeId = subContractInfo.getCostTypeId();
        String[] split = costTypeId.split(",");
        CostTypeInfo costTypeInfo = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length - 1]));
        subContractInfo.setCostTypeName(costTypeInfo.getName());
        return subContractInfo;
    }
}
