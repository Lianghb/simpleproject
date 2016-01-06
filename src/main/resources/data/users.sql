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

 Date: 01/06/2016 19:54:22 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('admin', 'admin'), ('dba', 'dba'), ('test', 'test'), ('user', 'user');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
