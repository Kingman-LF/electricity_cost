package com.xwkj.cost.mapper;

import com.xwkj.cost.model.MoneyBackInfo;
import com.xwkj.cost.vo.MoneyBackVo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MoneyBackInfoMapperManual {

    /**
     * @Description  ：获取回款列表
     * @methodName   : selectMoneyBackList
     * @param        : * @param pageUtil :
     * @param contractId :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    List<MoneyBackInfo> getMoneyBackInfoList(Long contractId);

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
     * @Description  ：获得该条回款记录的详细信息
     * @methodName   : findMoneyBackById
     * @param        : * @param moneyBackId :
     * @return       : com.xwkj.cost.model.MoneyBackInfo
     * @exception    :
     * @author       : 张童
     */

    MoneyBackInfo findMoneyBackById(Long moneyBackId);
}