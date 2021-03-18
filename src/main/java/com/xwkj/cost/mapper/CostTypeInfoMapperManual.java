package com.xwkj.cost.mapper;

import com.xwkj.cost.model.CostTypeInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CostTypeInfoMapperManual {

    /**
     * @Description : 获取成本分类列表
     * @methodName : getCostTypeInfoList
     * @return : java.util.List<com.xwkj.cost.model.CostTypeInfo>
     * @exception :
     * @author : zyh
     */
    List<CostTypeInfo> getCostTypeInfoList(String typeName);

    /**
     * @Description : 根据主键组成的字符串获取成本类型列表
     * @methodName : getCostTypeInfoListByIds
     * @param ids :
     * @return : java.util.List<com.xwkj.cost.model.CostTypeInfo>
     * @exception :
     * @author : zyh
     */
    List<CostTypeInfo> getCostTypeInfoListByIds(@Param("ids") String ids, @Param("name") String name);

}