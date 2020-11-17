package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ApplyInvoiceInfo;

import java.util.List;

public interface ApplyInvoiceInfoMapperManual {

    int insert(ApplyInvoiceInfo record);

    List<ApplyInvoiceInfo> selectByContractId(Long id);

    List<ApplyInvoiceInfo> getApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo);
}