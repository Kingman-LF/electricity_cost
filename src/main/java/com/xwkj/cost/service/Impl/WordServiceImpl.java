package com.xwkj.cost.service.Impl;

import com.xwkj.cost.mapper.ContractCostTypeRelatedMapperManual;
import com.xwkj.cost.mapper.ReturnTicketInfoMapperManual;
import com.xwkj.cost.mapper.SubContractInfoMapperManual;
import com.xwkj.cost.mapper.auto.ContractInfoMapper;
import com.xwkj.cost.mapper.auto.CostTypeInfoMapper;
import com.xwkj.cost.model.*;
import com.xwkj.cost.service.*;
import com.xwkj.cost.vo.MoneyBackVo;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:TODO 生成word实现
 * @Author wanglei
 * @Create 2019-12-13 9:12
 * @Version 1.0
 */
@Service
public class WordServiceImpl implements WordService{

	@Autowired
	ContractInfoMapper contractInfoMapper;

	@Autowired
	SubContractInfoMapperManual subContractInfoMapperManual;

	@Autowired
	CostTypeInfoMapper costTypeInfoMapper;

	@Autowired
	ReturnTicketInfoMapperManual returnTicketInfoMapperManual;

	@Autowired
	ContractCostTypeRelatedMapperManual contractCostTypeRelatedMapperManual;

	@Autowired
	MoneyBackInfoService moneyBackInfoService;

	@Autowired
	CostTypeInfoService costTypeInfoService;

	@Autowired
	ContractCostTypeRelatedService contractCostTypeRelatedService;

	@Autowired
	SubContractInfoService subContractInfoService;

	/**
	 * @description: 打印合同成本报表接口实现
	 * @methodName: printfContractWord
	 * @param: [contractIds, response]
	 * @return: void
	 * @exception:
	 * @date:  2019-12-13 21:58
	 * @author: wanglei
	 */
	@Override
	public void printfContractWord(Long contractId, HttpServletResponse response) {

		//查询合同信息
		ContractInfo contractInfo = contractInfoMapper.selectByPrimaryKey(contractId);
		if (contractInfo != null){
			//创建document对象
			XWPFDocument document = new XWPFDocument();
			//新建一个标题段落对象（就是一段文字）
			XWPFParagraph titleParagraph = document.createParagraph();
			//样式居中
			titleParagraph.setAlignment(ParagraphAlignment.CENTER);
			//创建文本对象
			XWPFRun titleFun = titleParagraph.createRun();
			//设置标题的名字
			titleFun.setText("项目结项单（成本）");
			//加粗
			titleFun.setBold(true);
			//字体大小
			titleFun.setFontSize(14);
			//设置字体
			titleFun.setFontFamily("宋体");
			//换行
//				titleFun.addBreak();

			//新建一个段落对象（就是一段文字）
			XWPFParagraph textParagraph = document.createParagraph();
			//样式右对齐
			textParagraph.setAlignment(ParagraphAlignment.RIGHT);
			//创建文本对象
			XWPFRun textFun = textParagraph.createRun();
			//当前系统时间
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			String currDate = sdf.format(new Date());
			textFun.setText("时间："+ currDate);
			//加粗
			textFun.setBold(true);
			//字体大小
			textFun.setFontSize(10);
			//设置字体
			textFun.setFontFamily("宋体");

			//换行
//				textFun.addBreak();

			//表格第一行
			//创建表格
			XWPFTable contractTable = document.createTable(1,7);
			CTTblPr tblPr = contractTable.getCTTbl().getTblPr();
			tblPr.getTblW().setType(STTblWidth.DXA);
			tblPr.getTblW().setW(new BigInteger("9072"));
//			tblPr.getTblW().setW(new BigInteger("8072"));
			XWPFTableRow row = contractTable.getRow(0);
			List<XWPFTableCell> tableCells = row.getTableCells();
			tableCells.get(0).setText("项目名称");
			//设置单元格宽度
			tableCells.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//合并单元格
			WordServiceImpl.mergeCellsHorizontal(contractTable,0,1,3);
			if (contractInfo.getItemName() != null){
				tableCells.get(1).setText(contractInfo.getItemName());
			}
			//设置单元格宽度
			tableCells.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells.get(4).setText("未回收质保金");
			//设置单元格宽度
			tableCells.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells.get(5).setText("");
			WordServiceImpl.mergeCellsHorizontal(contractTable,0,5,6);
			//设置单元格宽度
			tableCells.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
			tableCells.get(6).setText("");
			//设置单元格宽度
			tableCells.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);


			//表格第二行
			//创建表格
			XWPFTable contractTable1 = document.createTable(1,7);
			CTTblPr tblPr1 = contractTable1.getCTTbl().getTblPr();
			tblPr1.getTblW().setType(STTblWidth.DXA);
			tblPr1.getTblW().setW(new BigInteger("9072"));
			XWPFTableRow row1 = contractTable1.getRow(0);
			List<XWPFTableCell> tableCells1 = row1.getTableCells();
			tableCells1.get(0).setText("合同编号");
			//设置单元格宽度
			tableCells1.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells1.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells1.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//合并单元格
			WordServiceImpl.mergeCellsHorizontal(contractTable1,0,1,2);
			if (contractInfo.getContractNum() != null){
				tableCells1.get(1).setText(contractInfo.getContractNum());
			}
			//设置单元格宽度
			tableCells1.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells1.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells1.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
			//设置单元格宽度
			tableCells1.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells1.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells1.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells1.get(3).setText("合同金额");
			//设置单元格宽度
			tableCells1.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells1.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells1.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
			//设置单元格宽度
			tableCells1.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			if (contractInfo.getContractMoney() != null) {
				tableCells1.get(4).setText(contractInfo.getContractMoney().toString());
			}
			//设置文本居中
			tableCells1.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells1.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
			MoneyBackVo sumAndCount = moneyBackInfoService.getSumAndCount(contractId);
			if (contractInfo.getContractMoney() != null) {
				tableCells1.get(5).setText("已回款："+sumAndCount.getMoneySum().toString());
			}
			WordServiceImpl.mergeCellsHorizontal(contractTable1,0,5,6);
			//设置单元格宽度
			tableCells1.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells1.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells1.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells1.get(6).setText("");
			//设置单元格宽度
			tableCells1.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells1.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells1.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);



