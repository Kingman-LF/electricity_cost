package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.RecordInfo;
import com.xwkj.cost.service.RecordInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @program: electricity_cost
 * @description:
 * @author: 张永辉
 * @create: 2021-03-16 17:30
 **/
@RestController
@Slf4j
public class RecordInfoController {
    
    @Autowired
    private RecordInfoService recordInfoService;
    
    /**
     * @Description : 添加记录
     * @methodName : addRecordInfo
     * @param recordInfo : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : 张永辉
     */
    @PostMapping("/addRecordInfo")
    public ResponseResult addRecordInfo(RecordInfo recordInfo) {
        ResponseResult responseResult = null;
        try {
            recordInfoService.addRecordInfo(recordInfo);
            log.info("添加记录成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加记录成功！");
        } catch(Exception e){
            log.error("添加记录失败！",e);
            responseResult = ResponseResult.failure("添加记录失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 修改记录
     * @methodName : updateRecordInfo
     * @param recordInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updateRecordInfo")
    public ResponseResult updateRecordInfo(RecordInfo recordInfo){
        ResponseResult responseResult = null;
        try {
            recordInfoService.updateRecordInfo(recordInfo);
            log.info("修改记录成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改记录成功！");
        } catch(Exception e){
            log.error("修改记录失败！",e);
            responseResult = ResponseResult.failure("添加记录失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 删除记录
     * @methodName : deleteRecordInfo
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/deleteRecordInfo/{id}")
    public ResponseResult deleteRecordInfo(@PathVariable("id") Long id){
        ResponseResult responseResult = null;
        try {
            recordInfoService.deleteRecordInfo(id);
            log.info("删除记录成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除记录成功！");
        } catch(Exception e){
            log.error("删除记录失败！",e);
            responseResult = ResponseResult.failure("删除记录失败！");
        }
        return responseResult;
    }

    /**
     * @Description : 获取记录列表
     * @methodName : getRecordInfoList
     * @param recordInfo :
     * @param pageUtil :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getRecordInfoList")
    public ResponseResult getRecordInfoList(RecordInfo recordInfo, PageUtil pageUtil){
        ResponseResult responseResult = null;
        try {
            PageInfo<RecordInfo> recordInfoList = recordInfoService.getRecordInfoList(recordInfo, pageUtil);
            log.info("获取记录列表成功！");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),recordInfoList,"获取记录列表成功！");
        } catch(Exception e){
            log.error("获取记录列表失败！",e);
            responseResult = ResponseResult.failure("获取记录列表失败！");
        }
        return responseResult;
    }

    
}
