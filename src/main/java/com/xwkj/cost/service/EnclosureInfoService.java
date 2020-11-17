package com.xwkj.cost.service;

import com.xwkj.cost.model.EnclosureInfo;

import java.util.List;

/**
 * @Description:TODO 合同附件接口
 * @Author wanglei
 * @Create 2019-12-12 11:36
 * @Version 1.0
 */
public interface EnclosureInfoService {

	/**
	 * @description: 根据合同主键查询附件信息接口
	 * @methodName: getEnclosureInfoByContractId
	 * @param: [id]
	 * @return: java.util.List<com.xwkj.cost.model.EnclosureInfo>
	 * @exception:
	 * @date:  2019-12-12 11:41
	 * @author: wanglei
	 */
	List<EnclosureInfo> getEnclosureInfoByContractId(Long id);
}
