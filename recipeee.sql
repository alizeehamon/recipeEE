/*
Navicat MySQL Data Transfer

Source Server         : poe
Source Server Version : 50153
Source Host           : localhost:3307
Source Database       : recipeee

Target Server Type    : MYSQL
Target Server Version : 50153
File Encoding         : 65001

Date: 2022-10-05 21:05:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ingredient`
-- ----------------------------
DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE `ingredient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ingredient
-- ----------------------------

-- ----------------------------
-- Table structure for `ingredient_recipe`
-- ----------------------------
DROP TABLE IF EXISTS `ingredient_recipe`;
CREATE TABLE `ingredient_recipe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qty_ingredient` int(11) NOT NULL,
  `id_ingredient` bigint(20) NOT NULL,
  `id_recipe` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh3o8l80x20j40o2wjh1w7wma7` (`id_ingredient`),
  KEY `FK6rnnyg8da0ly1kladk05ug1e0` (`id_recipe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ingredient_recipe
-- ----------------------------

-- ----------------------------
-- Table structure for `recipe`
-- ----------------------------
DROP TABLE IF EXISTS `recipe`;
CREATE TABLE `recipe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cook_time` int(11) DEFAULT NULL,
  `cook_type` varchar(255) DEFAULT NULL,
  `difficulty` int(11) DEFAULT NULL,
  `expanse` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `pictureUrl` varchar(255) DEFAULT NULL,
  `preparation` int(11) DEFAULT NULL,
  `rest_time` int(11) DEFAULT NULL,
  `id_type_meal` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgafyeqj4jign13cxiu0bxyuqq` (`id_type_meal`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recipe
-- ----------------------------
INSERT INTO `recipe` VALUES ('1', '40', 'furnace', '3', '2', 'Choucroute', 'https://static.wixstatic.com/media/b29e3b_cc985ef044294b46950bab8dd59e0f40~mv2.jpg/v1/fill/w_549,h_403,al_c,lg_1,q_80,enc_auto/choucroute.jpg', '30', '0', '2');
INSERT INTO `recipe` VALUES ('2', '20', 'furnace', '4', '2', 'Pizza Margherita', 'https://img.cuisineaz.com/660x660/2021/02/25/i159373-pizza-margherita.webp', '30', '5', '2');
INSERT INTO `recipe` VALUES ('3', '123', 'Furnace', '2', '1', 'Tarte aux pommes', 'https://assets.afcdn.com/recipe/20220128/128250_w1000h723c1cx1294cy688cxb2037cyb1472.webp', '10', '10', '3');

-- ----------------------------
-- Table structure for `recipe_user`
-- ----------------------------
DROP TABLE IF EXISTS `recipe_user`;
CREATE TABLE `recipe_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cook_date` date NOT NULL,
  `id_recipe` bigint(20) NOT NULL,
  `id_user` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_367n6q04u1oin0p1xmb8d1ewg` (`id_recipe`),
  KEY `FKc55qoxsatmbtfl9nja82sasd4` (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recipe_user
-- ----------------------------
INSERT INTO `recipe_user` VALUES ('1', '2022-10-05', '1', '1');

-- ----------------------------
-- Table structure for `step`
-- ----------------------------
DROP TABLE IF EXISTS `step`;
CREATE TABLE `step` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `id_recipe` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrwnwxkdlw00ielrrupe1t9hl1` (`id_recipe`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of step
-- ----------------------------

-- ----------------------------
-- Table structure for `type_meal`
-- ----------------------------
DROP TABLE IF EXISTS `type_meal`;
CREATE TABLE `type_meal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type_meal
-- ----------------------------
INSERT INTO `type_meal` VALUES ('2', 'Meal');
INSERT INTO `type_meal` VALUES ('3', 'Dessert');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `picture_url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'test@test.fr', 'admin', 'test', 'test', null);
