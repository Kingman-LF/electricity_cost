package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.DictionaryInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictionaryInfo record);

    int insertSelective(DictionaryInfo record);

    DictionaryInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DictionaryInfo record);

    int updateByPrimaryKey(DictionaryInfo record);
}