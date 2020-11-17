package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.EnclosureInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface EnclosureInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(EnclosureInfo record);

    int insertSelective(EnclosureInfo record);

    EnclosureInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(EnclosureInfo record);

    int updateByPrimaryKey(EnclosureInfo record);
}