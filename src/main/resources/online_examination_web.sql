/*
Navicat MySQL Data Transfer

Source Server         : 3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : online_examination_web

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-12-14 16:37:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for roles_permissions
-- ----------------------------
DROP TABLE IF EXISTS `roles_permissions`;
CREATE TABLE `roles_permissions` (
  `role_name` varchar(20) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_permissions
-- ----------------------------
INSERT INTO `roles_permissions` VALUES ('role1', 'create');
INSERT INTO `roles_permissions` VALUES ('role2', 'create');

-- ----------------------------
-- Table structure for tb_examinations
-- ----------------------------
DROP TABLE IF EXISTS `tb_examinations`;
CREATE TABLE `tb_examinations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) DEFAULT NULL,
  `score` int(3) DEFAULT NULL,
  `questions` varchar(255) DEFAULT NULL,
  `answers` varchar(255) DEFAULT NULL,
  `start_examination_time` datetime DEFAULT NULL,
  `end_examination_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `examinations_student_id_unique` (`student_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_examinations
-- ----------------------------
INSERT INTO `tb_examinations` VALUES ('3', null, '3', null, null, null, '2017-08-01 10:29:11');
INSERT INTO `tb_examinations` VALUES ('4', null, '20', null, null, null, null);
INSERT INTO `tb_examinations` VALUES ('5', null, '20', null, null, null, null);
INSERT INTO `tb_examinations` VALUES ('6', null, '20', null, null, null, null);
INSERT INTO `tb_examinations` VALUES ('7', null, '20', null, null, null, null);

-- ----------------------------
-- Table structure for tb_examinee
-- ----------------------------
DROP TABLE IF EXISTS `tb_examinee`;
CREATE TABLE `tb_examinee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `class_num` int(11) DEFAULT NULL,
  `avater` varchar(100) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `tel` varchar(12) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `examinee_student_id_unique` (`student_id`) USING BTREE,
  KEY `examinee_name_normal` (`name`) USING BTREE,
  KEY `examinee_class_normal` (`class_num`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_examinee
-- ----------------------------
INSERT INTO `tb_examinee` VALUES ('1', '原兴华', '123456', '1316040239', '13160402', '1502174245541.jpg', null, '18776665645', '汉族', '175', '60', '桂林电子科技大学', '男');
INSERT INTO `tb_examinee` VALUES ('2', '张三', null, null, null, null, null, null, null, null, null, null, '女');

-- ----------------------------
-- Table structure for tb_questions_option
-- ----------------------------
DROP TABLE IF EXISTS `tb_questions_option`;
CREATE TABLE `tb_questions_option` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `answer` varchar(2) DEFAULT NULL,
  `create_person` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `questions_create_person_unique` (`create_person`) USING BTREE,
  KEY `questions_qustion_normal` (`question`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_questions_option
-- ----------------------------
INSERT INTO `tb_questions_option` VALUES ('1', null, null, null, '2017-08-01 10:39:35');
INSERT INTO `tb_questions_option` VALUES ('2', null, null, null, '2017-08-01 10:40:14');

-- ----------------------------
-- Table structure for tb_teacher
-- ----------------------------
DROP TABLE IF EXISTS `tb_teacher`;
CREATE TABLE `tb_teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) DEFAULT NULL,
  `position` varchar(10) DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `sex` varchar(2) DEFAULT '男',
  `avater` varchar(100) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` double(5,0) DEFAULT NULL,
  `school` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_name_normal` (`name`) USING BTREE,
  KEY `teacher_position_normal` (`position`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_teacher
-- ----------------------------
INSERT INTO `tb_teacher` VALUES ('1', '张三', '222', '222', '2017-12-11 10:14:56', null, '男', null, null, '12', null, null);
INSERT INTO `tb_teacher` VALUES ('2', '张三', null, null, '2017-12-08 19:32:18', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('3', '张三', null, null, '2017-12-08 19:28:36', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('5', '张三', null, null, '2017-12-08 19:28:36', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('6', '1', null, null, '2017-12-08 19:35:12', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('7', '1', null, null, '2017-12-08 19:35:45', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('8', '1', null, null, '2017-12-08 19:36:07', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('9', '1', null, null, '2017-12-09 09:53:17', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('10', '1', null, null, '2017-12-11 10:11:49', null, '男', null, null, null, null, null);
INSERT INTO `tb_teacher` VALUES ('11', '1', null, null, '2017-12-11 10:12:32', null, '男', null, null, null, null, null);

-- ----------------------------
-- Table structure for tmp
-- ----------------------------
DROP TABLE IF EXISTS `tmp`;
CREATE TABLE `tmp` (
  `rq` varchar(10) DEFAULT NULL,
  `shengfu` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tmp
-- ----------------------------
INSERT INTO `tmp` VALUES ('2005-05-10', '负');
INSERT INTO `tmp` VALUES ('2005-05-10', '负');
INSERT INTO `tmp` VALUES ('2005-05-09', '胜');
INSERT INTO `tmp` VALUES ('2005-05-09', '胜');
INSERT INTO `tmp` VALUES ('2005-05-09', '负');
INSERT INTO `tmp` VALUES ('2005-05-09', '负');
INSERT INTO `tmp` VALUES ('2005-05-10', '胜');
INSERT INTO `tmp` VALUES ('1111', '1');
INSERT INTO `tmp` VALUES ('11', '1');
INSERT INTO `tmp` VALUES ('dd', '原');
INSERT INTO `tmp` VALUES ('1', '1');
INSERT INTO `tmp` VALUES ('1', '2');
INSERT INTO `tmp` VALUES ('1', '3');
INSERT INTO `tmp` VALUES ('t', '海');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1');
INSERT INTO `user` VALUES ('1', '2');
INSERT INTO `user` VALUES ('原', '3');
INSERT INTO `user` VALUES ('1', '4');
INSERT INTO `user` VALUES ('2', '5');
INSERT INTO `user` VALUES ('3', '6');
INSERT INTO `user` VALUES ('海', '7');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'yuan', '123');
INSERT INTO `users` VALUES ('2', 'yang', '123');

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `userName` varchar(20) NOT NULL,
  `role_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES ('yuan', 'role1');

-- ----------------------------
-- Procedure structure for process1
-- ----------------------------
DROP PROCEDURE IF EXISTS `process1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `process1`(OUT `sex` varchar(10))
BEGIN
	#Routine body goes here...
	SELECT * FROM tb_examinee ;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for function1
-- ----------------------------
DROP FUNCTION IF EXISTS `function1`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `function1`(`n` tinyint) RETURNS int(10)
BEGIN
	#Routine body goes here...

	RETURN n*100;
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for function2
-- ----------------------------
DROP FUNCTION IF EXISTS `function2`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `function2`(`sex` varchar(20),`age` int) RETURNS varchar(20) CHARSET utf8
BEGIN
	#Routine body goes here...
	IF sex='1' THEN
		RETURN '12';
	END if;
	RETURN sex;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `test_trigger`;
DELIMITER ;;
CREATE TRIGGER `test_trigger` AFTER INSERT ON `tmp` FOR EACH ROW BEGIN   INSERT INTO user(name) VALUES(new.shengfu); END
;;
DELIMITER ;
