package com.xwkj.cost.mapper;

import com.xwkj.cost.model.InvoiceInfo;
import org.springframework.stereotype.Repository;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2019-12-12 9:10
 * @Version 1.0
 */
@Repository
public interface InvoiceInfoMapperManual {

	/**
	 * @description: 根据合同主键查询发票
	 * @methodName: selectInvoiceInfoByContractId
	 * @param: [id]
	 * @return: com.xwkj.cost.model.InvoiceInfo
	 * @exception:
	 * @date:  2019-12-12 9:12
	 * @author: wanglei
	 */
	InvoiceInfo selectInvoiceInfoByContractId(Long id);
}
