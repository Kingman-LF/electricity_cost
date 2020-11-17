package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.RoleInfo;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

public interface RoleInfoService {

    /**
     * @Description : 获取角色列表
     * @methodName : getRoleInfoList
     * @param pageUtil :
     * @param roleInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.RoleInfo>
     * @exception : 
     * @author : zyh
     */
    PageInfo<RoleInfo> getRoleInfoList(PageUtil pageUtil, RoleInfo roleInfo);

    /**
     * @Description : 添加角色信息
     * @methodName : addRoleInfo
     * @param roleInfo :
     * @param permIds :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    Boolean addRoleInfo(RoleInfo roleInfo,String permIds);

    /**
     * @Description : 修改角色信息
     * @methodName : updateRoleInfo
     * @param roleInfo : 
     * @param permIds :
     * @return : void
     * @exception : 
     * @author : zyh
     */
    void updateRoleInfo(RoleInfo roleInfo,String permIds);

    /**
     * @Description : 删除角色信息
     * @methodName : deleteRoleInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    void deleteRoleInfo(Long id);
    /**
     * @Description  ：无分页获取角色列表
     * @methodName   : getRoleList
     * @param        : * @param roleInfo :
     * @return       : java.util.List<com.xwkj.cost.model.RoleInfo>
     * @exception    :
     * @author       : 张童
     */

    List<RoleInfo> getRoleList();
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
