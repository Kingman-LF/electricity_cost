package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.ApplyInvoiceEnclosureInfoMapperManual;
import com.xwkj.cost.mapper.auto.ApplyInvoiceEnclosureInfoMapper;
import com.xwkj.cost.mapper.auto.ApplyInvoiceInfoMapper;
import com.xwkj.cost.model.ApplyInvoiceEnclosureInfo;
import com.xwkj.cost.service.ApplyInvoiceEnclosureInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2020-01-11 11:50
 * @Version 1.0
 */
@Service
public class ApplyInvoiceEnclosureInfoServiceImpl implements ApplyInvoiceEnclosureInfoService {

	@Autowired(required = false)
	ApplyInvoiceEnclosureInfoMapperManual applyInvoiceEnclosureInfoMapperManual;

	@Override
	public List<ApplyInvoiceEnclosureInfo> getApplyInvoiceEnclosureInfoById(Long id) {
		return applyInvoiceEnclosureInfoMapperManual.selectApplyInvoiceEnclosureInfoById(id);
	}
}
