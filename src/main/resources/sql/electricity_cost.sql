/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : electricity_cost

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 17/11/2020 11:39:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tbl_gb_apply_invoice
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_apply_invoice`;
CREATE TABLE `tbl_gb_apply_invoice`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请发票名称',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '发票申请日期',
  `latetime` datetime(0) NULL DEFAULT NULL COMMENT '发票开具最迟时间',
  `type` int(11) NULL DEFAULT NULL COMMENT '1 专票  2 普票',
  `money` decimal(20, 0) NULL DEFAULT NULL COMMENT '申请开票金额',
  `note` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请开票备注',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同主键',
  `money_back_id` bigint(11) NULL DEFAULT NULL COMMENT '回款主键',
  `status` int(11) NULL DEFAULT NULL COMMENT '状态 0 删除 1 正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '申请开票信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_apply_invoice
-- ----------------------------
INSERT INTO `tbl_gb_apply_invoice` VALUES (1, '大票', NULL, NULL, 1, 100, NULL, 17, 13, 1);
INSERT INTO `tbl_gb_apply_invoice` VALUES (2, 'xxx', NULL, NULL, 1, 111, NULL, 17, 11, 1);
INSERT INTO `tbl_gb_apply_invoice` VALUES (3, '123', '2020-01-11 00:00:00', '2020-01-13 00:00:00', 1, 100, 'asdf', 32, NULL, 1);
INSERT INTO `tbl_gb_apply_invoice` VALUES (4, '123', '2020-01-11 00:00:00', '2020-01-13 00:00:00', 1, 100, 'asdf', 32, NULL, 1);
INSERT INTO `tbl_gb_apply_invoice` VALUES (5, '123', '2020-01-11 00:00:00', '2020-01-11 00:00:00', 1, 321, '321', 32, 15, 0);
INSERT INTO `tbl_gb_apply_invoice` VALUES (6, '123', '2020-01-11 00:00:00', '2020-01-11 00:00:00', 1, 321, '132', 32, NULL, 1);
INSERT INTO `tbl_gb_apply_invoice` VALUES (7, '321412', '2020-01-11 00:00:00', '2020-01-11 00:00:00', 1, 432, '432', 32, 14, 0);
INSERT INTO `tbl_gb_apply_invoice` VALUES (8, 'rewq', '2020-01-13 00:00:00', '2020-01-13 00:00:00', 2, 2340, '234', 32, NULL, 0);
INSERT INTO `tbl_gb_apply_invoice` VALUES (9, '1', '2020-11-12 00:00:00', '2020-11-12 00:00:00', 1, 1, '1', 36, 16, 1);

-- ----------------------------
-- Table structure for tbl_gb_apply_invoice_enclosure_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_apply_invoice_enclosure_info`;
CREATE TABLE `tbl_gb_apply_invoice_enclosure_info`  (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `file_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件路径',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `apply_invoice_id` bigint(20) NULL DEFAULT NULL COMMENT '开票申请主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '申请开票附件表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_apply_invoice_enclosure_info
-- ----------------------------
INSERT INTO `tbl_gb_apply_invoice_enclosure_info` VALUES (1, 'D:/uploads/20200111/0351c47b5a424205a499a98f25dfd2c6.jpeg', '2020-01-11 16:21:06', 4);
INSERT INTO `tbl_gb_apply_invoice_enclosure_info` VALUES (2, 'D:/uploads/20200111/f956eed934444817a90c0a507b1faebe.jpeg', '2020-01-11 16:21:06', 4);
INSERT INTO `tbl_gb_apply_invoice_enclosure_info` VALUES (3, 'F:/electricity_cost/uploads/20201112/6bba7e605f9a4624ad735120911a8ff9.jpeg', '2020-11-12 17:30:56', 9);

-- ----------------------------
-- Table structure for tbl_gb_contract_adjust
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_contract_adjust`;
CREATE TABLE `tbl_gb_contract_adjust`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同主键',
  `before_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '调整前金额',
  `money` decimal(18, 2) NULL DEFAULT NULL COMMENT '调整金额',
  `after_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '调整后金额',
  `status` int(1) NULL DEFAULT NULL COMMENT '调整状态0减1加',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '调整时间',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '变动原因',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 156 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '合同金额变动信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_contract_adjust
-- ----------------------------
INSERT INTO `tbl_gb_contract_adjust` VALUES (153, 4, 2722800.00, 20000.00, 2742800.00, 1, '2020-07-10 11:39:42', '');
INSERT INTO `tbl_gb_contract_adjust` VALUES (154, 1, 234160.00, 5000.00, 229160.00, 0, '2020-07-10 11:39:52', '');
INSERT INTO `tbl_gb_contract_adjust` VALUES (155, 34, 111.00, 4110.00, 4221.00, 1, '2020-07-15 14:48:52', '1');

-- ----------------------------
-- Table structure for tbl_gb_contract_cost_type_related
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_contract_cost_type_related`;
CREATE TABLE `tbl_gb_contract_cost_type_related`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同标识',
  `cost_type_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成本类型标识',
  `cost` decimal(18, 2) NULL DEFAULT NULL COMMENT '成本金额',
  `payee` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款人',
  `payee_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款人电话',
  `is_pay` int(1) NULL DEFAULT NULL COMMENT '是否支付',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `note` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_enable` int(1) NULL DEFAULT 1 COMMENT '状态：\r\n1：正常\r\n0：已删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '成本表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_contract_cost_type_related
-- ----------------------------
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (1, 1, '1,2,7,8', 2.00, '2', '21', NULL, NULL, '2', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (2, 1, '1,2,7,8', 213.00, '3213', '12321', NULL, NULL, '321321', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (3, 1, '1,3', 12.00, '12', '12', NULL, NULL, '12', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (4, 1, '1,2,7,8', 11.00, '11', '11', NULL, NULL, '11', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (5, 2, '1,3', 22.00, '2', '2', NULL, NULL, '2', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (6, 1, '1,10', 1.00, '1', '1', NULL, NULL, '1', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (7, 1, '1,10', 111.00, '11', '11', NULL, NULL, '11', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (8, 1, '1,10', 11.00, '2', '2', NULL, NULL, '', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (9, 3, '1,3', 100.00, '王五', '13112345678', NULL, NULL, '无', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (10, -1, '1,2', 1000.00, '马德华', '13112345562', NULL, NULL, '无', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (11, 32, '1,9', 200.00, '444', '4444', 1, '2020-06-28 00:00:00', '444444', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (12, 36, '1,2', 1.00, '1', '1', 1, '2020-09-09 00:00:00', '1', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (13, 36, '1,2', 12.00, '1', '1', 1, '2020-09-09 00:00:00', '1', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (14, 36, '1,3', 2.00, '2', '2', 1, '2020-09-09 00:00:00', '2', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (15, 36, '1,9', 1.00, '1', '1', 1, '2020-09-17 00:00:00', '1', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (16, 36, '1,9', 2.00, '2', '2', 1, '2020-09-09 00:00:00', '2', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (17, 36, '1,9', 2.00, '2', '2', 1, '2020-09-10 00:00:00', '2', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (18, 36, '1,3', 2222.00, '222', '222', 1, '2020-09-09 00:00:00', '2', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (19, 36, '1,2,7,8', 2.00, '2', '2', 1, '2020-09-09 00:00:00', '2', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (20, 36, '1,10', 2222.00, '2', '2', 1, '2020-09-09 00:00:00', '', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (21, 36, '1,10', 1.00, '1', '1', 1, '2020-09-09 00:00:00', '1', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (22, 36, '1,9', 1.00, '1', '1', 1, '2020-09-09 00:00:00', '1', 1);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (23, 36, '1,9', 1.00, '1', '1', 1, '2020-09-18 00:00:00', '1', 0);
INSERT INTO `tbl_gb_contract_cost_type_related` VALUES (24, 36, '1,9', 1.00, '1', '1', 1, '2020-09-17 00:00:00', '1', 1);

-- ----------------------------
-- Table structure for tbl_gb_contract_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_contract_info`;
CREATE TABLE `tbl_gb_contract_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '合同主键',
  `contract_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同名称',
  `contract_num` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '合同编号',
  `item_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `item_manager` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目经理',
  `customer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户姓名',
  `company` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户单位',
  `customer_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户电话',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modified_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `creator` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `last_modifier` bigint(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `contract_cost` decimal(18, 2) NULL DEFAULT NULL COMMENT '合同总成本',
  `contract_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '合同金额',
  `special_instructions` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '特殊说明',
  `premium` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '质保金说明',
  `conclusion` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '结论',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态\r\n1：未完成\r\n2：已完成\r\n0：已删除',
  `signing_time` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '签约日期',
  `type` int(1) NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '合同信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_contract_info
-- ----------------------------
INSERT INTO `tbl_gb_contract_info` VALUES (1, '1111', '1111', '111', '322', '111', '111', '111', '2019-12-12 13:42:19', '2019-12-12 13:42:19', NULL, NULL, NULL, 111.00, '111', '111', '111', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (2, '222', '222', '22', '32', '222', '22', '222', '2019-12-12 13:45:09', '2019-12-12 13:45:09', NULL, NULL, NULL, 222.00, '222', '22', '222', 2, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (3, '游乐场一期', '243324342432234', '游乐场一期', '23', '马德华', '盛大有限公司', '13112345678', '2019-12-23 11:27:38', '2019-12-23 11:27:38', 1, 1, NULL, 10000.00, '无', '无', '无', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (4, '1111', '1111', '1111', '1234', '1111', '1111', '13833678965', '2019-12-25 17:10:44', '2019-12-25 17:10:44', 1, 1, NULL, 100.00, '2222', '222', '2222', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (5, '1234', '1324', '1234', '123', '234', '234', '13112345672', '2020-01-02 18:03:01', '2020-01-02 18:03:01', 1, 1, NULL, 2143.00, NULL, NULL, NULL, 2, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (6, '34234', '99999', '234234', '56765755', '234', '34234', NULL, '2020-01-02 20:28:48', '2020-01-02 20:28:48', 1, 1, NULL, 3442.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (7, '1234123', '1231234', '23424', NULL, '1234', '2341', NULL, '2020-01-02 20:31:16', '2020-01-02 20:31:18', 1, 1, NULL, 234.00, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (8, '13', '231', '3121', '123', '123', '123', '', '2020-01-02 20:37:44', '2020-01-02 20:37:44', 1, 1, NULL, 123.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (9, '供奉的是', '453', '热狗', '个人给', '给热狗', '过热', '', '2020-01-02 20:38:17', '2020-01-02 20:38:17', 1, 1, NULL, 4345.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (10, '6578', '678567', '5678', '6785', '678', '6578', '', '2020-01-02 20:39:12', '2020-01-02 20:39:12', 1, 1, NULL, 678.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (11, '6578', '678567', '5678', '6785', '678', '6578', '', '2020-01-02 20:40:03', '2020-01-02 20:40:03', 1, 1, NULL, 678.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (12, '6578', '678567', '5678', '6785', '678', '6578', '', '2020-01-02 20:40:04', '2020-01-02 20:40:04', 1, 1, NULL, 678.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (13, '6578', '678567', '5678', '6785', '678', '6578', '', '2020-01-02 20:40:05', '2020-01-02 20:40:05', 1, 1, NULL, 678.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (14, '1234', '1234', '1234', '11234', '23431', '1234', '', '2020-01-02 20:41:19', '2020-01-02 20:41:19', 1, 1, NULL, 1234.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (15, '1234', '1234', '1234', '11234', '23431', '1234', '', '2020-01-02 20:41:40', '2020-01-02 20:41:41', 1, 1, NULL, 1234.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (16, '2134', '44324', '2134', 'dfghfd1235', '12341', '1234', '', '2020-01-02 20:44:20', '2020-01-02 20:44:20', 1, 1, NULL, 234.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (17, '供奉的是', '45334232sd', '热狗123', '个人给', '给热狗', '过热', '', '2020-01-03 08:56:27', '2020-01-03 08:56:27', 1, 1, NULL, 4345.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (18, '123', '1231', '123', '123', '321', '123', NULL, '2020-01-11 14:33:38', '2020-01-11 14:33:38', 1, 1, NULL, 213.00, '321', '312', '321', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (19, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-11 14:45:39', '2020-01-11 14:45:39', 1, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (20, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-11 14:48:31', '2020-01-11 14:48:31', 1, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (21, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-11 14:49:07', '2020-01-11 14:49:07', 1, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (22, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2020-01-11 14:51:01', '2020-01-11 14:51:01', 1, 1, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (23, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (24, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (25, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (26, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (27, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (28, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (29, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (30, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (31, '34r43r43', 'r4343r3', '34r43r3', '34r34r3', '43r4343r', '34r43r43r', '', '2020-01-11 14:58:02', '2020-01-11 14:58:02', 1, 1, NULL, 33434.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (32, '21341', '14321', '1234', '1234', '', '', '', '2020-01-11 15:04:41', '2020-01-11 15:04:41', 1, 1, NULL, 1234.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (33, 'dasda', 'asdas', 'dasdas', 'dasd', 'asdasdas', 'asdasd', '18731788888', '2020-07-13 10:53:53', '2020-07-13 10:53:53', 1, 1, NULL, 100000.00, 'sdasd', 'asdasdasdasd', 'asdasdasd', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (34, 'qweqwe12', '11123qwe', '12weqwewq', '', '', '', '', '2020-07-15 14:47:46', '2020-07-15 14:47:46', 1, 1, NULL, 4221.00, '', '', '', 1, NULL, NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (35, '飞机附件二', '1237617236731', '分解减肥', '', '', '', '', '2020-07-30 16:01:25', '2020-07-30 16:01:25', 1, 1, NULL, 100.00, '', '', '', 1, '2020', NULL);
INSERT INTO `tbl_gb_contract_info` VALUES (36, '1321321', '123213', '123213', '123213', '123213', '213213', '', '2020-08-03 13:37:18', '2020-08-03 13:37:18', 1, 1, NULL, 100.00, '', '', '', 1, '2020', NULL);

-- ----------------------------
-- Table structure for tbl_gb_contract_type
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_contract_type`;
CREATE TABLE `tbl_gb_contract_type`  (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `status` int(1) NULL DEFAULT NULL COMMENT '0删除 1正常',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '合同类型' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_contract_type
-- ----------------------------
INSERT INTO `tbl_gb_contract_type` VALUES (1, '施工半不施工的（肯定收不回款的）', 1);
INSERT INTO `tbl_gb_contract_type` VALUES (2, '起诉', 1);
INSERT INTO `tbl_gb_contract_type` VALUES (3, '正常催款', 0);
INSERT INTO `tbl_gb_contract_type` VALUES (5, '1', 0);
INSERT INTO `tbl_gb_contract_type` VALUES (6, '1', 0);
INSERT INTO `tbl_gb_contract_type` VALUES (7, '1', 1);
INSERT INTO `tbl_gb_contract_type` VALUES (8, '1', 0);
INSERT INTO `tbl_gb_contract_type` VALUES (9, '1', 0);
INSERT INTO `tbl_gb_contract_type` VALUES (10, '2', 0);

-- ----------------------------
-- Table structure for tbl_gb_cost_type_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_cost_type_info`;
CREATE TABLE `tbl_gb_cost_type_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '成本分类主键',
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成本分类名称',
  `p_id` bigint(20) NULL DEFAULT NULL COMMENT '成本分类父标识',
  `is_enable` int(1) NULL DEFAULT 1 COMMENT '成本分类状态\r\n1：启用\r\n0：禁用',
  `sort` bigint(20) NULL DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '成本分类表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_cost_type_info
-- ----------------------------
INSERT INTO `tbl_gb_cost_type_info` VALUES (1, '所有', 0, 1, 1);
INSERT INTO `tbl_gb_cost_type_info` VALUES (2, '差旅费', 1, 1, 2);
INSERT INTO `tbl_gb_cost_type_info` VALUES (3, '饭费', 1, 1, 2);
INSERT INTO `tbl_gb_cost_type_info` VALUES (4, '差旅1', 2, 0, 3);
INSERT INTO `tbl_gb_cost_type_info` VALUES (5, '差旅11', 4, 0, 4);
INSERT INTO `tbl_gb_cost_type_info` VALUES (6, '差旅111', 5, 0, 5);
INSERT INTO `tbl_gb_cost_type_info` VALUES (7, '差旅1', 2, 1, 3);
INSERT INTO `tbl_gb_cost_type_info` VALUES (8, '差旅11', 7, 1, 4);
INSERT INTO `tbl_gb_cost_type_info` VALUES (9, '部门1', 1, 1, 2);
INSERT INTO `tbl_gb_cost_type_info` VALUES (10, '11', 1, 1, 4);
INSERT INTO `tbl_gb_cost_type_info` VALUES (11, '88888', 1, 1, 2);

-- ----------------------------
-- Table structure for tbl_gb_enclosure_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_enclosure_info`;
CREATE TABLE `tbl_gb_enclosure_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '附件主键',
  `file_path` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件路径',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '附件表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_enclosure_info
-- ----------------------------
INSERT INTO `tbl_gb_enclosure_info` VALUES (1, 'D:/uploads/20191223/39d05b58abd34cbeb830883505707a01.jpeg', '2019-12-23 11:27:38', 3);
INSERT INTO `tbl_gb_enclosure_info` VALUES (2, 'D:/uploads/20191225/64407fb4f2b14ae193ba1d99a057544f.msword', '2019-12-25 17:10:44', 4);
INSERT INTO `tbl_gb_enclosure_info` VALUES (3, 'null', '2020-07-30 16:01:25', 35);
INSERT INTO `tbl_gb_enclosure_info` VALUES (4, 'D:/uploads/20200803/7d4845b8efc34830a73d99a25a7ab9f9.pdf', '2020-08-03 13:37:18', 36);

-- ----------------------------
-- Table structure for tbl_gb_invoice_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_invoice_info`;
CREATE TABLE `tbl_gb_invoice_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ti_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纳税人识别号',
  `account_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户名称',
  `public_account_num` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对公账号',
  `opening_bank` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户行',
  `place_of_opening` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开户地点',
  `mailing_addr` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票邮寄地址',
  `contact_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人姓名',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '发票信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_invoice_info
-- ----------------------------
INSERT INTO `tbl_gb_invoice_info` VALUES (1, '111', '111', '111', '111', '111', '111', '1', '11', 1);
INSERT INTO `tbl_gb_invoice_info` VALUES (2, '22222', '222', '2', '2', '2', '2', '2', '2', 2);
INSERT INTO `tbl_gb_invoice_info` VALUES (3, '3247823743834', '马德华', '234324384284', '建行', '廊坊', '廊坊', '李斯', '13213424332', 3);
INSERT INTO `tbl_gb_invoice_info` VALUES (4, '', '', '', '', '', '', '', '', 4);
INSERT INTO `tbl_gb_invoice_info` VALUES (5, '', '', '', '', '', '', '', '', 5);
INSERT INTO `tbl_gb_invoice_info` VALUES (6, '', '', '', '', '', '', '', '5654', 6);
INSERT INTO `tbl_gb_invoice_info` VALUES (7, '', '', '', '', '', '', '', '', 7);
INSERT INTO `tbl_gb_invoice_info` VALUES (8, '', '', '', '', '', '', '', '', 16);
INSERT INTO `tbl_gb_invoice_info` VALUES (9, '63432432', '3465asfd', '34asfd', '63436afsd', '365346fdsa', '346535fdsa', '4563asfd', '15112345671', 17);
INSERT INTO `tbl_gb_invoice_info` VALUES (10, '', '', '', '', '', '', '', '', 18);
INSERT INTO `tbl_gb_invoice_info` VALUES (11, '', '', '', '', '', '', '', '', 19);
INSERT INTO `tbl_gb_invoice_info` VALUES (12, '', '', '', '', '', '', '', '', 21);
INSERT INTO `tbl_gb_invoice_info` VALUES (13, '', '', '', '', '', '', '', '', 22);
INSERT INTO `tbl_gb_invoice_info` VALUES (14, '', '', '', '', '', '', '', '', 23);
INSERT INTO `tbl_gb_invoice_info` VALUES (15, '', '', '', '', '', '', '', '', 24);
INSERT INTO `tbl_gb_invoice_info` VALUES (16, '', '', '', '', '', '', '', '', 29);
INSERT INTO `tbl_gb_invoice_info` VALUES (17, '', '', '', '', '', '', '', '', 27);
INSERT INTO `tbl_gb_invoice_info` VALUES (18, '', '', '', '', '', '', '', '', 28);
INSERT INTO `tbl_gb_invoice_info` VALUES (19, '', '', '', '', '', '', '', '', 30);
INSERT INTO `tbl_gb_invoice_info` VALUES (20, '', '', '', '', '', '', '', '', 25);
INSERT INTO `tbl_gb_invoice_info` VALUES (21, '', '', '', '', '', '', '', '', 26);
INSERT INTO `tbl_gb_invoice_info` VALUES (22, '', '', '', '', '', '', '', '', 31);

-- ----------------------------
-- Table structure for tbl_gb_item_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_item_info`;
CREATE TABLE `tbl_gb_item_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目主键',
  `item_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目名称',
  `item_num` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目编号',
  `is_enable` int(1) NULL DEFAULT 1 COMMENT '项目状态\r\n1：启用\r\n0：禁用',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_modified_time` datetime(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `creator` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `last_modifier` bigint(20) NULL DEFAULT NULL COMMENT '最后修改人',
  `item_cost` decimal(18, 2) NULL DEFAULT NULL COMMENT '项目总成本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '项目信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_item_info
-- ----------------------------
INSERT INTO `tbl_gb_item_info` VALUES (1, NULL, NULL, 0, NULL, '2019-12-05 14:33:21', NULL, NULL, NULL);
INSERT INTO `tbl_gb_item_info` VALUES (2, NULL, NULL, 0, NULL, '2019-12-05 14:34:01', NULL, NULL, NULL);
INSERT INTO `tbl_gb_item_info` VALUES (3, '项目1', '4444', NULL, NULL, '2019-12-06 10:04:03', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for tbl_gb_maintain_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_maintain_info`;
CREATE TABLE `tbl_gb_maintain_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护名称',
  `money` decimal(18, 2) NULL DEFAULT NULL COMMENT '维护金额',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同主键',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态：0删除 1未处理 2已处理',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '后期维护表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_maintain_info
-- ----------------------------
INSERT INTO `tbl_gb_maintain_info` VALUES (1, '服务器', 3000.00, '2020-07-30 00:00:00', '2020-07-30 00:00:00', '2020-06-30 14:43:41', 32, '张童', 2);
INSERT INTO `tbl_gb_maintain_info` VALUES (2, '2121', 1221.00, '2020-06-30 00:00:00', '2020-06-30 00:00:00', '2020-06-30 15:00:42', 32, '1221', 0);
INSERT INTO `tbl_gb_maintain_info` VALUES (3, '域名', 1000.00, '2020-06-30 00:00:00', '2020-06-30 00:00:00', '2020-06-30 15:13:14', 23, 'www.baidu,com', 2);
INSERT INTO `tbl_gb_maintain_info` VALUES (4, '11', 11.00, '2020-06-30 00:00:00', '2020-06-30 00:00:00', '2020-06-30 15:34:28', 32, '', 0);
INSERT INTO `tbl_gb_maintain_info` VALUES (5, '22', 22.00, '2020-06-30 00:00:00', '2020-06-30 00:00:00', '2020-06-30 15:34:35', 32, '', 0);
INSERT INTO `tbl_gb_maintain_info` VALUES (6, '服务器', 2000.00, '2020-06-22 00:00:00', '2020-07-16 00:00:00', '2020-06-30 17:14:43', 32, '', 2);
INSERT INTO `tbl_gb_maintain_info` VALUES (7, '服务器', 1000.00, '2020-05-01 00:00:00', '2020-07-08 00:00:00', '2020-07-15 14:58:32', 34, '', 1);
INSERT INTO `tbl_gb_maintain_info` VALUES (8, '数据库', 1000.00, '2020-06-04 00:00:00', '2020-08-01 00:00:00', '2020-07-15 14:59:05', 34, '', 1);

-- ----------------------------
-- Table structure for tbl_gb_money_back_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_money_back_info`;
CREATE TABLE `tbl_gb_money_back_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `money` decimal(18, 2) NULL DEFAULT NULL COMMENT '回款金额',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同标识',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `has_invoice` int(1) NULL DEFAULT NULL COMMENT '是否有发票\r\n1：有\r\n0：无',
  `invoice_type` int(1) NULL DEFAULT NULL COMMENT '发票类型：1.专票 2.普票',
  `arrival_money` datetime(0) NULL DEFAULT NULL COMMENT '到款时间',
  `creator` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `invaice_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票备注',
  `status` int(1) NULL DEFAULT NULL COMMENT '发票状态:1.使用 2.删除',
  `certificate_number` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '凭证号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '回款表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_money_back_info
-- ----------------------------
INSERT INTO `tbl_gb_money_back_info` VALUES (1, 20.00, 1, '2019-12-17 16:14:14', 1, NULL, '2019-12-17 00:00:00', NULL, NULL, NULL, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (2, 1000.00, 3, '2019-12-23 11:28:35', 1, NULL, '2019-12-23 00:00:00', 1, NULL, NULL, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (3, 10.00, 17, '2020-01-11 09:10:59', 1, NULL, '2020-01-11 00:00:00', 1, NULL, 2, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (4, 1111.00, 17, '2020-01-11 10:48:41', 1, 2, '2020-01-11 00:00:00', 1, NULL, 2, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (5, 100.00, 17, '2020-01-11 10:50:06', 1, 1, NULL, 1, '11212', 2, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (6, 321.00, 17, '2020-01-11 10:53:05', 1, 1, '2020-01-11 00:00:00', 1, '111', 2, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (7, 100.00, 17, '2020-01-11 10:55:01', 1, 2, '2020-01-11 00:00:00', 1, '211', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (8, 1000.00, 17, '2020-01-11 13:57:50', 1, 1, '2020-01-11 00:00:00', 1, '111', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (9, 1000.00, 17, '2020-01-11 13:58:57', 1, 1, '2020-01-11 00:00:00', 1, '111', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (10, 100.00, 17, '2020-01-11 14:34:03', 1, 1, '2020-01-11 00:00:00', 1, '123', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (11, 111.00, 17, '2020-01-11 16:22:49', 1, 1, NULL, 1, 'awdqwe', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (12, 100.00, 17, '2020-01-11 16:40:20', 1, 1, '2020-01-11 00:00:00', 1, '11111111111', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (13, 111.00, 17, '2020-01-11 16:45:47', 1, 1, '2020-01-11 00:00:00', 1, '77777777777', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (14, 100.00, 32, '2020-01-11 17:15:11', 1, 1, '2020-01-11 00:00:00', 1, '11``````````', 2, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (15, 321.00, 32, '2020-01-11 17:17:20', 1, 1, '2020-01-11 00:00:00', 1, '11111111111111111111111', 1, NULL);
INSERT INTO `tbl_gb_money_back_info` VALUES (16, 1.00, 36, '2020-11-12 17:34:09', 1, 1, '2020-11-12 00:00:00', 1, '1', 1, NULL);

-- ----------------------------
-- Table structure for tbl_gb_permission_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_permission_info`;
CREATE TABLE `tbl_gb_permission_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限主键',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
  `perm` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `p_id` bigint(20) NULL DEFAULT NULL COMMENT '权限父标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_permission_info
-- ----------------------------
INSERT INTO `tbl_gb_permission_info` VALUES (1, '管理员管理', 'manager:view', 0);
INSERT INTO `tbl_gb_permission_info` VALUES (2, '用户管理', 'manager:user:view', 1);
INSERT INTO `tbl_gb_permission_info` VALUES (3, '用户添加', 'manager:user:add', 2);
INSERT INTO `tbl_gb_permission_info` VALUES (4, '用户编辑', 'manager:user:edit', 2);
INSERT INTO `tbl_gb_permission_info` VALUES (5, '用户删除', 'manager:user:delete', 2);
INSERT INTO `tbl_gb_permission_info` VALUES (6, '重置密码', 'manager:user:reset', 2);
INSERT INTO `tbl_gb_permission_info` VALUES (7, '角色管理', 'manager:role:view', 1);
INSERT INTO `tbl_gb_permission_info` VALUES (8, '角色添加', 'manager:role:add', 7);
INSERT INTO `tbl_gb_permission_info` VALUES (9, '角色编辑', 'manager:role:edit', 7);
INSERT INTO `tbl_gb_permission_info` VALUES (10, '角色删除', 'manager:role:delete', 7);
INSERT INTO `tbl_gb_permission_info` VALUES (11, '权限管理', 'manager:permission:view', 1);
INSERT INTO `tbl_gb_permission_info` VALUES (12, '系统管理', 'system:view', 0);
INSERT INTO `tbl_gb_permission_info` VALUES (13, '成本分类管理', 'system:type:view', 12);
INSERT INTO `tbl_gb_permission_info` VALUES (14, '合同成本管理', 'contractcost:view', 0);
INSERT INTO `tbl_gb_permission_info` VALUES (15, '合同成本', 'contractcost:contract:view', 14);
INSERT INTO `tbl_gb_permission_info` VALUES (16, '合同添加', 'contractcost:contract:add', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (17, '合同批量删除', 'contractcost:contract:batchdelete', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (18, '合同导出报表', 'contractcost:contract:export', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (19, '合同详情', 'contractcost:contract:details:view', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (20, '回款', 'contractcost:contract:back:view', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (21, '成本', 'contractcost:contract:cost:view', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (22, '修改合同详情', 'contractcost:contract:details:edit', 19);
INSERT INTO `tbl_gb_permission_info` VALUES (23, '合同附件下载', 'contractcost:contract:details:download', 19);
INSERT INTO `tbl_gb_permission_info` VALUES (24, '合同回款添加', 'contractcost:contract:back:add', 20);
INSERT INTO `tbl_gb_permission_info` VALUES (25, '合同回款编辑', 'contractcost:contract:back:edit', 20);
INSERT INTO `tbl_gb_permission_info` VALUES (26, '添加成本合同', 'contractcost:contract:cost:subcontract:add', 42);
INSERT INTO `tbl_gb_permission_info` VALUES (27, '批量删除成本合同', 'contractcost:contract:cost:subcontract:batchDelete', 42);
INSERT INTO `tbl_gb_permission_info` VALUES (28, '成本合同明细', 'contractcost:contract:cost:subcontract:details:view', 42);
INSERT INTO `tbl_gb_permission_info` VALUES (29, '成本合同添加付款', 'contractcost:contract:cost:subcontract:addPay', 42);
INSERT INTO `tbl_gb_permission_info` VALUES (30, '删除成本合同', 'contractcost:contract:cost:subcontract:delete', 42);
INSERT INTO `tbl_gb_permission_info` VALUES (31, '其他成本批量删除', 'contractcost:contract:cost:othercost:batchDelete', 43);
INSERT INTO `tbl_gb_permission_info` VALUES (32, '其他成本添加', 'contractcost:contract:cost:othercost:add', 43);
INSERT INTO `tbl_gb_permission_info` VALUES (33, '其他成本编辑', 'contractcost:contract:cost:othercost:edit', 43);
INSERT INTO `tbl_gb_permission_info` VALUES (34, '其他成本删除', 'contractcost:contract:cost:othercost:delete', 43);
INSERT INTO `tbl_gb_permission_info` VALUES (35, '成本合同明细修改', 'contractcost:contract:cost:subcontract:details:edit', 28);
INSERT INTO `tbl_gb_permission_info` VALUES (36, '成本合同附件下载', 'contractcost:contract:cost:subcontract:details:download', 28);
INSERT INTO `tbl_gb_permission_info` VALUES (37, '成本合同修改付款', 'contractcost:contract:cost:subcontract:editPay', 28);
INSERT INTO `tbl_gb_permission_info` VALUES (38, '成本合同删除付款', 'contractcost:contract:cost:subcontract:deletePay', 28);
INSERT INTO `tbl_gb_permission_info` VALUES (39, '成本合同添加回票', 'contractcost:contract:cost:subcontract:addReturnTicket', 42);
INSERT INTO `tbl_gb_permission_info` VALUES (40, '成本合同修改回票', 'contractcost:contract:cost:subcontract:editReturnTicket', 28);
INSERT INTO `tbl_gb_permission_info` VALUES (41, '成本合同删除回票', 'contractcost:contract:cost:subcontract:deleteReturnTicket', 28);
INSERT INTO `tbl_gb_permission_info` VALUES (42, '成本合同管理', 'contractcost:contract:cost:subcontract:view', 21);
INSERT INTO `tbl_gb_permission_info` VALUES (43, '其他成本管理', 'contractcost:contract:cost:othercost:view', 21);
INSERT INTO `tbl_gb_permission_info` VALUES (44, '申请开票', 'contractcost:contract:apply:add', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (45, '申请开票下载附件', 'contractcost:contract:apply:download', 19);
INSERT INTO `tbl_gb_permission_info` VALUES (46, '编辑申请开票', 'contractcost:contract:apply:edit', 19);
INSERT INTO `tbl_gb_permission_info` VALUES (47, '删除申请开票', 'contractcost:contract:apply:delete', 19);
INSERT INTO `tbl_gb_permission_info` VALUES (48, '合同回款删除', 'contractcost:contract:back:delete', 20);
INSERT INTO `tbl_gb_permission_info` VALUES (49, '合同分类管理', 'system:contracttype:view', 12);
INSERT INTO `tbl_gb_permission_info` VALUES (50, '调整', 'contractcost:contract:adjustment:view', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (51, '调整添加', 'contractcost:contract:adjustment:add', 50);
INSERT INTO `tbl_gb_permission_info` VALUES (52, '导出发票统计', 'contractcost:contract:invoice:export', 55);
INSERT INTO `tbl_gb_permission_info` VALUES (53, '导出未收款项目对账表', 'contractcost:contractInfo:export', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (54, '导出合同汇总表', 'contractcost:contract:summary', 15);
INSERT INTO `tbl_gb_permission_info` VALUES (55, '发票统计', 'contractcost:invoice:view', 14);

-- ----------------------------
-- Table structure for tbl_gb_person_cost
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_person_cost`;
CREATE TABLE `tbl_gb_person_cost`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '人员名称',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同主键',
  `cost_type_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成本类型主键字符串',
  `start_time` datetime(0) NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime(0) NULL DEFAULT NULL COMMENT '结束时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `cost` decimal(18, 2) NULL DEFAULT NULL COMMENT '成本金额',
  `is_pay` int(1) NULL DEFAULT NULL COMMENT '是否付款：1 已付款 0 未付款',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_enable` int(1) NULL DEFAULT 1 COMMENT '状态\r\n1：存在\r\n0：删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '人员成本表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_person_cost
-- ----------------------------
INSERT INTO `tbl_gb_person_cost` VALUES (1, '服务器', 32, '1,5', '2020-06-30 00:00:00', '2020-06-30 00:00:00', '2020-06-29 14:02:04', 20.00, 1, '张童', 0);
INSERT INTO `tbl_gb_person_cost` VALUES (2, '张童', 32, '1,10', '2020-06-29 00:00:00', '2020-06-29 00:00:00', '2020-06-29 00:00:00', 2000.00, 1, '商城', 1);
INSERT INTO `tbl_gb_person_cost` VALUES (3, '郭晓东', 32, '1,3', '2020-06-29 00:00:00', '2020-06-29 00:00:00', '2020-06-29 00:00:00', 1000.00, 1, '商城', 1);
INSERT INTO `tbl_gb_person_cost` VALUES (4, '111', 36, '1,11', '2020-09-09 00:00:00', '2020-09-09 00:00:00', '2020-09-09 00:00:00', 11.00, 1, '1', 1);

-- ----------------------------
-- Table structure for tbl_gb_return_ticket_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_return_ticket_info`;
CREATE TABLE `tbl_gb_return_ticket_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `money` decimal(18, 2) NULL DEFAULT NULL COMMENT '回票金额',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '回票时间',
  `ticket_holder` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回票人',
  `note` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `sub_contract_id` bigint(20) NULL DEFAULT NULL COMMENT '成本合同主键',
  `is_enable` int(1) NULL DEFAULT 1 COMMENT '是否启用\r\n1 启用\r\n0 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '回票信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_return_ticket_info
-- ----------------------------
INSERT INTO `tbl_gb_return_ticket_info` VALUES (1, 111.00, '2019-12-19 00:00:00', '1', '3', 1, 0);
INSERT INTO `tbl_gb_return_ticket_info` VALUES (2, 2.00, '2019-12-19 00:00:00', '2', '2', 1, 0);
INSERT INTO `tbl_gb_return_ticket_info` VALUES (3, 122121.00, '2019-12-19 00:00:00', '212', '121212', 1, 1);
INSERT INTO `tbl_gb_return_ticket_info` VALUES (4, 1.00, '2019-12-19 00:00:00', '1', '1', 1, 1);
INSERT INTO `tbl_gb_return_ticket_info` VALUES (5, 1000.00, '2020-01-11 00:00:00', '大地', '123', 12, 1);
INSERT INTO `tbl_gb_return_ticket_info` VALUES (6, 123.00, '2020-07-01 00:00:00', '111', '', 14, 1);
INSERT INTO `tbl_gb_return_ticket_info` VALUES (7, 11.00, '2020-11-12 00:00:00', '11', '11', 21, 1);

-- ----------------------------
-- Table structure for tbl_gb_role_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_role_info`;
CREATE TABLE `tbl_gb_role_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `role_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `role_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `creator` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `is_enable` int(1) NULL DEFAULT 1 COMMENT '用户状态\r\n1：启用\r\n0：禁用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_role_info
-- ----------------------------
INSERT INTO `tbl_gb_role_info` VALUES (1, '角色1', '角色1', '2019-12-17 10:45:23', 1, 1);
INSERT INTO `tbl_gb_role_info` VALUES (2, '橘色2', '啊啊啊啊啊啊啊啊重中之重作者', '2019-12-17 11:32:44', 1, 0);
INSERT INTO `tbl_gb_role_info` VALUES (3, '角色2', '', '2019-12-17 13:58:45', 1, 1);

-- ----------------------------
-- Table structure for tbl_gb_role_perm_related
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_role_perm_related`;
CREATE TABLE `tbl_gb_role_perm_related`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色主键',
  `perm_id` bigint(20) NULL DEFAULT NULL COMMENT '权限主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 584 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和权限中间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_role_perm_related
-- ----------------------------
INSERT INTO `tbl_gb_role_perm_related` VALUES (13, 2, 1);
INSERT INTO `tbl_gb_role_perm_related` VALUES (14, 2, 2);
INSERT INTO `tbl_gb_role_perm_related` VALUES (15, 2, 3);
INSERT INTO `tbl_gb_role_perm_related` VALUES (139, 3, 14);
INSERT INTO `tbl_gb_role_perm_related` VALUES (140, 3, 15);
INSERT INTO `tbl_gb_role_perm_related` VALUES (141, 3, 21);
INSERT INTO `tbl_gb_role_perm_related` VALUES (142, 3, 39);
INSERT INTO `tbl_gb_role_perm_related` VALUES (529, 1, 1);
INSERT INTO `tbl_gb_role_perm_related` VALUES (530, 1, 2);
INSERT INTO `tbl_gb_role_perm_related` VALUES (531, 1, 3);
INSERT INTO `tbl_gb_role_perm_related` VALUES (532, 1, 4);
INSERT INTO `tbl_gb_role_perm_related` VALUES (533, 1, 5);
INSERT INTO `tbl_gb_role_perm_related` VALUES (534, 1, 6);
INSERT INTO `tbl_gb_role_perm_related` VALUES (535, 1, 7);
INSERT INTO `tbl_gb_role_perm_related` VALUES (536, 1, 8);
INSERT INTO `tbl_gb_role_perm_related` VALUES (537, 1, 9);
INSERT INTO `tbl_gb_role_perm_related` VALUES (538, 1, 10);
INSERT INTO `tbl_gb_role_perm_related` VALUES (539, 1, 11);
INSERT INTO `tbl_gb_role_perm_related` VALUES (540, 1, 12);
INSERT INTO `tbl_gb_role_perm_related` VALUES (541, 1, 13);
INSERT INTO `tbl_gb_role_perm_related` VALUES (542, 1, 49);
INSERT INTO `tbl_gb_role_perm_related` VALUES (543, 1, 14);
INSERT INTO `tbl_gb_role_perm_related` VALUES (544, 1, 15);
INSERT INTO `tbl_gb_role_perm_related` VALUES (545, 1, 16);
INSERT INTO `tbl_gb_role_perm_related` VALUES (546, 1, 17);
INSERT INTO `tbl_gb_role_perm_related` VALUES (547, 1, 18);
INSERT INTO `tbl_gb_role_perm_related` VALUES (548, 1, 19);
INSERT INTO `tbl_gb_role_perm_related` VALUES (549, 1, 22);
INSERT INTO `tbl_gb_role_perm_related` VALUES (550, 1, 23);
INSERT INTO `tbl_gb_role_perm_related` VALUES (551, 1, 45);
INSERT INTO `tbl_gb_role_perm_related` VALUES (552, 1, 46);
INSERT INTO `tbl_gb_role_perm_related` VALUES (553, 1, 47);
INSERT INTO `tbl_gb_role_perm_related` VALUES (554, 1, 20);
INSERT INTO `tbl_gb_role_perm_related` VALUES (555, 1, 24);
INSERT INTO `tbl_gb_role_perm_related` VALUES (556, 1, 25);
INSERT INTO `tbl_gb_role_perm_related` VALUES (557, 1, 48);
INSERT INTO `tbl_gb_role_perm_related` VALUES (558, 1, 21);
INSERT INTO `tbl_gb_role_perm_related` VALUES (559, 1, 42);
INSERT INTO `tbl_gb_role_perm_related` VALUES (560, 1, 26);
INSERT INTO `tbl_gb_role_perm_related` VALUES (561, 1, 27);
INSERT INTO `tbl_gb_role_perm_related` VALUES (562, 1, 28);
INSERT INTO `tbl_gb_role_perm_related` VALUES (563, 1, 35);
INSERT INTO `tbl_gb_role_perm_related` VALUES (564, 1, 36);
INSERT INTO `tbl_gb_role_perm_related` VALUES (565, 1, 37);
INSERT INTO `tbl_gb_role_perm_related` VALUES (566, 1, 38);
INSERT INTO `tbl_gb_role_perm_related` VALUES (567, 1, 40);
INSERT INTO `tbl_gb_role_perm_related` VALUES (568, 1, 41);
INSERT INTO `tbl_gb_role_perm_related` VALUES (569, 1, 29);
INSERT INTO `tbl_gb_role_perm_related` VALUES (570, 1, 30);
INSERT INTO `tbl_gb_role_perm_related` VALUES (571, 1, 39);
INSERT INTO `tbl_gb_role_perm_related` VALUES (572, 1, 43);
INSERT INTO `tbl_gb_role_perm_related` VALUES (573, 1, 31);
INSERT INTO `tbl_gb_role_perm_related` VALUES (574, 1, 32);
INSERT INTO `tbl_gb_role_perm_related` VALUES (575, 1, 33);
INSERT INTO `tbl_gb_role_perm_related` VALUES (576, 1, 34);
INSERT INTO `tbl_gb_role_perm_related` VALUES (577, 1, 44);
INSERT INTO `tbl_gb_role_perm_related` VALUES (578, 1, 50);
INSERT INTO `tbl_gb_role_perm_related` VALUES (579, 1, 51);
INSERT INTO `tbl_gb_role_perm_related` VALUES (580, 1, 53);
INSERT INTO `tbl_gb_role_perm_related` VALUES (581, 1, 54);
INSERT INTO `tbl_gb_role_perm_related` VALUES (582, 1, 55);
INSERT INTO `tbl_gb_role_perm_related` VALUES (583, 1, 52);

-- ----------------------------
-- Table structure for tbl_gb_sub_contract_cost
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_sub_contract_cost`;
CREATE TABLE `tbl_gb_sub_contract_cost`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cost` decimal(18, 2) NULL DEFAULT NULL COMMENT '成本',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `sub_contract_id` bigint(20) NULL DEFAULT NULL COMMENT '子合同标识',
  `payee` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款方',
  `note` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `is_enbale` int(1) NULL DEFAULT 1 COMMENT '状态\r\n1：存在\r\n0：删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '成本合同成本表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_sub_contract_cost
-- ----------------------------
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (1, 1.00, '2019-12-13 00:00:00', 1, '1', '222', 1);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (2, 1.00, '2019-12-13 00:00:00', 4, '1', '1', 0);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (3, 1.00, '2019-12-13 00:00:00', 4, '1', '1', 0);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (4, 1.00, '2019-12-13 00:00:00', 4, '1', '1', 0);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (5, 20.00, '2019-12-17 00:00:00', 5, '123', '123', 1);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (6, 1000.00, '2019-12-23 00:00:00', 10, '李斯', '无', 1);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (7, 1000.00, '2020-01-11 00:00:00', 12, '测试', '11', 1);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (8, 123.00, '2020-01-11 00:00:00', 14, '123', '123', 1);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (9, 300.00, '2020-07-01 00:00:00', 14, '2', '2', 1);
INSERT INTO `tbl_gb_sub_contract_cost` VALUES (10, 111.00, '2020-11-12 00:00:00', 21, '1', '1', 1);

-- ----------------------------
-- Table structure for tbl_gb_sub_contract_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_sub_contract_info`;
CREATE TABLE `tbl_gb_sub_contract_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `sub_contract_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成本合同名称',
  `sub_contract_num` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成本合同编号',
  `sub_contract_cost` decimal(18, 2) NULL DEFAULT NULL COMMENT '成本合同总付款',
  `pay_item` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支出项',
  `cost_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '成本金额(签订合同时定好的)',
  `status` int(1) NULL DEFAULT 1 COMMENT '状态\r\n1：未完成\r\n2：已完成\r\n0：已删除',
  `payee` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款方',
  `payee_tel` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '收款方电话',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `company` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '乙方单位',
  `contract_id` bigint(20) NULL DEFAULT NULL COMMENT '合同主键',
  `cost_type_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成本类型标识',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '成本合同表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_sub_contract_info
-- ----------------------------
INSERT INTO `tbl_gb_sub_contract_info` VALUES (1, '1', '1', 1.00, NULL, 1.00, 1, '333', '333', '2019-12-13 09:49:04', '333', 1, '1,3');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (2, '1', '1', 0.00, NULL, 1.00, 0, '1', '1', NULL, '1', 1, '1,3');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (3, '1', '1', 0.00, NULL, 1.00, 0, '1', '1', NULL, '1', 1, '1,3');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (4, '3', '33', 0.00, NULL, 3.00, 1, '3', '3', '2019-12-13 15:21:24', '3', 1, '1,9');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (5, '222', '2222', 20.00, NULL, 222.00, 1, '22', '222', '2019-12-13 16:30:02', '2222', 1, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (6, '222', '2222', 0.00, NULL, 222.00, 1, '22', '222', '2019-12-13 16:30:09', '2222', 1, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (7, '222', '2222', 0.00, NULL, 222.00, 1, '22', '222', '2019-12-13 16:30:21', '2222', 1, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (8, '222', '2222', 0.00, NULL, 222.00, 1, '22', '22', '2019-12-13 16:31:14', '222', 1, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (9, '333', '333', 0.00, NULL, 333.00, 1, '333', '333', '2019-12-13 16:33:26', '333', 1, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (10, '测试', '23849284928239', 1000.00, NULL, 1000.00, 1, '测试', '13112345678', '2019-12-23 11:31:07', '测试', 3, '1,2,7');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (11, '测试', '32942424294', 0.00, NULL, 1000.00, 1, '测试', '13112345678', '2019-12-23 11:43:45', '测试', -1, '1,3');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (12, 'ces', '23414324', 1000.00, NULL, 1231.00, 1, 'asdf', '15112345633', '2020-01-09 15:55:23', 'sfda', 17, '1,2,7');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (13, 'dsaf', '32141324', 0.00, NULL, 12341243.00, 1, 'safd', '13112345678', '2020-01-09 15:57:23', 'afdsa', 17, '1,3');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (14, '324', '213', 423.00, NULL, 432.00, 1, '432', '15113112345', '2020-01-11 16:31:00', '432', 32, '1,2,7');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (15, '11', '1', 0.00, NULL, 1.00, 0, '1', '1', '2020-09-09 09:05:30', '1', 36, '1,2');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (16, '2', '2', 0.00, NULL, 2.00, 0, '2', '2', '2020-09-09 09:15:49', '2', 36, '1,2,7,8');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (17, '1', '1111', 0.00, NULL, 111.00, 1, '1', '1', '2020-09-09 09:48:31', '1', 36, '1,2');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (18, '11', '111', 0.00, NULL, 111.00, 1, '1', '', '2020-09-09 09:49:11', '1', 36, '1,9');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (19, '1', '1234566', 0.00, NULL, 222.00, 1, '人', '111', '2020-09-09 10:12:26', '单位', 36, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (20, '2', '1111', 0.00, NULL, 222.00, 1, '2', '2', '2020-09-09 10:12:51', '2', 35, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (21, '1', '2323', 111.00, NULL, 11111111.00, 1, '1', '1', '2020-09-09 14:03:35', '1', 36, '1,2,7,8');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (22, '1', '11111', 0.00, NULL, 1111.00, 0, '1', '1', '2020-09-09 14:04:45', '1', 36, '1,10');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (23, '2', '111', 0.00, NULL, 22.00, 0, '2', '2', '2020-09-09 14:06:31', '2', 36, '1,2,7,8');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (24, '2', '22', 0.00, NULL, 22.00, 0, '2', '2', '2020-09-09 14:06:49', '2', 36, '1,2,7,8');
INSERT INTO `tbl_gb_sub_contract_info` VALUES (25, '1', '11', 0.00, NULL, 111.00, 0, '1', '1', '2020-09-09 14:21:51', '1', 36, '1,11');

-- ----------------------------
-- Table structure for tbl_gb_sub_enclosure_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_sub_enclosure_info`;
CREATE TABLE `tbl_gb_sub_enclosure_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `file_path` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '附件路径',
  `creat_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `sub_contract_id` bigint(20) NULL DEFAULT NULL COMMENT '成本合同主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '成本合同附件表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_sub_enclosure_info
-- ----------------------------
INSERT INTO `tbl_gb_sub_enclosure_info` VALUES (1, 'D:/uploads/subcontract/20191213094844b3a9c.docx', '2019-12-13 09:49:04', 1);
INSERT INTO `tbl_gb_sub_enclosure_info` VALUES (2, 'D:/uploads/subcontract/20191213094844c1395.xls', '2019-12-13 09:49:04', 1);
INSERT INTO `tbl_gb_sub_enclosure_info` VALUES (3, 'D:/uploads/subcontract/201912130948440203c.docx', '2019-12-13 09:49:04', 1);
INSERT INTO `tbl_gb_sub_enclosure_info` VALUES (4, 'D:/uploads/subcontract/20191213094844a4659.docx', '2019-12-13 09:49:04', 1);
INSERT INTO `tbl_gb_sub_enclosure_info` VALUES (5, 'D:/uploads/subcontract/2019121315212281044.txt', '2019-12-13 15:21:24', 4);
INSERT INTO `tbl_gb_sub_enclosure_info` VALUES (6, 'D:/uploads/subcontract/2019121315212265c74.docx', '2019-12-13 15:21:24', 4);
INSERT INTO `tbl_gb_sub_enclosure_info` VALUES (7, 'D:/uploads/subcontract/201912231129563aece.jpg', '2019-12-23 11:31:07', 10);

-- ----------------------------
-- Table structure for tbl_gb_user_info
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_user_info`;
CREATE TABLE `tbl_gb_user_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_enable` int(1) NULL DEFAULT 1 COMMENT '用户状态\r\n1：启用\r\n0：禁用',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_user_info
-- ----------------------------
INSERT INTO `tbl_gb_user_info` VALUES (1, 'admin', '8715a4f66d9eeddba20b5453edc41bd7', '2019-12-05 14:17:48', 1, 'admin');
INSERT INTO `tbl_gb_user_info` VALUES (2, 'zhangtong', '8715a4f66d9eeddba20b5453edc41bd7', '2019-12-17 13:49:44', 0, '张童');

-- ----------------------------
-- Table structure for tbl_gb_user_role_related
-- ----------------------------
DROP TABLE IF EXISTS `tbl_gb_user_role_related`;
CREATE TABLE `tbl_gb_user_role_related`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '用户主键',
  `role_id` bigint(20) NULL DEFAULT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户和角色中间表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tbl_gb_user_role_related
-- ----------------------------
INSERT INTO `tbl_gb_user_role_related` VALUES (4, 2, 3);
INSERT INTO `tbl_gb_user_role_related` VALUES (5, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
