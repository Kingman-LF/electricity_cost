package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.ApplyInvoiceInfoMapperManual;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xwkj.cost.mapper.ApplyInvoiceInfoMapperManual;
import com.xwkj.cost.mapper.ContractInfoMapperManual;
import com.xwkj.cost.mapper.auto.ApplyInvoiceEnclosureInfoMapper;
import com.xwkj.cost.mapper.auto.ApplyInvoiceInfoMapper;
import com.xwkj.cost.mapper.auto.MoneyBackInfoMapper;
import com.xwkj.cost.model.ApplyInvoiceEnclosureInfo;
import com.xwkj.cost.model.ApplyInvoiceInfo;
import com.xwkj.cost.model.EnclosureInfo;
import com.xwkj.cost.model.MoneyBackInfo;
import com.xwkj.cost.service.ApplyInvoiceInfoService;
import com.xwkj.cost.service.MoneyBackInfoService;
import com.xwkj.cost.util.PageUtil;
import com.xwkj.cost.vo.ApplyInvoiceVo;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.MoneyBackVo;
import com.xwkj.cost.vo.SelectContractInfoVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.Date;
import java.util.List;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2020-01-11 11:51
 * @Version 1.0
 */
@Service
public class ApplyInvoiceInfoServiceImpl implements ApplyInvoiceInfoService {

	@Autowired(required = false)
	ApplyInvoiceInfoMapper applyInvoiceInfoMapper;

	@Autowired(required = false)
	ApplyInvoiceInfoMapperManual applyInvoiceInfoMapperManual;

	@Autowired(required = false)
	ApplyInvoiceEnclosureInfoMapper applyInvoiceEnclosureInfoMapper;

	@Autowired(required = false)
	MoneyBackInfoMapper moneyBackInfoMapper;

	/**
	 * @description: 添加申请开票信息接口
	 * @methodName: addApplyInvoiceInfo
	 * @param: [applyInvoiceVo]
	 * @return: com.xwkj.cost.common.ResponseResult
	 * @exception:
	 * @date:  2020-01-11 14:07
	 * @author: wanglei
	 */
	@Override
	public Boolean addApplyInvoiceInfo(ApplyInvoiceVo applyInvoiceVo) {
		ApplyInvoiceInfo applyInvoiceInfo = new ApplyInvoiceInfo();
		BeanUtils.copyProperties(applyInvoiceVo,applyInvoiceInfo);
		//申请开票记录
		applyInvoiceInfo.setStatus(1);
		applyInvoiceInfoMapperManual.insert(applyInvoiceInfo);
		//添加附件
		Long id = applyInvoiceInfo.getId();
		if (id != null){
			//添加开票附件信息
			String fileUploads = applyInvoiceVo.getFileUploads();
			if (fileUploads != null && StringUtils.isNotBlank(fileUploads)){
				String[] filePaths = fileUploads.split(",");
				for (String filePath : filePaths) {
					if (StringUtils.isNotBlank(filePath)){
						ApplyInvoiceEnclosureInfo applyInvoiceEnclosureInfo = new ApplyInvoiceEnclosureInfo();
						applyInvoiceEnclosureInfo.setApplyInvoiceId(id);
						applyInvoiceEnclosureInfo.setFilePath(filePath);
						applyInvoiceEnclosureInfo.setCreateTime(new Date());
						applyInvoiceEnclosureInfoMapper.insertSelective(applyInvoiceEnclosureInfo);
					}
				}
			}
		}else{
			return false;
		}
		return true;
	}

	@Override
	public List<ApplyInvoiceInfo> getApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo) {

		return applyInvoiceInfoMapperManual.getApplyInvoiceInfo(applyInvoiceInfo);
	}

	/**
	 * @description: 分页查询申请发票信息
	 * @methodName: getApplyInvoiceInfoList
	 * @param: [pageUtil, id]
	 * @return: com.github.pagehelper.PageInfo<com.xwkj.cost.model.ApplyInvoiceInfo>
	 * @exception:
	 * @date:  2020-01-11 16:45
	 * @author: wanglei
	 */
	@Override
	public PageInfo<ApplyInvoiceInfo> getApplyInvoiceInfoList(PageUtil pageUtil, Long id) {
		if (pageUtil.getLimit() != null && pageUtil.getPage() != null) {
			PageHelper.startPage(pageUtil.getPage(),pageUtil.getLimit());
		}
		List<ApplyInvoiceInfo> list = applyInvoiceInfoMapperManual.selectByContractId(id);
		return new PageInfo<>(list);
	}

	/**
	 * @description: 删除申请发票信息
	 * @methodName: deleteApplyInvoiceInfo
	 * @param: [id]
	 * @return: void
	 * @exception:
	 * @date:  2020-01-11 17:39
	 * @author: wanglei
	 */
	@Override
	public Boolean deleteApplyInvoiceInfo(Long id) {
		ApplyInvoiceInfo applyInvoiceInfo = applyInvoiceInfoMapper.selectByPrimaryKey(id);
		if (applyInvoiceInfo != null){
			if (applyInvoiceInfo.getMoneyBackId() == null){
				applyInvoiceInfo.setStatus(0);
				applyInvoiceInfoMapper.updateByPrimaryKey(applyInvoiceInfo);
			}else{
				return false;
			}
		}
		return true;
	}

	/**
	 * @description: 修改申请开票信息
	 * @methodName: editApplyInvoiceInfo
	 * @param: [applyInvoiceInfo]
	 * @return: void
	 * @exception:
	 * @date:  2020-01-13 9:34
	 * @author: wanglei
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Boolean editApplyInvoiceInfo(ApplyInvoiceInfo applyInvoiceInfo) {
		//主键查询
		ApplyInvoiceInfo applyInvoiceInfo1 = applyInvoiceInfoMapper.selectByPrimaryKey(applyInvoiceInfo.getId());
		if (applyInvoiceInfo1 != null) {
			//修改申请钱数
			if (applyInvoiceInfo1.getMoneyBackId() != null) {
				//修改
				MoneyBackInfo moneyBackInfo = new MoneyBackInfo();
				moneyBackInfo.setMoney(applyInvoiceInfo.getMoney());
				moneyBackInfo.setInvoiceType(applyInvoiceInfo.getType());
				int i = moneyBackInfoMapper.updateByPrimaryKeySelective(moneyBackInfo);
				if (i != 0) {
					applyInvoiceInfoMapper.updateByPrimaryKeySelective(applyInvoiceInfo);
				}else{
					return false;
				}
			}else{
				applyInvoiceInfoMapper.updateByPrimaryKeySelective(applyInvoiceInfo);
			}
		}
		return true;
	}
}
