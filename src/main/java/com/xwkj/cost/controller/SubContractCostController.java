package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.SubContractCost;
import com.xwkj.cost.service.SubContractCostService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SubContractCostController {

    @Autowired
    SubContractCostService subContractCostService;

    /**
     * @Description : 根据成本合同主键获取成本合同的成本列表
     * @methodName : getSubContractCostListBySubContractId
     * @param pageUtil :
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getSubContractCostListBySubContractId")
    public ResponseResult getSubContractCostListBySubContractId(PageUtil pageUtil, Long id) {
        ResponseResult responseResult = null;
        try {
            PageInfo<SubContractCost> pageInfo = subContractCostService.getSubContractCostListBySubContractId(pageUtil, id);
            log.info("获取成本合同的成本列表成本");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),pageInfo,"获取成本合同的成本列表成本");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取成本合同的成本列表失败");
            responseResult = ResponseResult.failure("获取成本合同的成本列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加成本合同的成本
     * @methodName : addSubContractCost
     * @param subContractCost :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PostMapping("/addSubContractCost")
    public ResponseResult addSubContractCost(SubContractCost subContractCost) {
        ResponseResult responseResult = null;
        try {
            Boolean b = subContractCostService.addSubContractCost(subContractCost);
            if (b){
                log.info("添加成本合同的成本成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加成本合同的成本成功");
            }else {
                log.error("添加失败，总付款超过成本金额！");
                responseResult = ResponseResult.failure("添加失败，总付款超过成本金额！");
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("添加成本合同的成本失败");
            responseResult = ResponseResult.failure("添加成本合同的成本失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改成本合同的成本
     * @methodName : updateSubContractCost
     * @param subContractCost :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PutMapping("/updateSubContractCost")
    public ResponseResult updateSubContractCost(SubContractCost subContractCost) {
        ResponseResult responseResult = null;
        try {
            Boolean b = subContractCostService.updateSubContractCost(subContractCost);
            if (b){
                log.info("修改成本合同的成本成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改成本合同的成本成功");
            }else {
                log.error("修改失败，总付款超过成本金额！");
                responseResult = ResponseResult.failure("修改失败，总付款超过成本金额！");
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改成本合同的成本失败");
            responseResult = ResponseResult.failure("修改成本合同的成本失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除成本合同的成本
     * @methodName : deleteSubContractCost
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @DeleteMapping("/deleteSubContractCost/{id}")
    public ResponseResult deleteSubContractCost(@PathVariable Long id) {
        ResponseResult responseResult = null;
        try {
            subContractCostService.deleteSubContractCost(id);
            log.info("删除成本合同的成本成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除成本合同的成本成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除成本合同的成本失败");
            responseResult = ResponseResult.failure("删除成本合同的成本失败");
        }
        return responseResult;
    }
}
