package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.SubContractInfo;
import com.xwkj.cost.service.SubContractInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class SubContractInfoController {

    @Autowired
    SubContractInfoService subContractInfoService;

    /**
     * @Description : 根据合同主键获取成本合同列表信息
     * @methodName : getSubContractInfoList
     * @param pageUtil : 
     * @param subContractInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @GetMapping("/getSubContractInfoList")
    public ResponseResult getSubContractInfoList(PageUtil pageUtil, SubContractInfo subContractInfo) {
        ResponseResult responseResult = null;
        try {
            PageInfo<SubContractInfo> list = subContractInfoService.getSubContractInfoList(pageUtil, subContractInfo);
            log.info("获取成本合同列表信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取成本合同列表信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取成本合同列表信息失败");
            responseResult = ResponseResult.failure("获取成本合同列表信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改成本合同信息
     * @methodName : updateSubContractInfo
     * @param subContractInfo : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PutMapping("/updateSubContractInfo")
    public ResponseResult updateSubContractInfo(SubContractInfo subContractInfo) {
        ResponseResult responseResult = null;
        try {
            subContractInfoService.updateSubContractInfo(subContractInfo);
            log.info("修改成本合同信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改成本合同信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改成本合同信息失败");
            responseResult = ResponseResult.failure("修改成本合同信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除成本合同信息
     * @methodName : deleteSubContractInfo
     * @param id : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @DeleteMapping("/deleteSubContractInfo/{id}")
    public ResponseResult deleteSubContractInfo(@PathVariable Long id) {
        ResponseResult responseResult = null;
        try {
            subContractInfoService.deleteSubContractInfo(id);
            log.info("删除成本合同信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除成本合同信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除成本合同信息失败");
            responseResult = ResponseResult.failure("删除成本合同信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 批量删除成本合同信息
     * @methodName : batchDeleteSubContractInfo
     * @param ids : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @DeleteMapping("/batchDeleteSubContractInfo/{ids}")
    public ResponseResult batchDeleteSubContractInfo(@PathVariable String ids) {
        ResponseResult responseResult = null;
        try {
            subContractInfoService.batchDeleteSubContractInfo(ids);
            log.info("批量删除成本合同信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"批量删除成本合同信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("批量删除成本合同信息失败");
            responseResult = ResponseResult.failure("批量删除成本合同信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加成本合同信息
     * @methodName : addSubContractInfo
     * @param subContractInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @PostMapping("/addSubContractInfo")
    public ResponseResult addSubContractInfo(SubContractInfo subContractInfo) {
        ResponseResult responseResult = null;
        try {
            boolean b = subContractInfoService.addSubContractInfo(subContractInfo);
            if (b){
                log.info("添加成本合同信息成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加成本合同信息成功");
            }else {
                log.info("同种成本类型的成本合同存在成本金额和日期相同的成本合同，添加失败！");
                responseResult = ResponseResult.failure("同种成本类型的成本合同存在成本金额和日期相同的成本合同，添加失败！");
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("添加成本合同信息失败");
            responseResult = ResponseResult.failure("添加成本合同信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 根据主键获取成本合同信息
     * @methodName : getSubContractInfo
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getSubContractInfo/{id}")
    public ResponseResult getSubContractInfo(@PathVariable Long id){
        ResponseResult responseResult = null;
        try {
            SubContractInfo subContractInfo = subContractInfoService.getSubContractInfo(id);
            log.info("获取成本合同信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),subContractInfo,"获取成本合同信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取成本合同信息失败");
            responseResult = ResponseResult.failure("获取成本合同信息失败");
        }
        return responseResult;
    }
}
