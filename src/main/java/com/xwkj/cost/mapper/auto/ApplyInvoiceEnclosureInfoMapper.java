package com.xwkj.cost.mapper.auto;

import com.xwkj.cost.model.ApplyInvoiceEnclosureInfo;

public interface ApplyInvoiceEnclosureInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ApplyInvoiceEnclosureInfo record);

    int insertSelective(ApplyInvoiceEnclosureInfo record);

    ApplyInvoiceEnclosureInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ApplyInvoiceEnclosureInfo record);

    int updateByPrimaryKey(ApplyInvoiceEnclosureInfo record);
}