package com.xwkj.cost.controller;

import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.EnclosureInfo;
import com.xwkj.cost.service.EnclosureInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Description:TODO 合同附件控制层
 * @Author wanglei
 * @Create 2019-12-12 11:35
 * @Version 1.0
 */
@RestController
@Slf4j
public class EnclosureInfoController {

	@Autowired
	EnclosureInfoService enclosureInfoService;

	/**
	 * @description: 根据合同主键查询附件信息
	 * @methodName: getEnclosureInfoByContractId
	 * @param: [id]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-12 11:40
	 * @author: wanglei
	 */
	@PostMapping("/getEnclosureInfoByContractId")
	public ResponseResult getEnclosureInfoByContractId(Long id){
		ResponseResult responseResult = null;
		try {
			List<EnclosureInfo> enclosureInfos = enclosureInfoService.getEnclosureInfoByContractId(id);
			responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),enclosureInfos,"根据合同主键查询附件信息成功!");
			log.info("根据合同主键查询附件信息成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("根据合同主键查询附件信息失败！");
			responseResult = ResponseResult.failure(1,"根据合同主键查询附件信息失败!");
		}
		return responseResult;
	}

}
