package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.InvoiceInfoMapperManual;
import com.xwkj.cost.mapper.auto.InvoiceInfoMapper;
import com.xwkj.cost.model.InvoiceInfo;
import com.xwkj.cost.service.InvoiceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description:TODO 合同发票业务层实现
 * @Author wanglei
 * @Create 2019-12-11 10:29
 * @Version 1.0
 */
@Service
public class InvoiceInfoServiceImpl implements InvoiceInfoService {

	@Autowired
	InvoiceInfoMapper invoiceInfoMapper;

	@Autowired
	InvoiceInfoMapperManual invoiceInfoMapperManual;
	/***
	 * @description: 添加合同发票信息
	 * @methodName: addInvoiceInfo
	 * @param: [invoiceInfo]
	 * @return: void
	 * @exception:
	 * @date:  2019-12-11 10:43
	 * @author: wanglei
	 */
	@Override
	public void addInvoiceInfo(InvoiceInfo invoiceInfo) {
		invoiceInfoMapper.insertSelective(invoiceInfo);
	}

	/**
	 * @description: 根据合同信息查询发票接口实现
	 * @methodName: getInvoiceInfoByContractId
	 * @param: [id]
	 * @return: com.xwkj.cost.model.InvoiceInfo
	 * @exception:
	 * @date:  2019-12-12 9:08
	 * @author: wanglei
	 */
	@Override
	public InvoiceInfo getInvoiceInfoByContractId(Long id) {
		return invoiceInfoMapperManual.selectInvoiceInfoByContractId(id);
	}

	/**
	 * @description: 修改合同发票信息接口
	 * @methodName: editInvoiceInfo
	 * @param: [invoiceInfo]
	 * @return: void
	 * @exception:
	 * @date:  2020-01-03 9:06
	 * @author: wanglei
	 */
	@Override
	public void editInvoiceInfo(InvoiceInfo invoiceInfo) {
		if (invoiceInfo.getId() == null){
			invoiceInfoMapper.insertSelective(invoiceInfo);
		}else {
			invoiceInfoMapper.updateByPrimaryKeySelective(invoiceInfo);
		}

	}
}
