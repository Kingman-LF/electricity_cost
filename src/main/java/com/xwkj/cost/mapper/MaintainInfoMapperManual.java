package com.xwkj.cost.mapper;

import com.xwkj.cost.model.MaintainInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintainInfoMapperManual {

    /**
     * @Description : 获取后期维护信息列表
     * @methodName : getMaintainInfoList
     * @param maintainInfo :
     * @return : java.util.List<com.xwkj.cost.model.MaintainInfo>
     * @exception :
     * @author : 张永辉
     */
    List<MaintainInfo> getMaintainInfoList(MaintainInfo maintainInfo);

    /**
     * @Description : 根据条件获取后期维护信息列表
     * @methodName : getMaintainInfoListByCondition
     * @param maintainInfo :
     * @return : java.util.List<com.xwkj.cost.model.MaintainInfo>
     * @exception :
     * @author : 张永辉
     */
    List<MaintainInfo> getMaintainInfoListByCondition(MaintainInfo maintainInfo);


}