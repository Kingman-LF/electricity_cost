package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.MaintainInfo;
import com.xwkj.cost.util.PageUtil;

import java.util.List;

/**
 * @program: electricity_cost
 * @description: 后期维护服务层
 * @author: 张永辉
 * @create: 2020-06-30 09:46
 **/
public interface MaintainInfoService {

    /**
     * @Description : 获取后期维护列表
     * @methodName : getMaintainInfoList
     * @param pageUtil :
     * @param maintainInfo :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.MaintainInfo>
     * @exception :
     * @author : 张永辉
     */
    PageInfo<MaintainInfo> getMaintainInfoList(PageUtil pageUtil, MaintainInfo maintainInfo);

    /**
     * @Description : 添加后期维护信息
     * @methodName : addMaintainInfo
     * @param maintainInfo :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void addMaintainInfo(MaintainInfo maintainInfo);

    /**
     * @Description : 修改后期维护信息
     * @methodName : updateMaintainInfo
     * @param maintainInfo :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void updateMaintainInfo(MaintainInfo maintainInfo);

    /**
     * @Description : 删除后期维护信息
     * @methodName : deleteMaintainInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void deleteMaintainInfo(Long id);

    /**
     * @Description : 批量删除后期维护信息
     * @methodName : batchDeleteMaintainInfo
     * @param ids :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void batchDeleteMaintainInfo(String ids);

    /**
     * @Description : 检查维护信息并在系统登录后提示未处理的超期或将要在30天内超期的维护信息
     * @methodName : checkMaintainInfo
     * @return : java.util.List<java.lang.String>
     * @exception :
     * @author : 张永辉
     */
    List<String> checkMaintainInfo();

}
