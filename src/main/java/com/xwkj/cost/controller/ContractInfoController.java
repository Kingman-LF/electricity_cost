package com.xwkj.cost.controller;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.ResponseResult;
import com.xwkj.cost.common.ResponseResultEnum;
import com.xwkj.cost.model.ContractInfo;
import com.xwkj.cost.service.ContractInfoService;
import com.xwkj.cost.service.WordService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.ContractInfoVo;
import com.xwkj.cost.vo.SelectContractInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @Description:TODO 合同控制层
 * @Author wanglei
 * @Create 2019-12-11 9:30
 * @Version 1.0
 */
@RestController
@Slf4j
public class ContractInfoController {

	@Autowired
	ContractInfoService contractInfoService;

	@Autowired
	WordService wordService;

	/***
	 * @description: 添加合同及附件信息
	 * @methodName: add
	 * @param: [contractInfoVo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-11 9:44
	 * @author: wanglei
	 */
	@PostMapping("addContractInfo")
	public ResponseResult addContractInfo(ContractInfoVo contractInfoVo){
		try{
			Long id = contractInfoService.addContractInfoAndAnnex(contractInfoVo);
			if (id == -1){
				log.info("添加合同发票附件信息失败！");
				return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"请登陆后在操作！");
			}else{
				log.info("添加合同发票附件信息成功！");
				return ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),id,"添加合同发票附件信息成功");
			}
		}catch (Exception e){
			log.error("添加合同信息附件失败！");
			e.printStackTrace();
			return ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"添加合同发票附件信息失败！");
		}
	}

	/**
	 * @description: 查询合同信息
	 * @methodName: getContractInfo
	 * @param: [pageUtil, selectContractInfoVo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-11 15:05
	 * @author: wanglei
	 */
	@PostMapping("getContractInfo")
	public ResponseResult getContractInfo(PageUtil pageUtil, SelectContractInfoVo selectContractInfoVo) {
		ResponseResult responseResult = null;
		try {
			PageInfo<ContractInfoAndInvoiceInfoVo> page = contractInfoService.getContractInfo(pageUtil,selectContractInfoVo);
			log.info("查询合同信息成功！");
			responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),page,"查询合同信息成功！");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("查询合同信息失败！");
			responseResult = ResponseResult.failure("查询合同信息失败！");
		}
		return responseResult;
	}

	/**
	 * @description: 修改合同信息
	 * @methodName: editContractInfo
	 * @param: [contractInfo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-12 10:33
	 * @author: wanglei
	 */
	@PostMapping("editContractInfo")
	public ResponseResult editContractInfo(ContractInfo contractInfo) {
		ResponseResult responseResult = null;
		try {
			Boolean flag = contractInfoService.editContractInfo(contractInfo);
			if (flag){
				log.info("修改合同信息成功！");
				responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"修改合同信息成功！");
			}else{
				log.info("修改合同信息失败！");
				responseResult = ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"请登录后在操作！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.error("修改合同信息失败！");
			responseResult = ResponseResult.failure("修改合同信息失败！");
		}
		return responseResult;
	}

	/**
	 * @description: 批量删除合同信息
	 * @methodName: delContractInfo
	 * @param: [contractIds]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-12 16:42
	 * @author: wanglei
	 */
	@PostMapping("delContractInfo")
	public ResponseResult delContractInfo(@RequestParam("contractIds[]") Long[] contractIds) {
		ResponseResult responseResult = null;
		try {
			Boolean flag = contractInfoService.delContractInfo(contractIds);
			if (flag){
				log.info("删除合同信息成功！");
				responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"删除合同信息成功！");
			}else{
				log.info("删除合同信息失败！");
				responseResult = ResponseResult.failure(ResponseResultEnum.FAILURE.getCode(),"请登录后在操作！");
			}
		}catch (Exception e) {
			e.printStackTrace();
			log.error("删除合同信息失败！");
			responseResult = ResponseResult.failure("删除合同信息失败！");
		}
		return responseResult;
	}

	/***
	 * @description: 打印合同成本报表
	 * @methodName: printfContractWord
	 * @param: [contractIds, response]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2019-12-13 21:58
	 * @author: wanglei
	 */
	@GetMapping("printfContractWord")
	public ResponseResult printfContractWord( Long contractId, HttpServletResponse response) {
		ResponseResult responseResult = null;
		try {
			wordService.printfContractWord(contractId,response);
			log.info("打印合同成本报表成功！");
			responseResult = ResponseResult.success(ResponseResultEnum.SUCCESS.getCode(),null,"打印合同成本报表成功！");
		}catch (Exception e) {
			e.printStackTrace();
			log.error("打印合同成本报表失败！");
			responseResult = ResponseResult.failure("打印合同成本报表失败！");
		}
		return responseResult;
	}

}
