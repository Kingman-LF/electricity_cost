package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.mapper.SubContractCostMapperManual;
import com.xwkj.cost.mapper.auto.SubContractCostMapper;
import com.xwkj.cost.mapper.auto.SubContractInfoMapper;
import com.xwkj.cost.model.SubContractCost;
import com.xwkj.cost.model.SubContractInfo;
import com.xwkj.cost.service.SubContractCostService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubContractCostServiceImpl implements SubContractCostService {

    @Autowired
    SubContractCostMapper subContractCostMapper;
    @Autowired
    SubContractCostMapperManual subContractCostMapperManual;
    @Autowired
    SubContractInfoMapper subContractInfoMapper;


    /**
     * @Description : 根据成本合同主键获取成本合同的成本列表
     * @methodName : getSubContractCostListBySubContractId
     * @param pageUtil :
     * @param id :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.SubContractCost>
     * @exception :
     * @author : zyh
     */
    @Override
    public PageInfo<SubContractCost> getSubContractCostListBySubContractId(PageUtil pageUtil,Long id) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<SubContractCost> list = subContractCostMapperManual.getSubContractCostListBySubContractId(id);
        return new PageInfo<>(list);
    }

    /**
     * @Description : 添加成本合同的成本
     * @methodName : addSubContractCost
     * @param subContractCost :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    @Override
    public Boolean addSubContractCost(SubContractCost subContractCost) {
        SubContractInfo subContractInfo = subContractInfoMapper.selectByPrimaryKey(subContractCost.getSubContractId());
        //成本金额
        BigDecimal costMoney = subContractInfo.getCostMoney();
        //总付款
        BigDecimal contractCost = subContractInfo.getSubContractCost();
        contractCost = contractCost.add(subContractCost.getCost());
        int i = contractCost.compareTo(costMoney);
        //如果总付款大于成本金额则插入失败
        if (i == 1){
            return false;
        }
        //否则插入成功,并且修改对应成本合同的总付款
        subContractCostMapper.insertSelective(subContractCost.setCreateUser(LoginUserInfoManager.getUserInfo().getUserName()));
        subContractInfo.setSubContractCost(contractCost);
        subContractInfoMapper.updateByPrimaryKeySelective(subContractInfo);
        return true;
    }

    /**
     * @Description : 修改成本合同的成本
     * @methodName : updateSubContractCost
     * @param subContractCost :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    @Override
    public Boolean updateSubContractCost(SubContractCost subContractCost) {
        SubContractInfo subContractInfo = subContractInfoMapper.selectByPrimaryKey(subContractCost.getSubContractId());
        //成本金额
        BigDecimal costMoney = subContractInfo.getCostMoney();
        //总付款
        BigDecimal contractCost = subContractInfo.getSubContractCost();
        //减去修改之前的成本
        contractCost = contractCost.subtract(subContractCost.getBeforeCost());
        //加上修改之后的成本
        contractCost = contractCost.add(subContractCost.getCost());
        int i = contractCost.compareTo(costMoney);
        //如果总付款大于成本金额则修改失败
        if (i == 1){
            return false;
        }
        //否则修改成功,并且修改对应成本合同的总付款
        subContractCostMapper.updateByPrimaryKeySelective(subContractCost);
        subContractInfo.setSubContractCost(contractCost);
        subContractInfoMapper.updateByPrimaryKeySelective(subContractInfo);
        return true;
    }

    /**
     * @Description : 删除成本合同的成本
     * @methodName : deleteSubContractCost
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteSubContractCost(Long id) {
        SubContractCost subContractCost = subContractCostMapper.selectByPrimaryKey(id);
        SubContractInfo subContractInfo = subContractInfoMapper.selectByPrimaryKey(subContractCost.getSubContractId());
        //成本合同总付款减去此次成本
        BigDecimal contractCost = subContractInfo.getSubContractCost();
        contractCost = contractCost.subtract(subContractCost.getCost());
        subContractInfo.setSubContractCost(contractCost);
        subContractInfoMapper.updateByPrimaryKeySelective(subContractInfo);
        //删除此次成本
        subContractCost.setIsEnbale(0);
        subContractCostMapper.updateByPrimaryKeySelective(subContractCost);
    }
}
