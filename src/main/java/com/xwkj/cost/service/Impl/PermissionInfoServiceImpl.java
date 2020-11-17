package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.PermissionInfoMapperManual;
import com.xwkj.cost.model.PermissionInfo;
import com.xwkj.cost.service.PermissionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionInfoServiceImpl implements PermissionInfoService {

    @Autowired
    PermissionInfoMapperManual permissionInfoMapperManual;

    /**
     * @Description : 获取权限列表
     * @methodName : getPermissionInfoList
     * @return : java.util.List<com.xwkj.cost.model.PermissionInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public List<PermissionInfo> getPermissionInfoList() {
        return permissionInfoMapperManual.getPermissionInfoList();
    }

    /**
     * @Description : 根据角色主键获取权限列表
     * @methodName : getPermissionsInfoListByRoleId
     * @param roleId :
     * @return : java.util.List<com.xwkj.cost.model.PermissionInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public List<PermissionInfo> getPermissionsInfoListByRoleId(Long roleId) {
        return permissionInfoMapperManual.getPermissionsInfoListByRoleId(roleId);
    }
}
