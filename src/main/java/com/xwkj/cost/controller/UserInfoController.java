package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.RoleInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.RoleInfoService;
import com.xwkj.cost.service.UserInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RoleInfoService roleInfoService;
    /**
     * @Description : 获取用户信息列表
     * @methodName : getUserInfoList
     * @param pageUtil :
     * @param userInfo :
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception :
     * @author : zyh
     */
    @GetMapping("/getUserInfoList")
    public ResponseResult getUserInfoList(PageUtil pageUtil, UserInfo userInfo) {
        ResponseResult responseResult = null;
        try {
            PageInfo<UserInfo> pageInfo = userInfoService.getUserInfoList(pageUtil, userInfo);
            log.info("获取用户信息列表成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),pageInfo,"获取用户信息列表成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("获取用户信息列表失败");
            responseResult = ResponseResult.failure("获取用户信息列表失败");
        }
        return responseResult;
    }

    /**
     * @Description : 添加用户信息
     * @methodName : addUserInfo
     * @param userInfo : 
     * @param roleIds : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PostMapping("/addUserInfo")
    public ResponseResult addUserInfo(UserInfo userInfo ,@RequestParam("roleIds") String[] roleIds){
        ResponseResult responseResult = null;
        try {
            Boolean b = userInfoService.addUserInfo(userInfo, roleIds);
            if (b){
                log.info("添加用户信息成功");
                responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加用户信息成功");
            }else {
                log.error("添加用户信息失败,用户名重复");
                responseResult = ResponseResult.failure("添加用户信息失败,用户名重复");
            }
        } catch(Exception e){
            e.printStackTrace();
            log.error("添加用户信息失败");
            responseResult = ResponseResult.failure("添加用户信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 修改用户信息
     * @methodName : updateUserInfo
     * @param userInfo : 
     * @param roleIds : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @PutMapping("/updateUserInfo")
    public ResponseResult updateUserInfo(UserInfo userInfo, @RequestParam("roleIds") String[] roleIds) {
        ResponseResult responseResult = null;
        try {
            userInfoService.updateUserInfo(userInfo,roleIds);
            log.info("修改用户信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改用户信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改用户信息失败");
            responseResult = ResponseResult.failure("修改用户信息失败");
        }
        return responseResult;
    }

    /**
     * @Description : 删除用户信息
     * @methodName : deleteUserInfo
     * @param id : 
     * @return : com.xwkj.cost.common.ResponseResult
     * @exception : 
     * @author : zyh
     */
    @DeleteMapping("/deleteUserInfo")
    public ResponseResult deleteUserInfo(Long id) {
        ResponseResult responseResult = null;
        try {
            userInfoService.deleteUserInfo(id);
            log.info("删除用户信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除用户信息成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("删除用户信息失败");
            responseResult = ResponseResult.failure("删除用户信息失败");
        }
        return responseResult;
    }

    /**
     * @Description  ：根据用户主键获取用户信息
     * @methodName   : getUserInfoById
     * @param        : * @param id : 
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    : 
     * @author       : 张童
     */
    @GetMapping("/getUserInfoById")
    public ResponseResult getUserInfoById(Long id){
        ResponseResult responseResult = null;
        try {
            List<Object> list = userInfoService.getUserInfo(id);
            log.info("根据用户主键获取用户信息成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"根据用户主键获取用户信息成功");
        }catch (Exception e){
            e.printStackTrace();
            log.error("根据用户主键获取用户信息失败");
            responseResult = ResponseResult.failure("根据用户主键获取用户信息失败");
        }
        return responseResult;
    }
    /**
     * 去往添加用户页面
     * @return
     */
    @GetMapping("/user-add")
    public ModelAndView toAddUserInfo(Map<String ,Object> map){
        List<RoleInfo> roleInfoList = roleInfoService.getRoleList();
        map.put("roleInfoList",roleInfoList);
        return new ModelAndView("user/user-add");
    }

    /**
     * 去往修改用户页面
     * @return
     */
    @GetMapping("/user-edit")
    public ModelAndView toUpdateUserInfo(Map<String ,Object> map){
        List<RoleInfo> roleInfoList = roleInfoService.getRoleList();
        map.put("roleInfoList",roleInfoList);
        return new ModelAndView("user/user-edit");
    }


    /**
     * @Description  ：重置密码
     * @methodName   : resetPassword
     * @param        : * @param id :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */

    @PostMapping("/resetPassword")
    public ResponseResult resetPassword(Long id) {
        ResponseResult responseResult = null;
        try {
            userInfoService.resetPassword(id);
            log.info("重置密码成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"重置密码成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("重置密码失败");
            responseResult = ResponseResult.failure("重置密码失败");
        }
        return responseResult;
    }

    /**
     * @Description  ：修改密码
     * @methodName   : editUserPwd
     * @param        : * @param password :
     * @return       : com.xwkj.cost.common.ResponseResult
     * @exception    :
     * @author       : 张童
     */

    @PostMapping("/editUserPwd")
    public ResponseResult editUserPwd(String password) {
        ResponseResult responseResult = null;
        try {
            userInfoService.editUserPwd(password);
            log.info("修改密码成功");
            responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改密码成功");
        } catch(Exception e){
            e.printStackTrace();
            log.error("修改密码失败");
            responseResult = ResponseResult.failure("修改密码失败");
        }
        return responseResult;
    }
}
