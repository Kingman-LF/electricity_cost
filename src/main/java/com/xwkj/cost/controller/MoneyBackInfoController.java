package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.MoneyBackInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.MoneyBackInfoService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.MoneyBackVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
public class MoneyBackInfoController {
    @Autowired
    private MoneyBackInfoService moneyBackInfoService;

    /**
     * @Description  ：获取回款列表
     * @methodName   : selectMoneyBackList
     * @param        : * @param pageUtil :
     * @param contractId :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    @PostMapping("/selectMoneyBackList")
    public ResponseResult selectMoneyBackList(PageUtil pageUtil, Long contractId){
        log.info("查询回款列表");
        ResponseResult responseResult = null;
        try {
            PageInfo<MoneyBackInfo> moneyBackInfoPageInfo = moneyBackInfoService.getMoneyBackInfoList(pageUtil,contractId);
            log.info("获取回款列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),moneyBackInfoPageInfo,"获取回款列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取回款列表失败");
            responseResult = ResponseResult.failure("获取回款列表失败");
        }
        return responseResult;
    }

    /**
     * @Description  ：插入回款
     * @methodName   : insertMoneyBackInfo
     * @param        : * @param moneyBackInfo :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    @PostMapping("/insertMoneyBackInfo")
    public ResponseResult insertMoneyBackInfo(MoneyBackInfo moneyBackInfo){
            log.info("添加回款");
            ResponseResult responseResult = null;
            try {
                moneyBackInfoService.insertMoneyBackInfo(moneyBackInfo);
                log.info("插入成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"插入成功");
            }catch(Exception e){
                e.printStackTrace();
                log.error("插入失败");
                responseResult = ResponseResult.failure("插入失败");
            }
        return responseResult;
    }

    /**
     * @Description  ：修改回款信息
     * @methodName   : updateMoneyBackInfo
     * @param        : * @param moneyBackInfo :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    @PostMapping("/updateMoneyBackInfo")
    public ResponseResult updateMoneyBackInfo(MoneyBackInfo moneyBackInfo){
        log.info("修改回款");
        ResponseResult responseResult = null;
        try {
            moneyBackInfoService.updateMoneyBackInfo(moneyBackInfo);
            log.info("修改成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改成功");
        }catch(Exception e){
            e.printStackTrace();
            log.error("修改失败");
            responseResult = ResponseResult.failure("修改失败");
        }
        return responseResult;
    }

    /**
     * @Description  ：获得回款总金额和总数
     * @methodName   : getSumAndCount
     * @param        : * @param contractId :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    @PostMapping("/getSumAndCount")
    public ResponseResult getSumAndCount(Long contractId){
        log.info("获得回款总金额和总数");
        ResponseResult responseResult = null;
        try {
            MoneyBackVo moneyBackVo = moneyBackInfoService.getSumAndCount(contractId);
            log.info("获得回款总金额和总数成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),moneyBackVo,"获得回款总金额和总数成功");
        }catch(Exception e){
            e.printStackTrace();
            log.error("获得回款总金额和总数失败");
            responseResult = ResponseResult.failure("获得回款总金额和总数失败");
        }
        return responseResult;
    }

    /**
     * @Description  ：获得该条回款记录的详细信息
     * @methodName   : findMoneyBackById
     * @param        : * @param moneyBackId :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */
    @PostMapping("/findMoneyBackById")
    public ResponseResult findMoneyBackById(Long moneyBackId){
        log.info("获得该条回款记录的详细信息");
        ResponseResult responseResult = null;
        try {
            MoneyBackInfo moneyBackInfo = moneyBackInfoService.findMoneyBackById(moneyBackId);
            log.info("获得该条回款记录的详细信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),moneyBackInfo,"获得该条回款记录的详细信息成功");
        }catch(Exception e){
            e.printStackTrace();
            log.error("获得该条回款记录的详细信息失败");
            responseResult = ResponseResult.failure("获得该条回款记录的详细信息失败");
        }
        return responseResult;
    }

    @DeleteMapping("/deleteMoneyBack/{id}")
    public ResponseResult deleteSubContractCost(@PathVariable Long id) {
        ResponseResult responseResult = null;
        try {
            moneyBackInfoService.deleteMoneyBackInfo(id);
            log.info("删除回款信息的成本成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除回款信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除回款信息失败");
            responseResult = ResponseResult.failure("删除回款信息失败");
        }
        return responseResult;
    }

}