			//支出总成本
			BigDecimal sumCost = new BigDecimal(0);
			//支出总已付款金额
			BigDecimal sumBack = new BigDecimal(0);
			//支出总未付款金额
			BigDecimal sumSubMoney = new BigDecimal(0);

			List<CostTypeInfo> list = costTypeInfoService.getCostTypeInfoListByContractId(contractId, "");
			//支出项序号
			int i = 1;
			if (list != null) {
				list = list.stream().sorted(new Comparator<CostTypeInfo>() {
					@Override
					public int compare(CostTypeInfo o1, CostTypeInfo o2) {
						Long aLong = o1.getSort() - o2.getSort();
						return aLong.intValue();
					}
				}).collect(Collectors.toList());
				//表格第三行
				//创建表格
				XWPFTable contractTable2 = document.createTable(1,7);
				CTTblPr tblPr2 = contractTable2.getCTTbl().getTblPr();
				tblPr2.getTblW().setType(STTblWidth.DXA);
				tblPr2.getTblW().setW(new BigInteger("9072"));
				XWPFTableRow row2 = contractTable2.getRow(0);
				List<XWPFTableCell> tableCells2 = row2.getTableCells();
				tableCells2.get(0).setText("序号");
				//设置单元格宽度
				tableCells2.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells2.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells2.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells2.get(1).setText("支出项");
				//设置单元格宽度
				tableCells2.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells2.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells2.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells2.get(2).setText("成本金额");
				//设置单元格宽度
				tableCells2.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells2.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells2.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells2.get(3).setText("已付款金额");
				//设置单元格宽度
				tableCells2.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells2.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells2.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells2.get(4).setText("未付款金额");
				//设置单元格宽度
				tableCells2.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells2.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells2.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells2.get(5).setText("收款人");
				//设置单元格宽度
				tableCells2.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells2.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells2.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells2.get(6).setText("备注");
				//设置单元格宽度
				tableCells2.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells2.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells2.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				for (CostTypeInfo costTypeInfo : list) {
					if (costTypeInfo.getpId() == 1){
						//创建表格
						XWPFTable contractTable3 = document.createTable(1,7);
						CTTblPr tblPr3 = contractTable3.getCTTbl().getTblPr();
						tblPr3.getTblW().setType(STTblWidth.DXA);
						tblPr3.getTblW().setW(new BigInteger("9072"));
						XWPFTableRow row3 = contractTable3.getRow(0);
						List<XWPFTableCell> tableCells3 = row3.getTableCells();
						tableCells3.get(0).setText(String.valueOf(i));
						//设置单元格宽度
						tableCells3.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
						//设置文本居中
						tableCells3.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
						//设置垂直居中
						tableCells3.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

						if (costTypeInfo.getName() != null) {
							tableCells3.get(1).setText(costTypeInfo.getName());
						}
						//设置单元格宽度
						tableCells3.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
						//设置文本居中
						tableCells3.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
						//设置垂直居中
						tableCells3.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

						//计算成本金额
						//其他成本
						BigDecimal countCost = new BigDecimal(0);
						List<ContractCostTypeRelated> contractCostTypeRelatedListWithoutPage = contractCostTypeRelatedService.getContractCostTypeRelatedListWithoutPage(contractId);
						if (contractCostTypeRelatedListWithoutPage != null) {
							for (ContractCostTypeRelated contractCostTypeRelated : contractCostTypeRelatedListWithoutPage) {
								String costTypeId = contractCostTypeRelated.getCostTypeId();
								if (costTypeId != null) {
									String twiceStr = costTypeId.split(",")[1];
									if(twiceStr.equals(String.valueOf(costTypeInfo.getId()))){
										if (contractCostTypeRelated.getCost() != null) {
											countCost = countCost.add(contractCostTypeRelated.getCost());
										}
									}
								}
							}
						}
						//合同成本
						List<SubContractInfo> subContractInfoListWithoutPage = subContractInfoService.getSubContractInfoListWithoutPage(contractId);
						if (subContractInfoListWithoutPage != null) {
							for (SubContractInfo subContractInfo : subContractInfoListWithoutPage) {
								String costTypeId = subContractInfo.getCostTypeId();
								if (costTypeId != null) {
									String twiceStr = costTypeId.split(",")[1];
									if(twiceStr.equals(String.valueOf(costTypeInfo.getId()))){
										countCost = countCost.add(subContractInfo.getCostMoney());
									}
								}
							}
						}
						//计算总成本
						sumCost = sumCost.add(countCost);
						tableCells3.get(2).setText(String.valueOf(countCost));
						//设置单元格宽度
						tableCells3.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
						//设置文本居中
						tableCells3.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
						//设置垂直居中
						tableCells3.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

						//计算已付款金额
						//其他成本
						BigDecimal countBack = new BigDecimal(0);
						if (contractCostTypeRelatedListWithoutPage != null) {
							for (ContractCostTypeRelated contractCostTypeRelated : contractCostTypeRelatedListWithoutPage) {
								String costTypeId = contractCostTypeRelated.getCostTypeId();
								if (costTypeId != null) {
									String twiceStr = costTypeId.split(",")[1];
									if(twiceStr.equals(String.valueOf(costTypeInfo.getId()))){
										if (contractCostTypeRelated.getCost() != null) {
											countBack = countBack.add(contractCostTypeRelated.getCost());
										}
									}
								}
							}
						}
						//合同成本
						if (subContractInfoListWithoutPage != null) {
							for (SubContractInfo subContractInfo : subContractInfoListWithoutPage) {
								String costTypeId = subContractInfo.getCostTypeId();
								if (costTypeId != null) {
									String twiceStr = costTypeId.split(",")[1];
									if(twiceStr.equals(String.valueOf(costTypeInfo.getId()))){
										if (subContractInfo.getSubContractCost() != null){
											if (subContractInfo.getSubContractCost() != null) {
												countBack = countBack.add(subContractInfo.getSubContractCost());
											}
										}
									}
								}
							}
						}
						//计算总已付款金额
						sumBack = sumBack.add(countBack);
						tableCells3.get(3).setText(String.valueOf(countBack));
						//设置单元格宽度
						tableCells3.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
						//设置文本居中
						tableCells3.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
						//设置垂直居中
						tableCells3.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

						//计算未付款金额
						BigDecimal countSubMoney = new BigDecimal("0");
						countSubMoney = countCost.subtract(countBack);
						if (countSubMoney.intValue() != 0){
							//计算总已付款金额
							sumSubMoney = sumSubMoney.add(countSubMoney);
							tableCells3.get(4).setText(String.valueOf(countSubMoney));
						}
						//设置单元格宽度
						tableCells3.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
						//设置文本居中
						tableCells3.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
						//设置垂直居中
						tableCells3.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

						tableCells3.get(5).setText("");
						//设置单元格宽度
						tableCells3.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
						//设置文本居中
						tableCells3.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
						//设置垂直居中
						tableCells3.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

						tableCells3.get(6).setText("");
						//设置单元格宽度
						tableCells3.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
						//设置文本居中
						tableCells3.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
						//设置垂直居中
						tableCells3.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

						//合同类型二级节点下查询
						//查询其他合同成本信息
						List<SubContractInfo> subContractInfoListByContractId = subContractInfoMapperManual.getSubContractInfoListByContractId(new SubContractInfo().setContractId(contractId));
						if (subContractInfoListByContractId != null){
							for(SubContractInfo s : subContractInfoListByContractId){
								String str = s.getCostTypeId();
								String[] split = str.split(",");
								CostTypeInfo costTypeInfo1 = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length-1]));
								//计算未付款金额
								BigDecimal unpaid= s.getCostMoney().subtract(s.getSubContractCost());
								//获取成本合同回票信息
								List<ReturnTicketInfo> returnTicketInfoList = returnTicketInfoMapperManual.getReturnTicketInfoListBySubContractId(s.getId());
								//存储回票总金额
								BigDecimal returnTicketMoney = new BigDecimal(0);
								if (returnTicketInfoList != null && returnTicketInfoList.size() != 0 ){
									for (ReturnTicketInfo r : returnTicketInfoList){
										returnTicketMoney = returnTicketMoney.add(r.getMoney());
									}
								}
								s.setCostTypeName(costTypeInfo1.getName()).setUnpaid(unpaid).setReturnTicketMoney(returnTicketMoney);
							}
						}




