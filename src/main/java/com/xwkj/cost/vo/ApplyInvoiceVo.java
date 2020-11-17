package com.xwkj.cost.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description:TODO
 * @Author wanglei
 * @Create 2020-01-11 14:05
 * @Version 1.0
 */
@Data
@ToString
public class ApplyInvoiceVo {
	/**
	 * 对应字段：id，  字段含义：主键
	 */
	private Long id;

	/**
	 * 对应字段：name，  字段含义：申请发票名称
	 */
	private String name;

	/**
	 * 对应字段：createtime，  字段含义：发票申请日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createtime;

	/**
	 * 对应字段：latetime，  字段含义：发票开具最迟时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date latetime;

	/**
	 * 对应字段：type，  字段含义：1 专票  2 普票
	 */
	private Integer type;

	/**
	 * 对应字段：contract_id，  字段含义：合同主键
	 */
	private Long contractId;

	/**
	 * 对应字段：money，  字段含义：申请开票金额
	 */
	private BigDecimal money;

	/**
	 * 对应字段：note，  字段含义：申请开票备注
	 */
	private String note;

	/**
	 * 对应字段：money_back_id，  字段含义：回款主键
	 */
	private Long moneyBackId;

	/**
	 * 对应字段：status，  字段含义：状态
	 */
	private Integer status;

	/**
	 * 多文件上传路径
	 */
	private String fileUploads;
}
