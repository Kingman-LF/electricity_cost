package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.MaintainInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintainInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MaintainInfo record);

    int insertSelective(MaintainInfo record);

    MaintainInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MaintainInfo record);

    int updateByPrimaryKey(MaintainInfo record);
}