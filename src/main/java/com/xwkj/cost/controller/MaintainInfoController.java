package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.MaintainInfo;
import com.xwkj.cost.service.MaintainInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: electricity_cost
 * @description: 后期维护控制层
 * @author: 张永辉
 * @create: 2020-06-30 09:48
 **/
@RestController
@Slf4j
public class MaintainInfoController {

    @Autowired
    private MaintainInfoService maintainInfoService;

    /**
     * @Description : 获取后期维护列表
     * @methodName : getMaintainInfoList
     * @param pageUtil :
     * @param maintainInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/getMaintainInfoList")
    public ResponseResult getMaintainInfoList(PageUtil pageUtil, MaintainInfo maintainInfo){
        ResponseResult responseResult = null;
        try {
            PageInfo<MaintainInfo> list = maintainInfoService.getMaintainInfoList(pageUtil, maintainInfo);
            log.info("获取后期维护列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取后期维护列表成功");
        } catch(Exception e){
            log.error("获取后期维护列表失败",e);
            responseResult = ResponseResult.failure("获取后期维护列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加后期维护信息
     * @methodName : addMaintainInfo
     * @param maintainInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PostMapping("/addMaintainInfo")
    public ResponseResult addMaintainInfo(MaintainInfo maintainInfo){
        ResponseResult responseResult = null;
        try {
            maintainInfoService.addMaintainInfo(maintainInfo);
            log.info("添加后期维护信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加后期维护信息成功");
        } catch(Exception e){
            log.error("添加后期维护信息失败");
            responseResult = ResponseResult.failure("添加后期维护信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改后期维护信息
     * @methodName : updateMaintainInfo
     * @param maintainInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @PutMapping("/updateMaintainInfo")
    public ResponseResult updateMaintainInfo(MaintainInfo maintainInfo){
        ResponseResult responseResult = null;
        try {
            maintainInfoService.updateMaintainInfo(maintainInfo);
            log.info("修改后期维护信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改后期维护信息成功");
        } catch(Exception e){
            log.error("修改后期维护信息失败");
            responseResult = ResponseResult.failure("修改后期维护信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除后期维护信息
     * @methodName : deleteMaintainInfo
     * @param id :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/deleteMaintainInfo/{id}")
    public ResponseResult deleteMaintainInfo(@PathVariable("id") Long id){
        ResponseResult responseResult = null;
        try {
            maintainInfoService.deleteMaintainInfo(id);
            log.info("删除后期维护信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除后期维护信息成功");
        } catch(Exception e){
            log.error("删除后期维护信息失败");
            responseResult = ResponseResult.failure("删除后期维护信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 批量删除后期维护信息
     * @methodName : batchDeleteMaintainInfo
     * @param ids :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @DeleteMapping("/batchDeleteMaintainInfo/{ids}")
    public ResponseResult batchDeleteMaintainInfo(@PathVariable("ids") String ids){
        ResponseResult responseResult = null;
        try {
            maintainInfoService.batchDeleteMaintainInfo(ids);
            log.info("批量删除后期维护信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"批量删除后期维护信息成功");
        } catch(Exception e){
            log.error("批量删除后期维护信息失败");
            responseResult = ResponseResult.failure("批量删除后期维护信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 检查维护信息
     * @methodName : checkMaintainInfo
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : 张永辉
     */
    @GetMapping("/checkMaintainInfo")
    public ResponseResult checkMaintainInfo(){
        ResponseResult responseResult = null;
        try {
            List<String> list = maintainInfoService.checkMaintainInfo();
            log.info("检查维护信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"检查维护信息成功");
        } catch(Exception e){
            log.error("检查维护信息失败");
            responseResult = ResponseResult.failure("检查维护信息失败");
        }
        return responseResult;
    }

}
