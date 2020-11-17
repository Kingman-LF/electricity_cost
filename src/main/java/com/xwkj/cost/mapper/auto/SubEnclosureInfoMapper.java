package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.SubEnclosureInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SubEnclosureInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubEnclosureInfo record);

    int insertSelective(SubEnclosureInfo record);

    SubEnclosureInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubEnclosureInfo record);

    int updateByPrimaryKey(SubEnclosureInfo record);
}