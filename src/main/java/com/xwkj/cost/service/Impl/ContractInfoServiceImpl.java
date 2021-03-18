package com.xwkj.cost.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.common.LoginUserInfoManager;
import com.xwkj.cost.mapper.ContractInfoMapperManual;
import com.xwkj.cost.mapper.auto.ContractInfoMapper;
import com.xwkj.cost.mapper.auto.EnclosureInfoMapper;
import com.xwkj.cost.mapper.auto.UserInfoMapper;
import com.xwkj.cost.model.ContractInfo;
import com.xwkj.cost.model.EnclosureInfo;
import com.xwkj.cost.model.UserInfo;
import com.xwkj.cost.service.ContractInfoService;
import com.xwkj.cost.service.MoneyBackInfoService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.ContractInfoVo;
import com.xwkj.cost.vo.MoneyBackVo;
import com.xwkj.cost.vo.SelectContractInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description:TODO 合同业务层实现
 * @Author wanglei
 * @Create 2019-12-11 9:32
 * @Version 1.0
 */
@Service
public class ContractInfoServiceImpl implements ContractInfoService {

	@Autowired
	ContractInfoMapperManual contractInfoMapperManual;

	@Autowired
	ContractInfoMapper contractInfoMapper;

	@Autowired
	EnclosureInfoMapper enclosureInfoMapper;

	@Autowired
	MoneyBackInfoService moneyBackInfoService;

	@Autowired
	UserInfoMapper userInfoMapper;

	/***
	 * @description: 添加合同附件信息
	 * @methodName: addContractInfoAndAnnex
	 * @param: [contractInfoVo]
	 * @return: void
	 * @exception:
	 * @date:  2019-12-11 9:45
	 * @author: wanglei
	 */
	@Override
	public Long addContractInfoAndAnnex(ContractInfoVo contractInfoVo) {
		ContractInfo contractInfo = new ContractInfo();
		BeanUtils.copyProperties(contractInfoVo,contractInfo);
		contractInfo.setCreatTime(new Date());
		contractInfo.setLastModifiedTime(new Date());
		//查询登陆信息
		UserInfo userInfo = LoginUserInfoManager.getUserInfo();
		if (userInfo != null) {
			contractInfo.setCreator(userInfo.getId());
			contractInfo.setLastModifier(userInfo.getId());
		}else{
			return Long.parseLong("-1");
		}
		//返回插入合同主键
		contractInfoMapperManual.insertSelective(contractInfo);
		Long id = contractInfo.getId();
		if (id != null){
			//添加合同附件信息
			String fileUploads = contractInfoVo.getFileUploads();
			if (fileUploads != null && StringUtils.isNotBlank(fileUploads)){
				String[] filePaths = fileUploads.split(",");
				for (String filePath : filePaths) {
					if (StringUtils.isNotBlank(filePath)){
						EnclosureInfo enclosureInfo = new EnclosureInfo();
						enclosureInfo.setContractId(id);
						enclosureInfo.setFilePath(filePath);
						enclosureInfo.setCreateTime(new Date());
						enclosureInfoMapper.insertSelective(enclosureInfo);
					}
				}
			}
		}
		return id;
	}

	/**
	 * @description: 查询合同信息接口实现
	 * @methodName: getContractInfo
	 * @param: [pageUtil, selectContractInfoVo]
	 * @return: com.github.pagehelper.PageInfo<com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo>
	 * @exception:
	 * @date:  2019-12-11 15:07
	 * @author: wanglei
	 */
	@Override
	public PageInfo<ContractInfoAndInvoiceInfoVo> getContractInfo(PageUtil pageUtil, SelectContractInfoVo selectContractInfoVo) {
		if (pageUtil.getLimit() != null && pageUtil.getPage() != null) {
			PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
		}
		List<ContractInfoAndInvoiceInfoVo> list = contractInfoMapperManual.selectSelective(selectContractInfoVo);

		//查询每个合同汇款金额
		for (ContractInfoAndInvoiceInfoVo contractInfoAndInvoiceInfoVo : list) {
			MoneyBackVo sumAndCount = moneyBackInfoService.getSumAndCount(contractInfoAndInvoiceInfoVo.getId());
			contractInfoAndInvoiceInfoVo.setMoneySum(sumAndCount.getMoneySum());

			UserInfo userInfo = userInfoMapper.selectByPrimaryKey(contractInfoAndInvoiceInfoVo.getCreator());
			contractInfoAndInvoiceInfoVo.setCreatorName(userInfo.getUserName());

		}
		return new PageInfo<>(list);
	}

	/**
	 * @description: 修改合同信息接口实现
	 * @methodName: editContractInfo
	 * @param: [contractInfo]
	 * @return: Boolean
	 * @exception:
	 * @date:  2019-12-12 10:33
	 * @author: wanglei
	 */
	@Override
	public Boolean editContractInfo(ContractInfo contractInfo) {
		Boolean flag = true;
		//查询登陆信息
		UserInfo userInfo = LoginUserInfoManager.getUserInfo();
		if (userInfo != null) {
			contractInfo.setLastModifier(userInfo.getId());
			contractInfoMapper.updateByPrimaryKeySelective(contractInfo);
		}else{
			flag = false;
		}
		return flag;
	}

	/**
	 * @description: 批量删除合同接口
	 * @methodName: delContractInfo
	 * @param: [contractIds]
	 * @return: Boolean
	 * @exception:
	 * @date:  2019-12-12 16:43
	 * @author: wanglei
	 */
	@Override
	public Boolean delContractInfo(Long[] contractIds) {
		ContractInfo contractInfo = new ContractInfo();
		UserInfo userInfo = LoginUserInfoManager.getUserInfo();
		for (Long contractId : contractIds) {
			if (userInfo != null) {
				contractInfo.setLastModifier(userInfo.getId());
				contractInfo.setId(contractId);
				contractInfo.setStatus(0);
				contractInfoMapper.updateByPrimaryKeySelective(contractInfo);
			}else{
				return false;
			}
		}
		return true;
	}
}
