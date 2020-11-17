package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.SubContractInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SubContractInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SubContractInfo record);

    int insertSelective(SubContractInfo record);

    SubContractInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SubContractInfo record);

    int updateByPrimaryKey(SubContractInfo record);
}