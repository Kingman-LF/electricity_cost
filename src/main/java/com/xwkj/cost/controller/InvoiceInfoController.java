package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.InvoiceInfo;
import com.xwkj.cost.service.InvoiceInfoService;
import com.xwkj.cost.vo.ContractInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:TODO 合同发票控制层
 * @Author wanglei
 * @Create 2019-12-11 10:27
 * @Version 1.0
 */
@RestController
@Slf4j
public class InvoiceInfoController {

	@Autowired
	InvoiceInfoService invoiceInfoService;

	/***
	 * @description: 添加合同发票信息
	 * @methodName: addInvoiceInfo
	 * @param: [invoiceInfo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-11 10:43
	 * @author: wanglei
	 */
	@PostMapping("addInvoiceInfo")
	public ResponseResult addInvoiceInfo(InvoiceInfo invoiceInfo){
		try{
			invoiceInfoService.addInvoiceInfo(invoiceInfo);
			log.info("添加合同发票信息成功！");
			return ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"添加合同发票信息成功");
		}catch (Exception e){
			log.error("添加合同发票信息失败！");
			e.printStackTrace();
			return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"添加合同发票信息失败！");
		}
	}

	/**
	 * @description: 根据合同主键查询发票信息
	 * @methodName: getInvoiceInfoByContractId
	 * @param: [id]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-12 9:07
	 * @author: wanglei
	 */
	@PostMapping("getInvoiceInfoByContractId")
	public ResponseResult getInvoiceInfoByContractId(Long id){
		try{
			InvoiceInfo invoiceInfo= invoiceInfoService.getInvoiceInfoByContractId(id);
			log.info("根据合同查询发票信息成功！");
			return ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),invoiceInfo,"根据合同查询发票信息成功");
		}catch (Exception e){
			log.error("根据合同查询发票信息失败！");
			e.printStackTrace();
			return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"根据合同查询发票信息失败！");
		}
	}

	/**
	 * @description: 修改合同发票信息接口
	 * @methodName: editInvoiceInfo
	 * @param: [invoiceInfo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2020-01-03 9:02
	 * @author: wanglei
	 */
	@PostMapping("editInvoiceInfo")
	public ResponseResult editInvoiceInfo(InvoiceInfo invoiceInfo){
		try{
			invoiceInfoService.editInvoiceInfo(invoiceInfo);
			log.info("修改合同发票信息成功！");
			return ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),invoiceInfo,"修改合同发票信息成功");
		}catch (Exception e){
			log.error("修改合同发票信息失败！");
			e.printStackTrace();
			return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"修改合同发票信息失败！");
		}
	}
}
