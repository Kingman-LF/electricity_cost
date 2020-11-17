package com.xwkj.cost.service;

import com.xwkj.cost.model.InvoiceInfo;

/**
 * @Description:TODO 合同发票信息业务层接口
 * @Author wanglei
 * @Create 2019-12-11 10:29
 * @Version 1.0
 */
public interface InvoiceInfoService {
	/***
	 * @description: 添加合同发票信息
	 * @methodName: addInvoiceInfo
	 * @param: [invoiceInfo]
	 * @return: void
	 * @exception:
	 * @date:  2019-12-11 10:43
	 * @author: wanglei
	 */
	void addInvoiceInfo(InvoiceInfo invoiceInfo);

	/**
	 * @description: 根据合同信息查询发票接口
	 * @methodName: getInvoiceInfoByContractId
	 * @param: [id]
	 * @return: com.xwkj.cost.model.InvoiceInfo
	 * @exception:
	 * @date:  2019-12-12 9:08
	 * @author: wanglei
	 */
	InvoiceInfo getInvoiceInfoByContractId(Long id);

	/**
	 * @description: 修改合同发票信息接口
	 * @methodName: editInvoiceInfo
	 * @param: [invoiceInfo]
	 * @return: void
	 * @exception: 
	 * @date:  2020-01-03 9:06  
	 * @author: wanglei
	 */
	void editInvoiceInfo(InvoiceInfo invoiceInfo);
}
