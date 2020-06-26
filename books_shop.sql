/*
 Navicat Premium Data Transfer

 Source Server         : lht
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : books_shop

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 26/06/2020 20:45:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bs_address
-- ----------------------------
DROP TABLE IF EXISTS `bs_address`;
CREATE TABLE `bs_address`  (
  `bs_addressId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `bs_userId` int(11) NOT NULL COMMENT '用户ID',
  `bs_userName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人名称',
  `bs_userPhone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人手机',
  `bs_areaIdPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货地址',
  `bs_isDefault` int(4) NULL DEFAULT 0 COMMENT '是否是默认地址',
  `bs_createTime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`bs_addressId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_address
-- ----------------------------
INSERT INTO `bs_address` VALUES (1, 1, '李浩天', '17796756337', '网易北京研发中心', 1, NULL);
INSERT INTO `bs_address` VALUES (3, 1, '李浩天', '17796756337', '辽宁大连金州区网易新闻', 1, NULL);
INSERT INTO `bs_address` VALUES (5, 1, '李浩天', '17796756337', '河南洛阳洛龙区洛阳师范学院', 1, NULL);

-- ----------------------------
-- Table structure for bs_admin
-- ----------------------------
DROP TABLE IF EXISTS `bs_admin`;
CREATE TABLE `bs_admin`  (
  `bs_adminId` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `bs_adminLogin` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员账号',
  `bs_adminPass` char(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  `bs_adminNum` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职工编号',
  `bs_createTime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `bs_lateLoginTime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后登陆时间',
  `bs_lateLateIP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最后登录IP',
  PRIMARY KEY (`bs_adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_admin
-- ----------------------------
INSERT INTO `bs_admin` VALUES (1, '123456', '123456', '001', '2020-06-19 17:48:19', '2020-06-19 17:48:19', '127.0.0.1');

-- ----------------------------
-- Table structure for bs_bookclass
-- ----------------------------
DROP TABLE IF EXISTS `bs_bookclass`;
CREATE TABLE `bs_bookclass`  (
  `bs_bookClassId` tinyint(4) NOT NULL AUTO_INCREMENT COMMENT '图书类别Id',
  `bs_bookClassName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书类别名称',
  PRIMARY KEY (`bs_bookClassId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 119 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_bookclass
-- ----------------------------
INSERT INTO `bs_bookclass` VALUES (101, '文学');
INSERT INTO `bs_bookclass` VALUES (102, '自动化');
INSERT INTO `bs_bookclass` VALUES (103, '计算机技术');
INSERT INTO `bs_bookclass` VALUES (104, '流控技术');
INSERT INTO `bs_bookclass` VALUES (105, '遥感技术');
INSERT INTO `bs_bookclass` VALUES (106, '远动技术');
INSERT INTO `bs_bookclass` VALUES (107, '数学');
INSERT INTO `bs_bookclass` VALUES (108, '物理');
INSERT INTO `bs_bookclass` VALUES (109, '理学');
INSERT INTO `bs_bookclass` VALUES (110, '化学');
INSERT INTO `bs_bookclass` VALUES (111, '矿业工程');
INSERT INTO `bs_bookclass` VALUES (112, '电工技术');
INSERT INTO `bs_bookclass` VALUES (113, '科学、科学研究');
INSERT INTO `bs_bookclass` VALUES (114, '教育');
INSERT INTO `bs_bookclass` VALUES (115, '体育');
INSERT INTO `bs_bookclass` VALUES (116, '信息技术');
INSERT INTO `bs_bookclass` VALUES (117, '计算机');
INSERT INTO `bs_bookclass` VALUES (118, '哲学');

-- ----------------------------
-- Table structure for bs_books
-- ----------------------------
DROP TABLE IF EXISTS `bs_books`;
CREATE TABLE `bs_books`  (
  `bs_bookId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `bs_bookSn` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书编号',
  `bs_bookName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `bs_bookAuthor` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书作者',
  `bs_bookClassId` tinyint(4) NOT NULL COMMENT '图书类别Id',
  `bs_bookBt` datetime(6) NOT NULL COMMENT '图书出版日期',
  `bs_pressNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社编号',
  `bs_bookPrice` decimal(10, 2) NOT NULL COMMENT '图书价格',
  `bs_bookCover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书封面',
  `bs_province` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍所在省份',
  `bs_booksNum` int(11) NOT NULL COMMENT '图书数量',
  PRIMARY KEY (`bs_bookId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_books
-- ----------------------------
INSERT INTO `bs_books` VALUES (1, 'ISBN 7-5055-6677-3', 'Windows 2000 Professional', '周军', 103, '2005-01-25 00:00:00.000000', '235', 30.00, 'https://s2.ax1x.com/2020/03/05/37nV6P.jpg', '河南', 10);
INSERT INTO `bs_books` VALUES (2, 'ISBN 7-302-04797-3', '3D Studio MAX 实例精选', '王小明', 103, '2003-05-24 00:00:00.000000', '235', 35.00, 'https://s2.ax1x.com/2020/03/05/37nPFH.jpg', '河南', 10);
INSERT INTO `bs_books` VALUES (3, 'ISBN 7-5055-3160-3', 'Windows 2000 网络管理', '刘耀辉', 103, '2006-06-23 00:00:00.000000', '235', 45.00, 'https://s2.ax1x.com/2020/03/05/37uI54.jpg', '河南', 10);
INSERT INTO `bs_books` VALUES (4, 'ISBN 7-5055-6697-3', 'android疯狂讲义', '李刚', 103, '2019-03-01 00:00:00.000000', '235', 128.00, 'https://s2.ax1x.com/2020/03/05/37niYd.jpg', '山东', 10);
INSERT INTO `bs_books` VALUES (7, '12346', '明朝那些事儿', '当年明月', 7, '2020-06-21 00:00:00.000000', '235', 15.00, 'https://ae01.alicdn.com/kf/H1910ec475c9740fa816cdbd364b6bdd7S.jpg', '中国', 10);

-- ----------------------------
-- Table structure for bs_cancelreason
-- ----------------------------
DROP TABLE IF EXISTS `bs_cancelreason`;
CREATE TABLE `bs_cancelreason`  (
  `bs_cancelReasonId` int(11) NOT NULL AUTO_INCREMENT COMMENT '取消原因Id',
  `bs_userLogin` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户账号',
  `bs_cancelReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '取消原因',
  `bs_createTime` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`bs_cancelReasonId`, `bs_userLogin`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_cancelreason
-- ----------------------------

-- ----------------------------
-- Table structure for bs_carts
-- ----------------------------
DROP TABLE IF EXISTS `bs_carts`;
CREATE TABLE `bs_carts`  (
  `bs_cartId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `bs_userId` int(11) NOT NULL COMMENT '用户ID',
  `bs_isCheck` tinyint(4) UNSIGNED NOT NULL DEFAULT 1 COMMENT '是否选中{1选中，0未选中}',
  `bs_goodsId` int(11) NOT NULL COMMENT '商品id',
  `bs_cartNum` int(11) NOT NULL COMMENT '商品数量',
  PRIMARY KEY (`bs_cartId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_carts
-- ----------------------------
INSERT INTO `bs_carts` VALUES (6, 1, 1, 1, 5);
INSERT INTO `bs_carts` VALUES (7, 1, 1, 2, 2);

-- ----------------------------
-- Table structure for bs_order
-- ----------------------------
DROP TABLE IF EXISTS `bs_order`;
CREATE TABLE `bs_order`  (
  `bs_orderId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `bs_orderNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `bs_userId` int(11) NOT NULL COMMENT '用户Id',
  `bs_orderStatus` int(4) NOT NULL DEFAULT -2 COMMENT '订单状态：-3用户拒收；-2未付款订单；-1用户取消；0代发货；1配送中；2用户确认收货',
  `bs_booksMoney` double(11, 2) NOT NULL COMMENT '商品总价格-未进行任何折扣的总价格',
  `bs_liverType` int(4) NOT NULL DEFAULT 0 COMMENT '收货方式：0送货上门，1：自提',
  `bs_deliverMoney` double(11, 2) NOT NULL COMMENT '运费',
  `bs_payType` int(4) NOT NULL DEFAULT 0 COMMENT '支付方式；0货到付款；1,：在线支付',
  `bs_payFrom` int(4) NOT NULL COMMENT '支付来源；1，支付宝，2微信支付',
  `bs_isPay` int(4) NOT NULL COMMENT '是否支付 0：未支付；1：已支付',
  `bs_userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人名称',
  `bs_userAddress` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人地址',
  `bs_userPhone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '收货人手机',
  `bs_isInvoice` int(4) NOT NULL DEFAULT 0 COMMENT '是否需要发票 1需要，0不需要',
  `bs_invoiceClient` char(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发票抬头 ',
  `bs_orderRemarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单备注',
  `bs_needPay` double(11, 2) NULL DEFAULT NULL,
  `bs_isReFund` int(4) NOT NULL DEFAULT 0 COMMENT '是否退款，0否，1是',
  `bs_cancelReasonId` int(11) NULL DEFAULT NULL COMMENT '取消原因Id',
  `bs_rejectReasonId` int(11) NULL DEFAULT NULL COMMENT '拒收原因Id',
  `bs_isClosed` int(4) NOT NULL DEFAULT 0 COMMENT '是否订单已完结0：未完结。1：已完结',
  `bs_orderRunique` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单流水号',
  `bs_receiveTime` datetime(6) NULL DEFAULT NULL COMMENT '收货时间',
  `bs_deliveryTime` datetime(6) NULL DEFAULT NULL COMMENT '发货时间',
  `bs_expressId` int(11) NULL DEFAULT NULL COMMENT '快递公司Id',
  `bs_pressNo` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '快递号',
  `bs_dataFlag` tinyint(4) NOT NULL DEFAULT 1 COMMENT '订单有效标志1，有效，0 无效',
  `bs_createTime` datetime(6) NULL DEFAULT NULL COMMENT '创建时间',
  `bs_areaId` int(11) NULL DEFAULT NULL COMMENT '最后一级Id',
  `bs_areaIdPath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区域Id路径',
  PRIMARY KEY (`bs_orderId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_order
-- ----------------------------
INSERT INTO `bs_order` VALUES (2, '1586779843839976', 1, 0, 220.00, 0, 0.00, 1, 1, 0, '李浩天', '辽宁大连金州区网易新闻', '17796756337', 0, NULL, NULL, NULL, 0, NULL, NULL, 0, NULL, NULL, NULL, NULL, NULL, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for bs_orderbooks
-- ----------------------------
DROP TABLE IF EXISTS `bs_orderbooks`;
CREATE TABLE `bs_orderbooks`  (
  `bs_orderbooksId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `bs_orderId` int(11) NOT NULL COMMENT '订单ID',
  `bs_goodsId` int(11) NOT NULL COMMENT '图书ID',
  `bs_goodsNum` int(11) NOT NULL COMMENT '图书数量',
  `bs_goodsPrice` double(10, 2) NOT NULL COMMENT '图书价格',
  `bs_goodsName` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `bs_goodImg` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书封面',
  PRIMARY KEY (`bs_orderbooksId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_orderbooks
-- ----------------------------
INSERT INTO `bs_orderbooks` VALUES (1, 2, 1, 5, 30.00, 'Windows 2000 Professional', 'https://s2.ax1x.com/2020/03/05/37nV6P.jpg');
INSERT INTO `bs_orderbooks` VALUES (2, 2, 2, 2, 35.00, '3D Studio MAX 实例精选', 'https://s2.ax1x.com/2020/03/05/37nPFH.jpg');

-- ----------------------------
-- Table structure for bs_password
-- ----------------------------
DROP TABLE IF EXISTS `bs_password`;
CREATE TABLE `bs_password`  (
  `bs_userId` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `bs_loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `bs_passWord` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `bs_payPassWord` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付密码',
  `bs_CreateTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `bs_LastLoginTime` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后登录时间',
  `bs_LastLoginIP` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最后登录IP',
  PRIMARY KEY (`bs_userId`, `bs_loginName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_password
-- ----------------------------
INSERT INTO `bs_password` VALUES (1, 'lht', '123', NULL, '2020-03-08 20:49:37', '2020-03-08 20:49:37', '0:0:0:0:0:0:0:1');
INSERT INTO `bs_password` VALUES (4, '2495654264@qq.com', '123456', NULL, '2020-04-08 16:23:22', '2020-04-08 16:23:22', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for bs_press
-- ----------------------------
DROP TABLE IF EXISTS `bs_press`;
CREATE TABLE `bs_press`  (
  `bs_pressId` int(11) NOT NULL AUTO_INCREMENT COMMENT '出版社Id',
  `bs_pressNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社编号',
  `bs_pressName` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社名称',
  PRIMARY KEY (`bs_pressId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_press
-- ----------------------------
INSERT INTO `bs_press` VALUES (1, '101', '人民出版社');
INSERT INTO `bs_press` VALUES (2, '019', '人民文学出版社');
INSERT INTO `bs_press` VALUES (3, '031', '科学出版社');
INSERT INTO `bs_press` VALUES (4, '010', '高等教育出版社');
INSERT INTO `bs_press` VALUES (5, '017', '商务印刷管');
INSERT INTO `bs_press` VALUES (6, '045', '人民邮电出版社');
INSERT INTO `bs_press` VALUES (7, '144', '农业出版社');
INSERT INTO `bs_press` VALUES (8, '011', '中国人民大学出版社');
INSERT INTO `bs_press` VALUES (9, '209', '北京大学出版社');
INSERT INTO `bs_press` VALUES (10, '235', '清华大学出版社');
INSERT INTO `bs_press` VALUES (11, '232', '教育科学出版社');
INSERT INTO `bs_press` VALUES (12, '009', '中国青少年出版社');
INSERT INTO `bs_press` VALUES (13, '056', '中国少年儿童出版社');
INSERT INTO `bs_press` VALUES (18, '123', '洛阳师范出版社');
INSERT INTO `bs_press` VALUES (19, '018', '高等教育出版社');

-- ----------------------------
-- Table structure for bs_publishbooks
-- ----------------------------
DROP TABLE IF EXISTS `bs_publishbooks`;
CREATE TABLE `bs_publishbooks`  (
  `bs_booksId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `bs_loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `bs_bookName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `bs_bookAuthor` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书作者',
  `bs_pressName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社名称',
  `bs_bookPrice` double(10, 2) NOT NULL COMMENT '图书价格',
  `bs_bookCover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书封面',
  `bs_bookNum` int(11) NOT NULL COMMENT '书籍数量',
  `bs_province` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '书籍所在省份',
  `bs_crateTime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`bs_booksId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_publishbooks
-- ----------------------------
INSERT INTO `bs_publishbooks` VALUES (1, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (2, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (3, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (4, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (5, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (6, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (7, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (8, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (9, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (10, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H56feb7dbfd4545ca99645760651424e7Q.jpg', 0, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (11, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hd6d9e01798204f6cb65e589e199e21a1P.jpg', 1, '河南', '2020-04-07 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (13, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/H0cc2cdb1586d4466ba9f95299f7d6e72A.jpg', 1, '河南', '2020-04-08 00:00:00');
INSERT INTO `bs_publishbooks` VALUES (17, 'lht', '明朝那些事儿', '当年明月', '人民出版社', 24.00, 'https://ae01.alicdn.com/kf/Hdcbdfe84346747e2bd1435e055a06aban.jpg', 1, '河南', '2020-04-08 00:00:00');

-- ----------------------------
-- Table structure for bs_rejectreason
-- ----------------------------
DROP TABLE IF EXISTS `bs_rejectreason`;
CREATE TABLE `bs_rejectreason`  (
  `bs_rejectReasonId` int(11) NOT NULL AUTO_INCREMENT COMMENT '拒收原因Id',
  `bs_loginName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `bs_rejectReason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '拒收原因',
  `bs_createTime` datetime(6) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`bs_rejectReasonId`, `bs_loginName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_rejectreason
-- ----------------------------

-- ----------------------------
-- Table structure for bs_status
-- ----------------------------
DROP TABLE IF EXISTS `bs_status`;
CREATE TABLE `bs_status`  (
  `bs_userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `bs_loginName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `bs_lastIP` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '最后登录IP',
  `bs_lastTime` datetime(6) NOT NULL COMMENT '最后登录时间',
  `bs_userStatus` tinyint(4) NOT NULL DEFAULT 1 COMMENT '账号状态：0停用，1启用',
  `bs_dataFlag` tinyint(4) UNSIGNED ZEROFILL NOT NULL DEFAULT 0001 COMMENT '删除标志：1有效，-1无效',
  `bs_createTime` datetime(6) NOT NULL ON UPDATE CURRENT_TIMESTAMP(6) COMMENT '创建时间',
  PRIMARY KEY (`bs_userId`, `bs_loginName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_status
-- ----------------------------

-- ----------------------------
-- Table structure for bs_stubooks
-- ----------------------------
DROP TABLE IF EXISTS `bs_stubooks`;
CREATE TABLE `bs_stubooks`  (
  `bs_bookId` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `bs_loginName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `bs_bookName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书名称',
  `bs_bookAuthor` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书作者',
  `bs_pressName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '出版社名称',
  `bs_bookPrice` decimal(10, 2) NOT NULL COMMENT '图书价格',
  `bs_bookCover` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '图书封面',
  `bs_bookNum` int(11) NOT NULL COMMENT '书籍数量',
  `bs_university` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所在学校',
  `bs_buyLogin` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '购买者账号，通过此字段获取购买者联系方式',
  `bs_crateTime` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`bs_bookId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_stubooks
-- ----------------------------
INSERT INTO `bs_stubooks` VALUES (1, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 0, 'undefined', 'lht', '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (2, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (3, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (4, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (5, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (6, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (7, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (8, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 0, 'undefined', 'lht', '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (9, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (10, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (11, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (12, 'lht', '平凡的世界', '路遥', '人民出版社', 12.00, 'https://ae01.alicdn.com/kf/Hbb7520f37f1042939ca0629a7b9e7d87N.png', 1, 'undefined', NULL, '2020-04-07 08:00:00');
INSERT INTO `bs_stubooks` VALUES (13, 'lht', '名草那些事', '当年明月', '人民出版社', 34.00, 'https://ae01.alicdn.com/kf/Heacbd0259e244e67a33c4200cdc6d1f3u.jpg', 0, '洛阳师范学院', 'lht', '2020-04-08 08:00:00');
INSERT INTO `bs_stubooks` VALUES (14, 'lht', '明朝那些事儿', '当年明月', '人民出版社', 24.00, 'https://ae01.alicdn.com/kf/Hfe6e7f95843f4a0493e95fb4a6b869a2r.jpg', 0, '洛阳师范学院', 'lht', '2020-04-08 08:00:00');

-- ----------------------------
-- Table structure for bs_users
-- ----------------------------
DROP TABLE IF EXISTS `bs_users`;
CREATE TABLE `bs_users`  (
  `bs_userId` int(8) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `bs_loginName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `bs_loginSecret` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户安全码',
  `bs_userType` int(4) NOT NULL DEFAULT 0 COMMENT '用户类型：学校用户1，普通用户0',
  `bs_userSex` int(4) UNSIGNED ZEROFILL NOT NULL DEFAULT 0000 COMMENT '用户性别：男1，女0',
  `bs_userName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `bs_trueName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `bs_userbrithday` datetime(0) NULL DEFAULT NULL COMMENT '生日',
  `bs_userPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户头像',
  `bs_userQQ` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户QQ',
  `bs_userPhone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户手机',
  `bs_userEmail` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `bs_province` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '省份',
  `bs_university` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在学校',
  PRIMARY KEY (`bs_userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bs_users
-- ----------------------------
INSERT INTO `bs_users` VALUES (1, 'lht', '', 0, 0000, NULL, '李浩天', '2003-03-12 00:00:00', '', '2495654264', '17796756337', '1398692711@qq.com', '河南', '洛阳师范学院');
INSERT INTO `bs_users` VALUES (2, '2495654264@qq.com', '', 0, 0000, NULL, '李浩天', '2020-04-16 00:00:00', '', '2495654264', '17796756337', '', '河南', '洛阳师范学院');

SET FOREIGN_KEY_CHECKS = 1;