						//其他合同的基本信息打印
						for (SubContractInfo subContractInfo : subContractInfoListByContractId) {
							if (subContractInfo.getCostTypeId().split(",")[1].equals(String.valueOf(costTypeInfo.getId()))){
								XWPFTable contractTable4 = document.createTable(1,7);
								CTTblPr tblPr4 = contractTable4.getCTTbl().getTblPr();
								tblPr4.getTblW().setType(STTblWidth.DXA);
								tblPr4.getTblW().setW(new BigInteger("9072"));
								XWPFTableRow row4 = contractTable4.getRow(0);
								List<XWPFTableCell> tableCells4 = row4.getTableCells();
//												tableCells4.get(0).setText(String.valueOf(i));
								//设置单元格宽度
								tableCells4.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//支出项
								if (subContractInfo.getCostTypeName() != null) {
									tableCells4.get(1).setText(subContractInfo.getCostTypeName());
								}
								//设置单元格宽度
								tableCells4.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//成本金额
								tableCells4.get(2).setText(String.valueOf(subContractInfo.getCostMoney()));
								//设置单元格宽度
								tableCells4.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//已付款金额
								tableCells4.get(3).setText(String.valueOf(subContractInfo.getSubContractCost()));
								//设置单元格宽度
								tableCells4.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//未付款金额
								tableCells4.get(4).setText(String.valueOf(subContractInfo.getUnpaid()));
								//设置单元格宽度
								tableCells4.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//收款人
								tableCells4.get(5).setText(subContractInfo.getPayee());
								//设置单元格宽度
								tableCells4.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//备注
//												tableCells4.get(6).setText(String.valueOf(subContractInfo.getUnpaid()));
								//设置单元格宽度
								tableCells4.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
							}
						}
						//合同成本成本信息查询
						List<ContractCostTypeRelated> contractCostTypeRelatedListByContractId = contractCostTypeRelatedMapperManual.getContractCostTypeRelatedListByContractId(new ContractCostTypeRelated().setContractId(contractId));
						if (contractCostTypeRelatedListByContractId != null ){
							for (ContractCostTypeRelated c : contractCostTypeRelatedListByContractId){
								String str = c.getCostTypeId();
								String[] split = str.split(",");
								CostTypeInfo costTypeInfo1 = costTypeInfoMapper.selectByPrimaryKey(Long.parseLong(split[split.length-1]));
								if (costTypeInfo != null){
									c.setCostTypeName(costTypeInfo1.getName());
								}
							}
						}
						//合同成本信息打印
						for (ContractCostTypeRelated costTypeRelated : contractCostTypeRelatedListByContractId){
							if (costTypeRelated.getCostTypeId().split(",")[1].equals(String.valueOf(costTypeInfo.getId()))){
								XWPFTable contractTable4 = document.createTable(1,7);
								CTTblPr tblPr4 = contractTable4.getCTTbl().getTblPr();
								tblPr4.getTblW().setType(STTblWidth.DXA);
								tblPr4.getTblW().setW(new BigInteger("9072"));
								XWPFTableRow row4 = contractTable4.getRow(0);
								List<XWPFTableCell> tableCells4 = row4.getTableCells();
								//tableCells4.get(0).setText(String.valueOf(i));
								//设置单元格宽度
								tableCells4.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//支出项
								if (costTypeRelated.getCostTypeName() != null) {
									tableCells4.get(1).setText(costTypeRelated.getCostTypeName());
								}
								//设置单元格宽度
								tableCells4.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//成本金额
								tableCells4.get(2).setText(String.valueOf(costTypeRelated.getCost()));
								//设置单元格宽度
								tableCells4.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//已付款金额
								//tableCells4.get(3).setText(String.valueOf(costTypeRelated.getSubContractCost()));
								//设置单元格宽度
								tableCells4.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//未付款金额
								//tableCells4.get(4).setText(String.valueOf(costTypeRelated.getUnpaid()));
								//设置单元格宽度
								tableCells4.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//收款人
								tableCells4.get(5).setText(costTypeRelated.getPayee());
								//设置单元格宽度
								tableCells4.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

								//备注
//												tableCells4.get(6).setText(String.valueOf(subContractInfo.getUnpaid()));
								//设置单元格宽度
								tableCells4.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
								//设置文本居中
								tableCells4.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
								//设置垂直居中
								tableCells4.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
							}


						}
//						if (contractCostTypeRelatedListWithoutPage != null) {
//							for (ContractCostTypeRelated contractCostTypeRelated : contractCostTypeRelatedListWithoutPage) {
//								String costTypeId = contractCostTypeRelated.getCostTypeId();
//								if (costTypeId != null) {
//									String twiceStr = costTypeId.split(",")[1];
//									if(twiceStr.equals(String.valueOf(costTypeInfo.getId()))){
//										if (contractCostTypeRelated.getCost() != null) {
//
//										}
//									}
//								}
//							}
//						}
						//合同成本
						if (subContractInfoListWithoutPage != null) {
							for (SubContractInfo subContractInfo : subContractInfoListWithoutPage) {
								String costTypeId = subContractInfo.getCostTypeId();
								if (costTypeId != null) {
									String twiceStr = costTypeId.split(",")[1];
									if(twiceStr.equals(String.valueOf(costTypeInfo.getId()))){
										countCost = countCost.add(subContractInfo.getCostMoney());
									}
								}
							}
						}

