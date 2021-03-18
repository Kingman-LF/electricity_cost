package com.xwkj.cost.service.Impl;

import ch.qos.logback.core.joran.conditional.IfAction;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.mapper.ApplyInvoiceInfoMapperManual;
import com.xwkj.cost.mapper.MoneyBackInfoMapperManual;
import com.xwkj.cost.mapper.auto.ApplyInvoiceInfoMapper;
import com.xwkj.cost.mapper.auto.MoneyBackInfoMapper;
import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.xwkj.cost.model.MoneyBackInfo;
import com.xwkj.cost.service.MoneyBackInfoService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.MoneyBackVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class MoneyBackInfoServiceImpl implements MoneyBackInfoService {

    @Autowired
     MoneyBackInfoMapper moneyBackInfoMapper;
    @Autowired
     MoneyBackInfoMapperManual moneyBackInfoMapperManual;
    @Autowired
    ApplyInvoiceInfoMapper applyInvoiceInfoMapper;
    @Autowired
    ApplyInvoiceInfoMapperManual applyInvoiceInfoMapperManual;
    /**
     * @Description  ：获取回款信息列表
     * @methodName   : getMoneyBackInfoList
     * @param        : * @param pageUtil :
     * @param contractId :
     * @return       : com.github.pagehelper.PageInfo<com.xwkj.cost.model.MoneyBackInfo>
     * @exception    :
     * @author       : 张童
     */

    @Override
    public PageInfo<MoneyBackInfo> getMoneyBackInfoList(PageUtil pageUtil, Long contractId) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<MoneyBackInfo> list = moneyBackInfoMapperManual.getMoneyBackInfoList(contractId);
        return new PageInfo<>(list);
    }

    /**
     * @Description  ：获取总额和总数
     * @methodName   : getSumAndCount
     * @param        :
     * @return       : java.util.List<com.xwkj.cost.vo.MoneyBackVo>
     * @exception    :
     * @author       : 张童
     */
    @Override
    public MoneyBackVo getSumAndCount(Long contractId) {
        MoneyBackVo moneyBackVo = moneyBackInfoMapperManual.getSumAndCount(contractId);
        if (moneyBackVo != null){
            if (moneyBackVo.getMoneySum() == null){
                moneyBackVo.setMoneySum(BigDecimal.valueOf(0));
            }
        }
        return moneyBackVo;
    }
    /**
     * @Description  ：插入回款
     * @methodName   : insertMoneyBackInfo
     * @param        : * @param moneyBackInfo :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    @Override
    public void insertMoneyBackInfo(MoneyBackInfo moneyBackInfo) {



        moneyBackInfo.setCreateTime(new Date()).setCreator(LoginUserInfoManager.getUserInfo().getId())
                .setCreateUser(LoginUserInfoManager.getUserInfo().getUserName()).setStatus(1);
        moneyBackInfoMapper.insertSelective(moneyBackInfo);

        ApplyInvoiceInfo applyInvoiceInfo = new ApplyInvoiceInfo();
        applyInvoiceInfo.setId(moneyBackInfo.getApplyInvoiceId());
        applyInvoiceInfo.setMoneyBackId(moneyBackInfo.getId());
        applyInvoiceInfoMapper.updateByPrimaryKeySelective(applyInvoiceInfo);

    }
    /**
     * @Description  ：修改回款信息
     * @methodName   : updateMoneyBackInfo
     * @param        : * @param moneyBackInfo :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    @Override
    public void updateMoneyBackInfo(MoneyBackInfo moneyBackInfo) {
        moneyBackInfoMapper.updateByPrimaryKeySelective(moneyBackInfo);

        ApplyInvoiceInfo applyInvoiceInfo = new ApplyInvoiceInfo();
        applyInvoiceInfo.setMoneyBackId(moneyBackInfo.getId());

        //查出来清除回款Id
        List<ApplyInvoiceInfo> applyInvoiceInfo1 = applyInvoiceInfoMapperManual.getApplyInvoiceInfo(applyInvoiceInfo);
        for (ApplyInvoiceInfo a: applyInvoiceInfo1) {
            a.setMoneyBackId(null);
            applyInvoiceInfoMapper.updateByPrimaryKey(a);
        }

        applyInvoiceInfo.setId(moneyBackInfo.getApplyInvoiceId());
        applyInvoiceInfoMapper.updateByPrimaryKeySelective(applyInvoiceInfo);
    }

    /**
     * @Description  ：获得该条回款记录的详细信息
     * @methodName   : findMoneyBackById
     * @param        : * @param moneyBackId :
     * @return       : com.xwkj.cost.model.MoneyBackInfo
     * @exception    :
     * @author       : 张童
     */

    @Override
    public MoneyBackInfo findMoneyBackById(Long moneyBackId) {
        return moneyBackInfoMapperManual.findMoneyBackById(moneyBackId);
    }

    @Override
    public void deleteMoneyBackInfo(Long id) {
        MoneyBackInfo moneyBackInfo = new MoneyBackInfo();
        moneyBackInfo.setId(id).setStatus(2);
        moneyBackInfoMapper.updateByPrimaryKeySelective(moneyBackInfo);

        ApplyInvoiceInfo applyInvoiceInfo = new ApplyInvoiceInfo();
        applyInvoiceInfo.setMoneyBackId(moneyBackInfo.getId());
        List<ApplyInvoiceInfo> applyInvoiceInfo1 = applyInvoiceInfoMapperManual.getApplyInvoiceInfo(applyInvoiceInfo);
        for (ApplyInvoiceInfo a: applyInvoiceInfo1) {
            a.setStatus(0);
            applyInvoiceInfoMapper.updateByPrimaryKey(a);
        }
    }
}
