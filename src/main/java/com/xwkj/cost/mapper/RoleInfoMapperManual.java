package com.xwkj.cost.mapper;

import com.xwkj.cost.model.RoleInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleInfoMapperManual {
    /**
     * @Description : 获取角色列表
     * @methodName : getRoleInfoList
     * @param roleInfo :
     * @return : java.util.List<com.xwkj.cost.model.RoleInfo>
     * @exception :
     * @author : zyh
     */
    List<RoleInfo> getRoleInfoList(RoleInfo roleInfo);

    /**
     * @Description : 根据角色名称获取角色信息
     * @methodName : getRoleInfoByRoleName
     * @param roleName :
     * @return : com.xwkj.cost.model.RoleInfo
     * @exception :
     * @author : zyh
     */
    RoleInfo getRoleInfoByRoleName(@Param("roleName") String roleName);

    /**
     * @Description : 插入角色与权限关系信息
     * @methodName : insertRoleInfoAndPermissionInfoRelated
     * @param roleId :
     * @param permId :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void insertRoleInfoAndPermissionInfoRelated(@Param("roleId") Long roleId, @Param("permId") Long permId);

    /**
     * @Description : 根据角色主键删除所有角色与权限关系信息
     * @methodName : deleteRoleInfoAndPermissionInfoRelatedByRoleId
     * @param roleId : 
     * @return : void
     * @exception : 
     * @author : zyh
     */
    void deleteRoleInfoAndPermissionInfoRelatedByRoleId(Long roleId);

    /**
     * @Description  ：
     * @methodName   : getRoleList
     * @param        :
     * @return       : java.util.List<com.xwkj.cost.model.RoleInfo>
     * @exception    :
     * @author       : 张童
     */

    List<RoleInfo> getRoleList();
    /**
     * @Description  ：
     * @methodName   : getRoleListByUserId
     * @param        : * @param id :
     * @return       : java.util.List<com.xwkj.cost.model.RoleInfo>
     * @exception    :
     * @author       : 张童
     */

    List<RoleInfo> getRoleListByUserId(Long id);

    /**
     * @Description : 根据用户主键获取用户所属的角色列表
     * @methodName : getRoleInfoByUserInfoId
     * @param userId :
     * @return : java.util.List<com.xwkj.cost.model.RoleInfo>
     * @exception :
     * @author : zyh
     */
    List<RoleInfo> getRoleInfoByUserInfoId(Long userId);

    /**
     * @Description : 根据角色主键获取权限主键列表
     * @methodName : getPermissionInfoListByRoleId
     * @param roleId :
     * @return : java.util.List<java.lang.Long>
     * @exception :
     * @author : zyh
     */
    List<Long> getPermissionInfoListByRoleId(Long roleId);



}