package com.xwkj.cost.service;

import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.ApplyInvoiceVo;

import java.util.List;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2020-01-11 11:51
 * @Version 1.0
 */
public interface ApplyInvoiceInfoService {

	Boolean addApplyInvoiceInfo(ApplyInvoiceVo applyInvoiceVo);

    List<ApplyInvoiceInfo> getApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo);

	PageInfo<ApplyInvoiceInfo> getApplyInvoiceInfoList(PageUtil pageUtil, Long id);

	Boolean deleteApplyInvoiceInfo(Long id);

	Boolean editApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo);
}