						//序号增加1
						i += 1;
					}
				}

				//成本合计
				//创建表格
				XWPFTable contractTable4 = document.createTable(1,7);
				CTTblPr tblPr4 = contractTable4.getCTTbl().getTblPr();
				tblPr4.getTblW().setType(STTblWidth.DXA);
				tblPr4.getTblW().setW(new BigInteger("9072"));
				XWPFTableRow row4 = contractTable4.getRow(0);
				List<XWPFTableCell> tableCells4 = row4.getTableCells();
				tableCells4.get(0).setText("合计");
				//合并单元格
				WordServiceImpl.mergeCellsHorizontal(contractTable4,0,0,1);
				//设置单元格宽度
				tableCells4.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells4.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells4.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				//设置单元格宽度
				tableCells4.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells4.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells4.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells4.get(2).setText(String.valueOf(sumCost));
				//设置单元格宽度
				tableCells4.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells4.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells4.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells4.get(3).setText(String.valueOf(sumBack));
				//设置单元格宽度
				tableCells4.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells4.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells4.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells4.get(4).setText(String.valueOf(sumSubMoney));
				//设置单元格宽度
				tableCells4.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells4.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells4.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells4.get(5).setText("");
				WordServiceImpl.mergeCellsHorizontal(contractTable4,0,5,6);
				//设置单元格宽度
				tableCells4.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells4.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells4.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

				tableCells4.get(6).setText("");
				//设置单元格宽度
				tableCells4.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
				//设置文本居中
				tableCells4.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
				//设置垂直居中
				tableCells4.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);
			}

			//创建表格
			XWPFTable contractTable5 = document.createTable(1,7);
			CTTblPr tblPr5 = contractTable5.getCTTbl().getTblPr();
			tblPr5.getTblW().setType(STTblWidth.DXA);
			tblPr5.getTblW().setW(new BigInteger("9072"));
			XWPFTableRow row5 = contractTable5.getRow(0);
			List<XWPFTableCell> tableCells5 = row5.getTableCells();
			tableCells5.get(0).setText("该项目特殊说明");
			//合并单元格
