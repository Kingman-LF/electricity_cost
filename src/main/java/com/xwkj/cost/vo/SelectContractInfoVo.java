package com.xwkj.cost.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Description:TODO 合同查询VO
 * @Author wanglei
 * @Create 2019-12-11 16:09
 * @Version 1.0
 */
@Data
public class SelectContractInfoVo {

	/**
	 * 对应字段：contract_num，  字段含义：合同编号
	 */
	private String contractNum;

	/**
	 * 对应字段：item_name，  字段含义：项目名称
	 */
	private String itemName;

	/**
	 * 开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;

	/**
	 * 截止时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;

	/**
	 * 状态
	 */
	private Integer status;
}
