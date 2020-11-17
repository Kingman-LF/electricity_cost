package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.PermissionInfo;
import com.xwkj.cost.service.PermissionInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class PermissionInfoController {

    @Autowired
    PermissionInfoService permissionInfoService;

    /**
     * @Description : 获取权限列表
     * @methodName : getPermissionInfoList
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getPermissionInfoList")
    public ResponseResult getPermissionInfoList(){
        ResponseResult responseResult = null;
        try {
            List<PermissionInfo> list = permissionInfoService.getPermissionInfoList();
            log.info("获取权限列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取权限列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取权限列表失败");
            responseResult = ResponseResult.failure("获取权限列表成功");
        }
        return responseResult;
    }

}