//			for (int j = 0; j < 6; j++) {
//				WordServiceImpl.mergeCellsVertically(contractTable5,j,0,1);
//			}
			for (int j = 0; j < 1; j++) {
				WordServiceImpl.mergeCellsHorizontal(contractTable5,j,1,5);
			}
			//设置单元格宽度
			tableCells5.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells5.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells5.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			if (contractInfo.getSpecialInstructions() != null) {
				tableCells5.get(1).setText(contractInfo.getSpecialInstructions());
			}
			//设置单元格宽度
			tableCells5.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells5.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells5.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells5.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells5.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells5.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells5.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells5.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells5.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells5.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells5.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells5.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells5.get(5).setText("");
			WordServiceImpl.mergeCellsHorizontal(contractTable5,0,5,6);
			//设置单元格宽度
			tableCells5.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells5.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells5.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells5.get(6).setText("");
			//设置单元格宽度
			tableCells5.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells5.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells5.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);


			//创建表格
			XWPFTable contractTable6 = document.createTable(1,7);
			CTTblPr tblPr6 = contractTable6.getCTTbl().getTblPr();
			tblPr6.getTblW().setType(STTblWidth.DXA);
			tblPr6.getTblW().setW(new BigInteger("9072"));
			XWPFTableRow row6 = contractTable6.getRow(0);
			List<XWPFTableCell> tableCells6 = row6.getTableCells();
			tableCells6.get(0).setText("该项目质保金");
			//合并单元格
