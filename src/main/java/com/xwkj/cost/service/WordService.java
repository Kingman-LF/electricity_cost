package com.xwkj.cost.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description:TODO 生成word业务
 * @Author wanglei
 * @Create 2019-12-13 9:11
 * @Version 1.0
 */
public interface WordService {

	/**
	 * @description: 打印合同成本报表接口
	 * @methodName: printfContractWord
	 * @param: [contractIds, response]
	 * @return: void
	 * @exception:
	 * @date:  2019-12-13 21:58
	 * @author: wanglei
	 */
	void printfContractWord(Long contractId, HttpServletResponse response);
}
