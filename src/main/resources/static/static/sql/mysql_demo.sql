/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.2.177
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : 192.168.2.177:3306
 Source Schema         : sinodb

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 16/06/2020 15:11:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for an_menu_info
-- ----------------------------
DROP TABLE IF EXISTS `an_menu_info`;
CREATE TABLE `an_menu_info`  (
  `MID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `MNAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名称',
  `MURL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '连接URL',
  `PARENTID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父级ID',
  `TYPEID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属类型',
  `ICON` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `THESORT` int(11) NULL DEFAULT NULL COMMENT '排序列',
  `ENABLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否可用',
  `TABLENAME` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '涉及表名',
  `COUNTTABLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单数量',
  `ISLEAF` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否是叶子节点',
  `CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `DM_CHARGE` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '罪名',
  `USERID` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '警号',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `DESCIPTION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '描述',
  `TARGET` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '打开方式',
  `MODELID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模型ID',
  `UPDATETIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `DEFAULTOPEN` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否默认打开',
  PRIMARY KEY (`MID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数边菜单表*' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for an_menu_type
-- ----------------------------
DROP TABLE IF EXISTS `an_menu_type`;
CREATE TABLE `an_menu_type`  (
  `TID` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单类型id',
  `TNAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单类型名称',
  `TURL` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问地址',
  `THESORT` int(11) NULL DEFAULT NULL COMMENT '排序列',
  `ENABLE` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有效',
  `DESCN` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `CREATETIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `USERID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `UPDATETIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`TID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单类型表*' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dv_charts
-- ----------------------------
DROP TABLE IF EXISTS `zyk_sjy`;
CREATE TABLE `zyk_sjy`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `URL` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库URL/接口URL/十五所URL',
  `TYPE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库类型/请求方ID',
  `PASSWORD` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码/服务方id/十五所服务名',
  `USERNAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名/共享集',
  `DNAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源名称/接口名称',
  `DESCRIPTION` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源描述/接口版本',
  `ADDTIME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '添加时间',
  `SOURCETYPE` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据源类型（1数据库 2巨龙url 3十五所url）',
  `URLTYPE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL的类型（1实时，2定时）',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 89 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据源' ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for v_case_datatable
-- ----------------------------
DROP VIEW IF EXISTS `v_case_datatable`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`%` SQL SECURITY DEFINER VIEW `v_case_datatable` AS select distinct `a`.`AJID` AS `AJID`,`b`.`TABLENM` AS `CNAME`,`b`.`TABLECNAME` AS `TABLECNAME` from (`st_data_source` `a` left join `st_data_template` `b` on((`a`.`MBDM` = `b`.`MBDM`))) where (`b`.`TABLECNAME` is not null);

-- ----------------------------
-- Function structure for fc_is_num
-- ----------------------------
DROP FUNCTION IF EXISTS `fc_is_num`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `fc_is_num`(str varchar(20)) RETURNS int(4)
BEGIN 
DECLARE iResult INT DEFAULT 0; 
SELECT p_string REGEXP '^[0-9]*$' INTO iResult; 
IF iResult = 1 THEN 
RETURN 1; 
ELSE 
RETURN 0; 
END IF; 
END
;;
delimiter ;

-- ----------------------------
-- Function structure for Get_StrArrayStrOfIndex
-- ----------------------------
DROP FUNCTION IF EXISTS `Get_StrArrayStrOfIndex`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `Get_StrArrayStrOfIndex`(`str` varchar(2000),`split` varchar(10),`ind` int) RETURNS varchar(200) CHARSET utf8
BEGIN
declare location int ;
declare start int ;
declare next int default 0;
declare seed int ;
set str=ltrim(rtrim(str)) ;
set str=CONCAT(str,split) ;
set start=1 ;
set next=1 ;
set seed=length(split) ;
set location=instr(str,split) ;

WHILE location<>0 and ind>next do 
	set start=location+seed ;
	#select concat(location,' ',seed,' ',start);
	set str=substr(str,start) ;
	#select str;
	set location=instr(str,split) ;
	set next=next+1 ;
end WHILE;
if location <> 0 THEN
	#select str;
	return substr(str,1,length(str)-length(substr(str,instr(str,split)))) ;
end if;
return '';
END
;;
delimiter ;

-- ----------------------------
-- Function structure for id_seq_currval
-- ----------------------------
DROP FUNCTION IF EXISTS `id_seq_currval`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `id_seq_currval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN 
        DECLARE retval VARCHAR(64);
        SET retval="-999999999,null";  
        SELECT concat(CAST(current_value AS CHAR),",",CAST(increment AS CHAR) ) INTO retval 
          FROM ID_SEQ  WHERE name = seq_name;  
        RETURN retval ; 
END
;;
delimiter ;

-- ----------------------------
-- Function structure for id_seq_nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `id_seq_nextval`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `id_seq_nextval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN 
         UPDATE ID_SEQ  
                 SET current_value = current_value + increment 
                  WHERE name = seq_name;  
         RETURN id_seq_currval(seq_name);  
END
;;
delimiter ;

-- ----------------------------
-- Function structure for id_seq_setval
-- ----------------------------
DROP FUNCTION IF EXISTS `id_seq_setval`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `id_seq_setval`(seq_name VARCHAR(50), value INTEGER) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN 
         UPDATE ID_SEQ  
                   SET current_value = value  
                   WHERE name = seq_name;  
         RETURN id_seq_currval(seq_name);  
END
;;
delimiter ;

-- ----------------------------
-- Function structure for mycat_seq_currval
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_currval`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_currval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN 
        DECLARE retval VARCHAR(64);
        SET retval="-999999999,null";  
        SELECT concat(CAST(current_value AS CHAR),",",CAST(increment AS CHAR) ) INTO retval 
          FROM MYCAT_SEQUENCE  WHERE name = seq_name;  
        RETURN retval ; 
END
;;
delimiter ;

-- ----------------------------
-- Function structure for mycat_seq_nextval
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_nextval`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_nextval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN 
         UPDATE MYCAT_SEQUENCE  
                 SET current_value = current_value + increment 
                  WHERE name = seq_name;  
         RETURN mycat_seq_currval(seq_name);  
END
;;
delimiter ;

-- ----------------------------
-- Function structure for mycat_seq_setval
-- ----------------------------
DROP FUNCTION IF EXISTS `mycat_seq_setval`;
delimiter ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_setval`(seq_name VARCHAR(50), value INTEGER) RETURNS varchar(64) CHARSET utf8
    DETERMINISTIC
BEGIN 
         UPDATE MYCAT_SEQUENCE  
                   SET current_value = value  
                   WHERE name = seq_name;  
         RETURN mycat_seq_currval(seq_name);  
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;