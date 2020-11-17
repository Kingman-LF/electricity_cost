package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ContractCostTypeRelated;
import com.xwkj.cost.service.ContractCostTypeRelatedService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ContractCostTypeRelatedController {

    @Autowired
    ContractCostTypeRelatedService contractCostTypeRelatedService;

    /**
     * @Description : 获取其他成本列表
     * @methodName : getContractCostTypeRelatedList
     * @param pageUtil :
     * @param contractId :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getContractCostTypeRelatedList")
    public ResponseResult getContractCostTypeRelatedList(PageUtil pageUtil, ContractCostTypeRelated contractCostTypeRelated) {
        ResponseResult responseResult = null;
        try {
            PageInfo<ContractCostTypeRelated> pageInfo = contractCostTypeRelatedService.getContractCostTypeRelatedList(pageUtil, contractCostTypeRelated);
            log.info("获取其他成本列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),pageInfo,"获取其他成本列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取其他成本列表失败");
            responseResult = ResponseResult.failure("获取其他成本列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加其他成本信息
     * @methodName : addContractCostTypeRelated
     * @param contractCostTypeRelated :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PostMapping("/addContractCostTypeRelated")
    public ResponseResult addContractCostTypeRelated(ContractCostTypeRelated contractCostTypeRelated){
        ResponseResult responseResult = null;
        try {
            boolean b = contractCostTypeRelatedService.addContractCostTypeRelated(contractCostTypeRelated);
            if (b) {
                log.info("添加其他成本信息成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加其他成本信息成功");
            }else {
                log.info("同种成本类型的其他合同存在成本金额和日期相同的其他合同，添加失败！");
                responseResult = ResponseResult.failure("同种成本类型的其他合同存在成本金额和日期相同的其他合同，添加失败！");
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取其他成本列表失败");
            responseResult = ResponseResult.failure("获取其他成本列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改其他成本信息
     * @methodName : updateContractCostTypeRelated
     * @param contractCostTypeRelated :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PutMapping("/updateContractCostTypeRelated")
    public ResponseResult updateContractCostTypeRelated(ContractCostTypeRelated contractCostTypeRelated) {
        ResponseResult responseResult = null;
        try {
            contractCostTypeRelatedService.updateContractCostTypeRelated(contractCostTypeRelated);
            log.info("修改其他成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改其他成本信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改其他成本信息失败");
            responseResult = ResponseResult.failure("修改其他成本信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除其他成本信息
     * @methodName : deleteContractCostTypeRelated
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @DeleteMapping("/deleteContractCostTypeRelated/{id}")
    public ResponseResult deleteContractCostTypeRelated(@PathVariable Long id) {
        ResponseResult responseResult = null;
        try {
            contractCostTypeRelatedService.deleteContractCostTypeRelated(id);
            log.info("删除其他成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除其他成本信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除其他成本信息失败");
            responseResult = ResponseResult.failure("删除其他成本信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 批量删除其他成本信息
     * @methodName : batchDeleteContractCostTypeRelated
     * @param ids :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @DeleteMapping("/batchDeleteContractCostTypeRelated/{ids}")
    public ResponseResult batchDeleteContractCostTypeRelated(@PathVariable String ids) {
        ResponseResult responseResult = null;
        try {
            contractCostTypeRelatedService.batchDeleteContractCostTypeRelated(ids);
            log.info("批量删除其他成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"批量删除其他成本信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("批量删除其他成本信息失败");
            responseResult = ResponseResult.failure("批量删除其他成本信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 根据主键获取其他成本信息
     * @methodName : getContractCostTypeRelatedById
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getContractCostTypeRelatedById")
    public ResponseResult getContractCostTypeRelatedById(Long id){
        ResponseResult responseResult = null;
        try {
            ContractCostTypeRelated contractCostTypeRelatedById = contractCostTypeRelatedService.getContractCostTypeRelatedById(id);
            log.info("根据主键获取其他成本信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),contractCostTypeRelatedById,"根据主键获取其他成本信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("根据主键获取其他成本信息失败");
            responseResult = ResponseResult.failure("根据主键获取其他成本信息失败");
        }
        return responseResult;
    }

}
