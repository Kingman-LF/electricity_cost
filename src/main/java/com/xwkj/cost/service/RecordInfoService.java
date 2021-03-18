package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.RecordInfo;
import com.xwkj.cost.util.PageUtil;

/**
 * @program: electricity_cost
 * @description:
 * @author: 张永辉
 * @create: 2021-03-16 17:07
 **/
public interface RecordInfoService {

    /**
     * @Description : 添加记录
     * @methodName : addRecordInfo
     * @param recordInfo :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void addRecordInfo(RecordInfo recordInfo);

    /**
     * @Description : 修改记录
     * @methodName : updateRecordInfo
     * @param recordInfo :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void updateRecordInfo(RecordInfo recordInfo);

    /**
     * @Description : 删除记录
     * @methodName : deleteRecordInfo
     * @param id :
     * @return : void
     * @exception :
     * @author : 张永辉
     */
    void deleteRecordInfo(Long id);

    /**
     * @Description : 获取记录列表
     * @methodName : getRecordInfoList
     * @param recordInfo :
     * @param pageUtil :
     * @return : com.github.pagehelper.PageInfo<com.xwkj.cost.model.RecordInfo>
     * @exception :
     * @author : 张永辉
     */
    PageInfo<RecordInfo> getRecordInfoList(RecordInfo recordInfo, PageUtil pageUtil);

}
