package com.xwkj.cost.vo;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.MoneyBackInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName:MoneyBackVo
 * @Description:
 * @Author:张童
 * @Date:
 **/
public class MoneyBackVo {
    /**
     * 金额总数
     */

    private BigDecimal moneySum;

    /*
     * 回款条数
     */
    private Integer countNum;

    public BigDecimal getMoneySum() {
        return moneySum;
    }

    public void setMoneySum(BigDecimal moneySum) {
        this.moneySum = moneySum;
    }

    public Integer getCountNum() {
        return countNum;
    }

    public void setCountNum(Integer countNum) {
        this.countNum = countNum;
    }

}
