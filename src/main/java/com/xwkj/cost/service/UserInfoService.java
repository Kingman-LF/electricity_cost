package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

public interface UserInfoService {

    /**
     * @Description : 获取用户列表
     * @methodName : getUserInfoList
     * @param pageUtil :
     * @param userInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.UserInfo>
     * @exception : 
     * @author : zyh
     */
    PageInfo<UserInfo> getUserInfoList(PageUtil pageUtil, UserInfo userInfo);

    /**
     * @Description : 添加用户信息
     * @methodName : addUserInfo
     * @param userInfo :
     * @param roleIds :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    Boolean addUserInfo(UserInfo userInfo,String[] roleIds);

    /**
     * @Description : 修改用户信息
     * @methodName : updateUserInfo
     * @param userInfo :
     * @param roleIds :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void updateUserInfo(UserInfo userInfo,String[] roleIds);

    /**
     * @Description : 删除用户信息
     * @methodName : deleteUserInfo
     * @param id : 
     * @return : void
     * @exception : 
     * @author : zyh
     */
    void deleteUserInfo(Long id);

    /**
     * @Description  ：根据用户主键获取用户信息
     * @methodName   : getUserInfo
     * @param        : * @param id :
     * @return       : com.xwkj.cost.model.UserInfo
     * @exception    :
     * @author       : 张童
     */
    List<Object> getUserInfo(Long id);

    /**
     * @Description  ：重置密码
     * @methodName   : resetPassword
     * @param        : * @param id : 
     * @return       : void
     * @exception    : 
     * @author       : 张童
     */
    
    void resetPassword(Long id);
    /**
     * @Description : 检查是否存在用户
     * @methodName : checkUserInfo
     * @param userName :
     * @param password :
     * @return : com.xwkj.cost.model.UserInfo
     * @exception :
     * @author : zyh
     */
    UserInfo checkUserInfo(String userName,String password);

    /**
     * @Description  ：修改密码
     * @methodName   : editUserPwd
     * @param        : * @param password :
     * @return       : void
     * @exception    :
     * @author       : 张童
     */

    void editUserPwd(String password);
}
