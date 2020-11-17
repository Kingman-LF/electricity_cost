package com.xwkj.cost.mapper;

import com.xwkj.cost.model.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoMapperManual {

    /**
     * @Description : 根据用户名和密码获取用户信息
     * @methodName : getUserInfoByUserNameAndPassWord
     * @param userInfo : 
     * @return : com.xwkj.cost.model.UserInfo
     * @exception : 
     * @author : zyh
     */
    UserInfo getUserInfoByUserNameAndPassWord(UserInfo userInfo);

    /**
     * @Description : 获取用户列表
     * @methodName : getUserInfoList
     * @param userInfo : 
     * @return : java.util.List<com.xwkj.cost.model.UserInfo>
     * @exception : 
     * @author : zyh
     */
    List<UserInfo> getUserInfoList(UserInfo userInfo);

    /**
     * @Description : 插入用户和角色关系信息
     * @methodName : insertUserInfoAndRoleInfoRelated
     * @param userId :
     * @param roleId :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void insertUserInfoAndRoleInfoRelated(@Param("userId") Long userId , @Param("roleId") Long roleId);

    /**
     * @Description : 根据用户主键删除所有用户和角色关系信息
     * @methodName : deleteUserInfoAndRoleInfoRelatedByUserId
     * @param userId :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void deleteUserInfoAndRoleInfoRelatedByUserId(Long userId);

    /**
     * @Description : 根据用户名获取用户信息
     * @methodName : getUserInfoByUserName
     * @param userName :
     * @return : com.xwkj.cost.model.UserInfo
     * @exception :
     * @author : zyh
     */
    UserInfo getUserInfoByUserName(@Param("userName") String userName);


    /**
     * @Description : 根据用户名和密码获取用户信息
     * @methodName : getUserInfoByUserNameAndPassword
     * @param userName : 
     * @param password : 
     * @return : com.xwkj.cost.model.UserInfo
     * @exception : 
     * @author : zyh
     */
    UserInfo getUserInfoByUserNameAndPassword(@Param("userName") String userName,@Param("password") String password);
}