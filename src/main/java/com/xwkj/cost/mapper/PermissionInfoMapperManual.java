package com.xwkj.cost.mapper;

import com.xwkj.cost.model.PermissionInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionInfoMapperManual {

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