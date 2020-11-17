package com.xwkj.cost.service;

import com.github.pagehelper.PageInfo;
import com.xwkj.cost.model.ContractInfo;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.ContractInfoVo;
import com.xwkj.cost.vo.SelectContractInfoVo;

import java.util.List;

/**
 * @Description:TODO 合同业务层
 * @Author wanglei
 * @Create 2019-12-11 9:32
 * @Version 1.0
 */
public interface ContractInfoService {

	/***
	 * @description: 添加合同附件信息
	 * @methodName: addContractInfoAndAnnex
	 * @param: [contractInfoVo]
	 * @return: long
	 * @exception:
	 * @date:  2019-12-11 9:45
	 * @author: wanglei
	 */
	Long addContractInfoAndAnnex(ContractInfoVo contractInfoVo);

	/**
	 * @description: 查询合同信息业务接口
	 * @methodName: getContractInfo
	 * @param: [pageUtil, selectContractInfoVo]
	 * @return: com.github.pagehelper.PageInfo<com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo>
	 * @exception:
	 * @date:  2019-12-11 15:07
	 * @author: wanglei
	 */
	PageInfo<ContractInfoAndInvoiceInfoVo> getContractInfo(PageUtil pageUtil, SelectContractInfoVo selectContractInfoVo);

	/**
	 * @description: 修改合同信息接口
	 * @methodName: editContractInfo
	 * @param: [contractInfo]
	 * @return: Boolean
	 * @exception:
	 * @date:  2019-12-12 10:33
	 * @author: wanglei
	 */
	Boolean editContractInfo(ContractInfo contractInfo);

	/***
	 * @description: 批量删除合同接口
	 * @methodName: delContractInfo
	 * @param: [contractIds]
	 * @return: Boolean
	 * @exception:
	 * @date:  2019-12-12 16:43
	 * @author: wanglei
	 */
	Boolean delContractInfo(Long[] contractIds);
}
