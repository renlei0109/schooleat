/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50616
Source Host           : localhost:3306
Source Database       : eat

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2014-05-27 19:07:06
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `owner_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `province` varchar(10) COLLATE utf8_bin NOT NULL,
  `city` varchar(10) COLLATE utf8_bin NOT NULL,
  `zone` varchar(10) COLLATE utf8_bin NOT NULL,
  `address` varchar(25) COLLATE utf8_bin NOT NULL,
  `mobile` varchar(11) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `collection`
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `collection_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `id` varchar(32) COLLATE utf8_bin NOT NULL,
  `type` int(1) NOT NULL,
  PRIMARY KEY (`collection_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for `dish`
-- ----------------------------
DROP TABLE IF EXISTS `dish`;
CREATE TABLE `dish` (
  `dish_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `resturant_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `dish_name` varchar(32) COLLATE utf8_bin NOT NULL,
  `price` double(255,0) NOT NULL,
  `sale_price` double(255,0) DEFAULT NULL,
  `sales` int(255) DEFAULT NULL,
  `img_url` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dish
-- ----------------------------

-- ----------------------------
-- Table structure for `dish_rec`
-- ----------------------------
DROP TABLE IF EXISTS `dish_rec`;
CREATE TABLE `dish_rec` (
  `dish_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `resturant_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `dish_name` varchar(32) COLLATE utf8_bin NOT NULL,
  `price` double(255,0) NOT NULL,
  `sale_price` double(255,0) DEFAULT NULL,
  `sales` int(255) DEFAULT NULL,
  `img_url` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dish_rec
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `order_time` datetime NOT NULL,
  `user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `total_price` double NOT NULL,
  `status` varchar(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_dish`
-- ----------------------------
DROP TABLE IF EXISTS `order_dish`;
CREATE TABLE `order_dish` (
  `order_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `resturant_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `dish_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order_dish
-- ----------------------------

-- ----------------------------
-- Table structure for `resturant`
-- ----------------------------
DROP TABLE IF EXISTS `resturant`;
CREATE TABLE `resturant` (
  `resturant_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `resturant_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `mobile` varchar(11) COLLATE utf8_bin NOT NULL,
  `delivery` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `delivery_limit` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `delivery_time` int(8) DEFAULT NULL,
  `x` varchar(20) COLLATE utf8_bin NOT NULL,
  `y` varchar(20) COLLATE utf8_bin NOT NULL,
  `type` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  `img_url` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `isfree` varchar(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`resturant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of resturant
-- ----------------------------

-- ----------------------------
-- Table structure for `resturant_tag`
-- ----------------------------
DROP TABLE IF EXISTS `resturant_tag`;
CREATE TABLE `resturant_tag` (
  `tag_mark` varchar(2) COLLATE utf8_bin NOT NULL,
  `tag_name` varchar(20) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`tag_mark`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of resturant_tag
-- ----------------------------

-- ----------------------------
-- Table structure for `suggest`
-- ----------------------------
DROP TABLE IF EXISTS `suggest`;
CREATE TABLE `suggest` (
  `advice_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `content` varchar(256) COLLATE utf8_bin NOT NULL,
  `result` varchar(1) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`advice_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of suggest
-- ----------------------------

-- ----------------------------
-- Table structure for `tag_owner`
-- ----------------------------
DROP TABLE IF EXISTS `tag_owner`;
CREATE TABLE `tag_owner` (
  `tag_mark` varchar(2) COLLATE utf8_bin NOT NULL,
  `owner_id` varchar(32) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`tag_mark`,`owner_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of tag_owner
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(32) COLLATE utf8_bin NOT NULL,
  `user_name` varchar(20) COLLATE utf8_bin NOT NULL,
  `password` varchar(20) COLLATE utf8_bin NOT NULL,
  `mobile` varchar(11) COLLATE utf8_bin NOT NULL,
  `img_url` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `binding` varchar(32) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of user
-- ----------------------------
