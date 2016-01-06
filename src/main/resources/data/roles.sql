/*
 Navicat Premium Data Transfer

 Source Server         : 100
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : 192.168.0.100
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : utf-8

 Date: 01/06/2016 19:54:02 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `roles`
-- ----------------------------
BEGIN;
INSERT INTO `roles` VALUES ('ROLE_ADMIN'), ('ROLE_DBA'), ('ROLE_TEST'), ('ROLE_USER');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
