/*
Navicat MySQL Data Transfer

Source Server         : Mysql
Source Server Version : 50625
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50625
File Encoding         : 65001

Date: 2018-08-13 22:32:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for film
-- ----------------------------
DROP TABLE IF EXISTS `film`;
CREATE TABLE `film` (
  `film_id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `language_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`film_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of film
-- ----------------------------
INSERT INTO `film` VALUES ('1', '詹姆斯去湖人', '恩耶耶耶耶耶耶耶', '2');
INSERT INTO `film` VALUES ('2', '浪漫土耳其++++', '的风格和他', '1');
INSERT INTO `film` VALUES ('5', '加班？？？', '今天周末不加班', '1');
INSERT INTO `film` VALUES ('6', '习近平西乡', '噢噢噢噢是吗', '3');

-- ----------------------------
-- Table structure for language
-- ----------------------------
DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `language_id` int(10) NOT NULL,
  `language` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`language_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of language
-- ----------------------------
INSERT INTO `language` VALUES ('1', 'English');
INSERT INTO `language` VALUES ('2', 'china');
INSERT INTO `language` VALUES ('3', 'jpan');
INSERT INTO `language` VALUES ('4', 'french');
INSERT INTO `language` VALUES ('5', 'russian');

-- ----------------------------
-- Table structure for study
-- ----------------------------
DROP TABLE IF EXISTS `study`;
CREATE TABLE `study` (
  `userid` int(10) NOT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` int(10) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of study
-- ----------------------------
INSERT INTO `study` VALUES ('1', '詹姆斯', '123456');
SET FOREIGN_KEY_CHECKS=1;
