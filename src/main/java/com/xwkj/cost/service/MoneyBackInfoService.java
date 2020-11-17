package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.MoneyBackInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.MoneyBackVo;

import java.util.List;

public interface MoneyBackInfoService {

    /**
     * @Description  ：获取回款列表
     * @methodName   : getMoneyBackInfoList
     * @param        : * @param pageUtil :
     * @param contractId :
     * @return       : com.github.pagehelper.PageInfo<com.xwkj.cost.model.MoneyBackInfo>
     * @exception    :
     * @author       : 张童
     */
    PageInfo<MoneyBackInfo> getMoneyBackInfoList(PageUtil pageUtil, Long contractId);

    /**
     * @Description  ：获取总额和总数
     * @methodName   : getSumAndCount
     * @param        :
     * @return       : java.util.List<com.xwkj.cost.vo.MoneyBackVo>
     * @exception    :
     * @author       : 张童
     */
    MoneyBackVo getSumAndCount(Long contractId);

    /**
     * @Description  ：插入回款信息
     * @methodName   : insertMoneyBackInfo
     * @param        : * @param moneyBackInfo :
     * @return       : void
     * @exception    :
     * @author       : 张童
     */

    void insertMoneyBackInfo(MoneyBackInfo moneyBackInfo);

    /**
     * @Description  ：修改回款信息
     * @methodName   : updateMoneyBackInfo
     * @param        : * @param moneyBackInfo :
     * @return       : void
     * @exception    :
     * @author       : 张童
     */

    void updateMoneyBackInfo(MoneyBackInfo moneyBackInfo);

    /**
     * @Description  ：获得该条回款记录的详细信息
     * @methodName   : findMoneyBackById
     * @param        : * @param moneyBackId :
     * @return       : com.xwkj.cost.model.MoneyBackInfo
     * @exception    :
     * @author       : 张童
     */

    MoneyBackInfo findMoneyBackById(Long moneyBackId);

    void deleteMoneyBackInfo(Long id);
}
