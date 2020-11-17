package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.RoleInfo;
import com.xwkj.cost.service.RoleInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RoleInfoController {

    @Autowired
    RoleInfoService roleInfoService;

    /**
     * @Description : 获取角色列表
     * @methodName : getRoleInfoList
     * @param pageUtil : 
     * @param roleInfo : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @GetMapping("/getRoleInfoList")
    public ResponseResult getRoleInfoList(PageUtil pageUtil, RoleInfo roleInfo){
        ResponseResult responseResult = null;
        try {
            PageInfo<RoleInfo> pageInfo = roleInfoService.getRoleInfoList(pageUtil, roleInfo);
            log.info("获取角色列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),pageInfo,"获取角色列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取角色列表失败");
            responseResult = ResponseResult.failure("获取角色列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加角色信息
     * @methodName : addRoleInfo
     * @param roleInfo : 
     * @param permIds : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PostMapping("/addRoleInfo")
    public ResponseResult addRoleInfo(RoleInfo roleInfo,String permIds) {
        ResponseResult responseResult = null;
        try {
            Boolean b = roleInfoService.addRoleInfo(roleInfo, permIds);
            if (b){
                log.info("添加角色信息成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加角色信息成功");
            }else {
                log.error("添加角色信息失败，角色名称重复");
                responseResult = ResponseResult.failure("添加角色信息失败，角色名称重复");
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("添加角色信息失败");
            responseResult = ResponseResult.failure("添加角色信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改角色信息
     * @methodName : updateRoleInfo
     * @param roleInfo : 
     * @param permIds : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PutMapping("/updateRoleInfo")
    public ResponseResult updateRoleInfo(RoleInfo roleInfo,String permIds) {
        ResponseResult responseResult = null;
        try {
            roleInfoService.updateRoleInfo(roleInfo,permIds);
            log.info("修改角色信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改角色信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改角色信息失败");
            responseResult = ResponseResult.failure("修改角色信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除角色信息
     * @methodName : deleteRoleInfo
     * @param id : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @DeleteMapping("/deleteRoleInfo/{id}")
    public ResponseResult deleteRoleInfo(@PathVariable Long id) {
        ResponseResult responseResult = null;
        try {
            roleInfoService.deleteRoleInfo(id);
            log.info("删除角色信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除角色信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除角色信息失败");
            responseResult = ResponseResult.failure("删除角色信息失败");
        }
        return responseResult;
    }

    @GetMapping("/getRoleList")
    public ResponseResult getRoleList(){
        ResponseResult responseResult = null;
        try {
            List<RoleInfo> list = roleInfoService.getRoleList();
            log.info("获取角色列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"获取角色列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取角色列表失败");
            responseResult = ResponseResult.failure("获取角色列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 根据角色主键获取权限主键列表
     * @methodName : getPermissionInfoListByRoleId
     * @param roleId :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getPermissionInfoListByRoleId")
    public ResponseResult getPermissionInfoListByRoleId(Long roleId) {
        ResponseResult responseResult = null;
        try {
            List<Long> list = roleInfoService.getPermissionInfoListByRoleId(roleId);
            log.info("根据角色主键获取权限主键列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"根据角色主键获取权限主键列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("根据角色主键获取权限主键列表失败");
            responseResult = ResponseResult.failure("根据角色主键获取权限主键列表失败");
        }
        return responseResult;
    }
}
