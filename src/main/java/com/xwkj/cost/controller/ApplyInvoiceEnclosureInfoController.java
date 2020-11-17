package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ApplyInvoiceEnclosureInfo;
import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.xwkj.cost.service.ApplyInvoiceEnclosureInfoService;
import com.xwkj.cost.service.ApplyInvoiceInfoService;
import com.xwkj.cost.util.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2020-01-11 11:49
 * @Version 1.0
 */
@RestController
@Slf4j
public class ApplyInvoiceEnclosureInfoController {

	@Autowired
	ApplyInvoiceEnclosureInfoService applyInvoiceEnclosureInfoService;

	/**
	 * @description: 根据开票主键查询附件信息
	 * @methodName: getApplyInvoiceInfoList
	 * @param: [id]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2020-01-11 17:52
	 * @author: wanglei
	 */
	@PostMapping("getApplyInvoiceEnclosureInfoById")
	public ResponseResult getApplyInvoiceEnclosureInfoById(Long id) {
		ResponseResult responseResult = null;
		try {
			List<ApplyInvoiceEnclosureInfo> list = applyInvoiceEnclosureInfoService.getApplyInvoiceEnclosureInfoById(id);
			log.info("查询申请开票附件信息成功！");
			responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),list,"查询申请开票附件信息成功！");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("查询申请开票附件信息失败！");
			responseResult = ResponseResult.failure("查询申请开票附件信息失败！");
		}
		return responseResult;
	}
}
