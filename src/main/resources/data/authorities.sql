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

 Date: 01/06/2016 19:53:29 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `authorities`
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `id` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_4phudwk71l89fw3fnescg2fem` (`role`),
  KEY `FK_baahryprcge2u172egph1qwur` (`username`),
  CONSTRAINT `FK_4phudwk71l89fw3fnescg2fem` FOREIGN KEY (`role`) REFERENCES `roles` (`role`),
  CONSTRAINT `FK_baahryprcge2u172egph1qwur` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `authorities`
-- ----------------------------
BEGIN;
INSERT INTO `authorities` VALUES ('1', 'ROLE_USER', 'user'), ('2', 'ROLE_ADMIN', 'admin'), ('3', 'ROLE_TEST', 'test'), ('4', 'ROLE_DBA', 'dba'), ('5', 'ROLE_ADMIN', 'user');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
