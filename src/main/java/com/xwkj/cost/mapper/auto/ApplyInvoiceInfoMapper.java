package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ApplyInvoiceInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyInvoiceInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApplyInvoiceInfo record);

    int insertSelective(ApplyInvoiceInfo record);

    ApplyInvoiceInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApplyInvoiceInfo record);

    int updateByPrimaryKey(ApplyInvoiceInfo record);
}