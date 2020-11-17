package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.mapper.RoleInfoMapperManual;
import com.xwkj.cost.mapper.auto.RoleInfoMapper;
import com.xwkj.cost.model.RoleInfo;
import com.xwkj.cost.service.RoleInfoService;
import com.xwkj.cost.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    RoleInfoMapper roleInfoMapper;
    @Autowired
    RoleInfoMapperManual roleInfoMapperManual;

    /**
     * @Description : 获取角色列表
     * @methodName : getRoleInfoList
     * @param pageUtil :
     * @param roleInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.RoleInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public PageInfo<RoleInfo> getRoleInfoList(PageUtil pageUtil, RoleInfo roleInfo) {
        PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
        List<RoleInfo> list = roleInfoMapperManual.getRoleInfoList(roleInfo);
        return new PageInfo<>(list);
    }

    /**
     * @Description : 添加角色信息
     * @methodName : addRoleInfo
     * @param roleInfo :
     * @param permIds :
     * @return : java.lang.Boolean
     * @exception :
     * @author : zyh
     */
    @Override
    public Boolean addRoleInfo(RoleInfo roleInfo,String permIds) {
        RoleInfo roleInfoByRoleName = roleInfoMapperManual.getRoleInfoByRoleName(roleInfo.getRoleName());
        if (roleInfoByRoleName != null){
            return false;
        }
        roleInfo.setCreateTime(new Date()).setCreator(LoginUserInfoManager.getUserInfo().getId());
        roleInfoMapper.insertSelective(roleInfo);
        //插入角色与权限关系信息
        String[] split = permIds.split(",");
        for (int i = 0; i < split.length; i++) {
            roleInfoMapperManual.insertRoleInfoAndPermissionInfoRelated(roleInfo.getId(),Long.parseLong(split[i]));
        }
        return true;
    }

    /**
     * @Description : 修改角色信息
     * @methodName : updateRoleInfo
     * @param roleInfo :
     * @param permIds :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Transactional
    @Override
    public void updateRoleInfo(RoleInfo roleInfo,String permIds) {
        //删除所有角色与权限关系信息
        roleInfoMapperManual.deleteRoleInfoAndPermissionInfoRelatedByRoleId(roleInfo.getId());
        //修改角色信息
        roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
        String[] split = permIds.split(",");
        for (int i = 0; i < split.length; i++) {
            roleInfoMapperManual.insertRoleInfoAndPermissionInfoRelated(roleInfo.getId(),Long.parseLong(split[i]));
        }
    }

    /**
     * @Description : 删除角色信息
     * @methodName : deleteRoleInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : zyh
     */
    @Override
    public void deleteRoleInfo(Long id) {
        RoleInfo roleInfo = new RoleInfo();
        roleInfo.setId(id).setIsEnable(0);
        roleInfoMapper.updateByPrimaryKeySelective(roleInfo);
    }

    /**
     * @Description : 根据用户主键获取用户所属的角色列表
     * @methodName : getRoleInfoByUserInfoId
     * @param userId :
     * @return : java.util.List<com.xwkj.cost.model.RoleInfo>
     * @exception :
     * @author : zyh
     */
    @Override
    public List<RoleInfo> getRoleInfoByUserInfoId(Long userId) {
        return roleInfoMapperManual.getRoleInfoByUserInfoId(userId);
    }

    /**
     * @Description : 根据角色主键获取权限主键列表
     * @methodName : getPermissionInfoListByRoleId
     * @param roleId :
     * @return : java.util.List<java.lang.Long>
     * @exception :
     * @author : zyh
     */
    @Override
    public List<Long> getPermissionInfoListByRoleId(Long roleId) {
        return roleInfoMapperManual.getPermissionInfoListByRoleId(roleId);
    }

    /**
     * @Description  ：无分页获取角色列表
     * @methodName   : getRoleList
     * @param        : * @param roleInfo :
     * @return       : java.util.List<com.xwkj.cost.model.RoleInfo>
     * @exception    :
     * @author       : 张童
     */

    public List<RoleInfo> getRoleList() {
        List<RoleInfo> list = roleInfoMapperManual.getRoleList();
        return list;
    }
}
