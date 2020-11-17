package com.xwkj.cost.service;

import com.xwkj.cost.model.PermissionInfo;

import java.util.List;

public interface PermissionInfoService {

    /**
     * @Description : 获取权限列表
     * @methodName : getPermissionInfoList
     * @return : java.util.List<com.xwkj.cost.model.PermissionInfo>
     * @exception :
     * @author : zyh
     */
    List<PermissionInfo> getPermissionInfoList();

    /**
     * @Description : 根据角色主键获取权限列表
     * @methodName : getPermissionsInfoListByRoleId
     * @param roleId :
     * @return : java.util.List<com.xwkj.cost.model.PermissionInfo>
     * @exception :
     * @author : zyh
     */
    List<PermissionInfo> getPermissionsInfoListByRoleId(Long roleId);

}
