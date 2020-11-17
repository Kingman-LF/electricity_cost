package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.EnclosureInfoMapperManual;
import com.xwkj.cost.mapper.auto.EnclosureInfoMapper;
import com.xwkj.cost.model.EnclosureInfo;
import com.xwkj.cost.service.EnclosureInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:TODO 合同附件接口实现
 * @Author wanglei
 * @Create 2019-12-12 11:36
 * @Version 1.0
 */
@Service
public class EnclosureInfoServiceImpl implements EnclosureInfoService {

	@Autowired
	EnclosureInfoMapperManual enclosureInfoMapperManual;

	/**
	 * @description: 根据合同主键查询附件信息接口实现
	 * @methodName: getEnclosureInfoByContractId
	 * @param: [id]
	 * @return: java.util.List<com.xwkj.cost.model.EnclosureInfo>
	 * @exception:
	 * @date:  2019-12-12 11:41
	 * @author: wanglei
	 */
	@Override
	public List<EnclosureInfo> getEnclosureInfoByContractId(Long id) {
		return enclosureInfoMapperManual.selectEnclosureInfoByContractId(id);
	}
}
