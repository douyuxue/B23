/*
 Navicat Premium Data Transfer

 Source Server         : yu
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : b23

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 24/07/2020 16:28:43
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `a_no` varchar(10) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `a_name` varchar(12) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `a_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `a_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `a_workplace` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  PRIMARY KEY (`a_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('2017', '张三', '20176', '13427119483', '二食堂');
INSERT INTO `admin` VALUES ('20178', '管理员', '123', '1532213569', '广州');

-- ----------------------------
-- Table structure for clacify
-- ----------------------------
DROP TABLE IF EXISTS `clacify`;
CREATE TABLE `clacify`  (
  `clacifyno` int(5) NOT NULL,
  `clacifyname` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`clacifyno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of clacify
-- ----------------------------
INSERT INTO `clacify` VALUES (1, '素菜');
INSERT INTO `clacify` VALUES (2, '荤菜');
INSERT INTO `clacify` VALUES (3, '组合');

-- ----------------------------
-- Table structure for dish
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish`  (
  `menu_id` int(10) NOT NULL,
  `menu_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `menu_price` int(10) NULL DEFAULT NULL,
  `clasifyno` int(5) NULL DEFAULT NULL,
  PRIMARY KEY (`menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of dish
-- ----------------------------
INSERT INTO `dish` VALUES (1, '红烧肉', 4, 2);
INSERT INTO `dish` VALUES (2, '糖醋排骨', 5, 2);
INSERT INTO `dish` VALUES (3, '红烧鱼+青菜', 7, 3);
INSERT INTO `dish` VALUES (4, '四季豆', 2, 1);
INSERT INTO `dish` VALUES (5, '蜜汁鸡翅+菜心', 6, 3);
INSERT INTO `dish` VALUES (6, '番茄炒蛋', 2, 1);
INSERT INTO `dish` VALUES (7, '麻婆豆腐', 3, 1);
INSERT INTO `dish` VALUES (8, '东坡肉', 5, 2);
INSERT INTO `dish` VALUES (9, '西兰花+鸭肉', 8, 3);
INSERT INTO `dish` VALUES (10, '生菜', 2, 1);

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `usernomber` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userpass` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userphone` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `userplace` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES ('管理员', '20179', '123', '1532213569', '广州');
INSERT INTO `personal` VALUES ('管理员', '20179', '123', '1532213569', '广州');
INSERT INTO `personal` VALUES ('管理员', '20179', '123', '1532213569', '广州');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` int(20) NOT NULL,
  `spassword` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sage` tinyint(3) NOT NULL,
  `sphone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sschool` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (20175, '123', '学生', 20, '1532213569', '惠州');
INSERT INTO `student` VALUES (20170021, '1234', '学生2', 21, '15378629219', '广州市');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `userpass` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('学生', '123');
INSERT INTO `user` VALUES ('管理员', '123');
INSERT INTO `user` VALUES ('超级管理员', '123');

SET FOREIGN_KEY_CHECKS = 1;