//			for (int j = 0; j < 6; j++) {
//				WordServiceImpl.mergeCellsVertically(contractTable6,j,0,1);
//			}
			for (int j = 0; j < 1; j++) {
				WordServiceImpl.mergeCellsHorizontal(contractTable6,j,1,5);
			}
			//设置单元格宽度
			tableCells6.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells6.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells6.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			if (contractInfo.getPremium() != null) {
				tableCells6.get(1).setText(contractInfo.getPremium());
			}
			//设置单元格宽度
			tableCells6.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells6.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells6.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells6.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells6.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells6.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells6.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells6.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells6.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells6.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells6.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells6.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells6.get(5).setText("");
			WordServiceImpl.mergeCellsHorizontal(contractTable6,0,5,6);
			//设置单元格宽度
			tableCells6.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells6.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells6.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells6.get(6).setText("");
			//设置单元格宽度
			tableCells6.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells6.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells6.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//创建表格
			XWPFTable contractTable7 = document.createTable(1,7);
			//自动适应
			CTTblPr tblPr7 = contractTable7.getCTTbl().getTblPr();
			tblPr7.getTblW().setType(STTblWidth.DXA);
			tblPr7.getTblW().setW(new BigInteger("9072"));
			XWPFTableRow row7 = contractTable7.getRow(0);
			List<XWPFTableCell> tableCells7 = row7.getTableCells();
			tableCells7.get(0).setText("项目结论");
			//合并单元格
