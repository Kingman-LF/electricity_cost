package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.CostTypeInfo;
import com.xwkj.cost.service.CostTypeInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class CostTypeInfoController {

    @Autowired
    CostTypeInfoService costTypeInfoService;

    /**
     * @Description : 获取成本分类列表
     * @methodName : getCostTypeInfoList
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getCostTypeInfoList")
    public ResponseResult getCostTypeInfoList() {
        ResponseResult responseResult = null;
        try {
            List<CostTypeInfo> list = costTypeInfoService.getCostTypeInfoList();
            log.info("获取成本分类列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取成本分类列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取成本分类列表失败");
            responseResult = ResponseResult.failure("获取成本分类列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加成本分类信息
     * @methodName : addCostTypeInfo
     * @param costTypeInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PostMapping("/addCostTypeInfo")
    public ResponseResult addCostTypeInfo(CostTypeInfo costTypeInfo){
        ResponseResult responseResult = null;
        try {
            Long id = costTypeInfoService.addCostTypeInfo(costTypeInfo);
            log.info("添加成本分类信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),id,"添加成本分类信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("添加成本分类信息失败");
            responseResult = ResponseResult.failure("添加成本分类信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改成本分类信息
     * @methodName : updateCostTypeInfo
     * @param costTypeInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PutMapping("/updateCostTypeInfo")
    public ResponseResult updateCostTypeInfo(CostTypeInfo costTypeInfo) {
        ResponseResult responseResult = null;
        try {
            costTypeInfoService.updateCostTypeInfo(costTypeInfo);
            log.info("修改成本分类信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改成本分类信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改成本分类信息失败");
            responseResult = ResponseResult.failure("修改成本分类信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除成本类型信息
     * @methodName : deleteCostTypeInfo
     * @param ids :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @DeleteMapping("/deleteCostTypeInfo/{ids}")
    public ResponseResult deleteCostTypeInfo(@PathVariable String ids) {
        ResponseResult responseResult = null;
        try {
            costTypeInfoService.deleteCostTypeInfo(ids);
            log.info("删除成本类型信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除成本类型信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除成本类型信息失败");
            responseResult = ResponseResult.failure("删除成本类型信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 根据合同主键获取成本类型树
     * @methodName : getCostTypeInfoListByContractId
     * @param contractId :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @GetMapping("/getCostTypeInfoListByContractId")
    public ResponseResult getCostTypeInfoListByContractId(Long contractId) {
        ResponseResult responseResult = null;
        try {
            List<CostTypeInfo> list = costTypeInfoService.getCostTypeInfoListByContractId(contractId);
            log.info("根据合同主键获取成本类型树成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"根据合同主键获取成本类型树成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("根据合同主键获取成本类型树失败");
            responseResult = ResponseResult.failure("根据合同主键获取成本类型树失败");
        }
        return responseResult;
    }

}
