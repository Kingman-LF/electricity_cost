package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.InvoiceInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(InvoiceInfo record);

    int insertSelective(InvoiceInfo record);

    InvoiceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(InvoiceInfo record);

    int updateByPrimaryKey(InvoiceInfo record);
}