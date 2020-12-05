/*
 Navicat Premium Data Transfer

 Source Server         : localdatabase
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : demo

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 05/12/2020 21:58:57
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for access_event
-- ----------------------------
DROP TABLE IF EXISTS `access_event`;
CREATE TABLE `access_event`  (
  `timestmp` bigint(0) NOT NULL COMMENT 'access 时间创建的时间',
  `requestURI` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求的 URI',
  `requestURL` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求的 URL。由请求方法，请求 URI 以及请求协议组成',
  `remoteHost` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程主机的名字',
  `remoteUser` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程用户的名字',
  `remoteAddr` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '远程 IP 地址',
  `protocol` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求协议。例如 HTTP 或 HTTPS',
  `method` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法。通常为 GET 或 POST',
  `serverName` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发出请求的服务器的名字',
  `postContent` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求的内容',
  `event_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT 'access 事件的数据库 id',
  PRIMARY KEY (`event_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for access_event_header
-- ----------------------------
DROP TABLE IF EXISTS `access_event_header`;
CREATE TABLE `access_event_header`  (
  `event_id` bigint(0) NOT NULL COMMENT '相对应 access 事件的数据库 id',
  `header_key` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '请求头的名字，例如 User-Agent',
  `header_value` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求头的值，例如 Mozilla/5.0 (Windows; U; Windows NT 5.1; fr; rv:1.8.1) Gecko/20061010 Firefox/2.0',
  PRIMARY KEY (`event_id`, `header_key`) USING BTREE,
  CONSTRAINT `access_event_header_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `access_event` (`event_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logging_event
-- ----------------------------
DROP TABLE IF EXISTS `logging_event`;
CREATE TABLE `logging_event`  (
  `timestmp` bigint(0) NOT NULL COMMENT '日志事件的创建时间',
  `formatted_message` text CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '经过 org.slf4j.impl.MessageFormatter 格式化后的消息',
  `thread_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `logger_name` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发出日志的 logger 名',
  `level_string` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志事件的级别',
  `reference_flag` smallint(0) NULL DEFAULT NULL COMMENT '用来表示是否是异常或者与 MDC 属性相关联。它的值通过 ch.qos.logback.classic.db.DBHelper 计算得到。日志时间包含 MDC 或者 Context 时，它的值为 1。包含异常时，它的值为 2。包含两者，则值为 3。',
  `caller_filename` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发出日志请求的文件名',
  `caller_class` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发出日志请求的类',
  `caller_method` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发出日志请求的方法',
  `caller_line` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发出日志请求所在的行',
  `event_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '日志事件在数据库的 id',
  `arg0` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arg1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arg2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `arg3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`event_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logging_event_exception
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_exception`;
CREATE TABLE `logging_event_exception`  (
  `event_id` bigint(0) NOT NULL COMMENT '日志事件的数据库 id',
  `i` smallint(0) NOT NULL COMMENT '堆栈所在的行',
  `trace_line` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '相对应的堆栈信息',
  PRIMARY KEY (`event_id`, `i`) USING BTREE,
  CONSTRAINT `logging_event_exception_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for logging_event_property
-- ----------------------------
DROP TABLE IF EXISTS `logging_event_property`;
CREATE TABLE `logging_event_property`  (
  `event_id` bigint(0) NOT NULL COMMENT '日志事件的数据库 id',
  `mapped_key` varchar(254) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'MDC 属性的 key',
  `mapped_value` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT 'MDC 属性的 value',
  PRIMARY KEY (`event_id`, `mapped_key`) USING BTREE,
  CONSTRAINT `logging_event_property_ibfk_1` FOREIGN KEY (`event_id`) REFERENCES `logging_event` (`event_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
