package com.xwkj.cost.mapper;

import com.xwkj.cost.model.EnclosureInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:TODO 合同附件mapper
 * @Author wanglei
 * @Create 2019-12-12 11:43
 * @Version 1.0
 */
@Repository
public interface EnclosureInfoMapperManual {
	/**
	 * @description: 根据合同主键查询附件信息
	 * @methodName: selectEnclosureInfoByContractId
	 * @param: [id]
	 * @return: java.util.List<com.xwkj.cost.model.EnclosureInfo>
	 * @exception:
	 * @date:  2019-12-12 11:45
	 * @author: wanglei
	 */
	List<EnclosureInfo> selectEnclosureInfoByContractId(Long id);
}
