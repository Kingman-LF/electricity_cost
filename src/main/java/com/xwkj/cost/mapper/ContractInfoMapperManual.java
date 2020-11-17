package com.xwkj.cost.mapper;

import com.xwkj.cost.model.ContractInfo;
import com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo;
import com.xwkj.cost.vo.SelectContractInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:TODO 合同dao层
 * @Author wanglei
 * @Create 2019-12-11 9:51
 * @Version 1.0
 */
@Repository
public interface ContractInfoMapperManual {
	/***
	 * @description: 插入合同信息返回主键
	 * @methodName: insertSelective
	 * @param: [contractInfo]
	 * @return: java.lang.Long
	 * @exception:
	 * @date:  2019-12-11 9:55
	 * @author: wanglei
	 */
	Long insertSelective(ContractInfo contractInfo);

	/**
	 * @description: 条件查询合同
	 * @methodName: selectSelective
	 * @param: [contractInfo]
	 * @return: java.util.List<com.xwkj.cost.vo.ContractInfoAndInvoiceInfoVo>
	 * @exception:
	 * @date:  2019-12-11 15:20
	 * @author: wanglei
	 */
	List<ContractInfoAndInvoiceInfoVo> selectSelective(@Param("contractInfo") SelectContractInfoVo selectContractInfoVo);
}
