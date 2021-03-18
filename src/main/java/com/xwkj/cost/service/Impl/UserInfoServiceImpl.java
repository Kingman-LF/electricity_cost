package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.mapper.RoleInfoMapperManual;
import com.xwkj.cost.mapper.UserInfoMapperManual;
import com.xwkj.cost.mapper.auto.UserInfoMapper;
import com.xwkj.cost.model.RoleInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.UserInfoService;
import com.xwkj.cost.util.MD5Util;
import com.xwkj.cost.util.PageUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    UserInfoMapperManual userInfoMapperManual;
    @Autowired
    RoleInfoMapperManual roleInfoMapperManual;
    /**
     * @Description : 获取用户列表
     * @methodName : getUserInfoList
     * @param pageUtil :
     * @param userInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.UserInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public PageInfo<UserInfo> getUserInfoList(PageUtil pageUtil, UserInfo userInfo) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<UserInfo> list = userInfoMapperManual.getUserInfoList(userInfo);
        return new PageInfo<>(list);
    }

    /**
     * @Description : 添加用户信息
     * @methodName : addUserInfo
     * @param userInfo :
     * @param roleIds :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    @Transactional
    @Override
    public Boolean addUserInfo(UserInfo userInfo, String[] roleIds) {

        UserInfo userInfoByUserName = userInfoMapperManual.getUserInfoByUserName(userInfo.getUserName());
        if (userInfoByUserName != null){
            return false;
        }
        userInfo.setPassword(MD5Util.getMD5(userInfo.getPassword())).setCreateTime(new Date()).setIsEnable(1).setCreateUser(LoginUserInfoManager.getUserInfo().getUserName());
        userInfoMapper.insertSelective(userInfo);
        //为了解决用户无角色的情况，从第二个开始遍历
        for (int i = 1; i < roleIds.length; i++) {
            userInfoMapperManual.insertUserInfoAndRoleInfoRelated(userInfo.getId(),Long.parseLong(roleIds[i]));
        }
        return true;
    }

    /**
     * @Description : 修改用户信息
     * @methodName : updateUserInfo
     * @param userInfo :
     * @param roleIds :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void updateUserInfo(UserInfo userInfo, String[] roleIds) {
        //根据用户主键删除所有用户和角色关系信息
        userInfoMapperManual.deleteUserInfoAndRoleInfoRelatedByUserId(userInfo.getId());
        //修改用户信息
        if (userInfo.getPassword() != null && !"".equals(userInfo.getPassword())){
            userInfo.setPassword(MD5Util.getMD5(userInfo.getPassword()));
        }
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        //插入新的用户和角色关系信息
        //为了解决用户无角色的情况，从第二个开始遍历
        for (int i = 1; i < roleIds.length; i++) {
            userInfoMapperManual.insertUserInfoAndRoleInfoRelated(userInfo.getId(),Long.parseLong(roleIds[i]));
        }
    }

    /**
     * @Description : 删除用户信息
     * @methodName : deleteUserInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteUserInfo(Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id).setIsEnable(0);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    /**
     * @Description  ：根据用户主键获取用户信息
     * @methodName   : getUserInfo
     * @param        : * @param id :
     * @return       : com.xwkj.cost.model.UserInfo
     * @exception    :
     * @author       : 张童
     */
    @Override
    public List<Object> getUserInfo(Long id) {
        List<Object> list = new ArrayList<>();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(id);
        List<RoleInfo> roleInfoList = roleInfoMapperManual.getRoleListByUserId(id);
        list.add(userInfo);
        list.add(roleInfoList);
        return list;
    }

    /**
     * @Description : 检查是否存在用户
     * @methodName : checkUserInfo
     * @param userName :
     * @param password :
     * @return : com.xwkj.cost.model.UserInfo
     * @exception :
     * @author : zyh
     */
    @Override
    public UserInfo checkUserInfo(String userName, String password) {
        return userInfoMapperManual.getUserInfoByUserNameAndPassword(userName,password);
    }

    @Override
    public void editUserPwd(String password) {
        UserInfo userInfo = LoginUserInfoManager.getUserInfo();
        userInfo.setPassword(MD5Util.getMD5(password));
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
    }

    /**
     * @Description  ：重置密码
     * @methodName   : resetPassword
     * @param        : * @param id :
     * @return       : void
     * @exception    :
     * @author       : 张童
     */

    @Override
    public void resetPassword(Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(MD5Util.getMD5("123456")).setId(id);
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
