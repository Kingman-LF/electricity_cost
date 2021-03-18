package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.RecordInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(RecordInfo record);

    int insertSelective(RecordInfo record);

    RecordInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RecordInfo record);

    int updateByPrimaryKey(RecordInfo record);
}