//			for (int j = 0; j < 6; j++) {
//				WordServiceImpl.mergeCellsVertically(contractTable7,j,0,2);
//			}
			for (int j = 0; j < 1; j++) {
				WordServiceImpl.mergeCellsHorizontal(contractTable7,j,1,5);
			}
			//设置单元格宽度
			tableCells7.get(0).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells7.get(0).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			tableCells7.get(0).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			if (contractInfo.getConclusion() != null) {
				tableCells7.get(1).setText(contractInfo.getConclusion());
			}
			//设置单元格宽度
			tableCells7.get(1).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells7.get(1).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			tableCells7.get(1).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells7.get(2).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells7.get(2).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.BOTH);
			tableCells7.get(2).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells7.get(3).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells7.get(3).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.BOTH);
			tableCells7.get(3).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			//设置单元格宽度
			tableCells7.get(4).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells7.get(4).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.BOTH);
			tableCells7.get(4).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells7.get(5).setText("");
			WordServiceImpl.mergeCellsHorizontal(contractTable7,0,5,6);
			//设置单元格宽度
			tableCells7.get(5).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells7.get(5).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.BOTH);
			tableCells7.get(5).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);

			tableCells7.get(6).setText("");
			//设置单元格宽度
			tableCells7.get(6).getCTTc().addNewTcPr().addNewTcW().setW(BigInteger.valueOf(360*6));
			//设置文本居中
			tableCells7.get(6).getCTTc().getPList().get(0).addNewPPr().addNewJc().setVal(STJc.CENTER);
			//设置垂直居中
			tableCells7.get(6).getCTTc().addNewTcPr().addNewVAlign().setVal(STVerticalJc.CENTER);


			if (contractInfo.getItemName() != null){
				try {
					response.setHeader("content-type", "application/octet-stream");
					response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(contractInfo.getItemName()+"_报表.docx", "UTF-8"));
					document.write(response.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
				}

			}
		}

//		File tempFile = File.createTempFile("tempFile", "zip");
//		tempFile = putBatchFilesInZip(filePaths,tempFile);
//		OutputStream os = response.getOutputStream();
//		FileInputStream fis = new FileInputStream(tempFile);
//		//下载头设置。
//		try{
//			response.setHeader("content-type", "application/octet-stream");
//			response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("合同成本报表.zip", "UTF-8"));
//			int len = 0;
//			byte[] bt = new byte[5*1024];
//			while((len = fis.read(bt)) != -1) {
//				os.write(bt,0,len);
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException();
//		}finally {
//			tempFile.deleteOnExit();
//			if (filePaths != null){
//				for (String filePath : filePaths) {
//					//下载完删除
//					File file = new File(filePath);
//					if (file.exists()) {
//						file.delete();
//					}
//				}
//			}
//		}
	}

	public static File putBatchFilesInZip(List<String> filePaths,File tempFile) throws IOException {
		ZipOutputStream zos = new ZipOutputStream(tempFile);
		for(String pathFile : filePaths) {
			File inputFile = new File(pathFile);
			try(FileInputStream fis = new FileInputStream(inputFile);){
				//压缩文件中写入名称
				ZipEntry entry = new ZipEntry(inputFile.getName());
				zos.putNextEntry(entry);
				// 向压缩文件中输出数据
				int len = 0;
				byte[] bt = new byte[5*1024];
				while ((len = fis.read(bt)) != -1) {
					//压缩文件中写入真正的文件流
					zos.write(bt, 0, len);
				}

			}catch(Exception e) {
				e.printStackTrace();
				throw new RuntimeException();
			}

		}
		zos.flush();
		zos.close();
		return tempFile;
	}

	public static void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {
		for(int cellIndex = fromCell; cellIndex <= toCell; cellIndex++ ) {
			XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
			if(cellIndex == fromCell) {
				cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
			} else {
				cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
			}
		}
	}

	public static void mergeCellsVertically(XWPFTable table, int col, int fromRow, int toRow) {
		for(int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
			XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
			//第一个合并单元格用重启合并值设置
			if(rowIndex == fromRow) {
				cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
			} else {
				//合并第一个单元格的单元被设置为“继续”
				cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
			}
		}
	}
}
