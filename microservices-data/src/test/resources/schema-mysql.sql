
CREATE TABLE `continent` (
  `id` int(4) NOT NULL COMMENT '主键',
  `short_name_cn` varchar(20) DEFAULT NULL COMMENT '名称',
  `full_name_cn` varchar(50) DEFAULT NULL COMMENT '中文全称',
  `short_name_en` varchar(25) DEFAULT NULL COMMENT '英文简称',
  `full_name_en` varchar(50) DEFAULT NULL COMMENT '英文全称',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='世界七大洲表';


CREATE TABLE `country_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `short_name_cn` varchar(50) NOT NULL COMMENT '国家中文名简称',
  `full_name_cn` varchar(100) DEFAULT NULL COMMENT '国家中文名全称',
  `short_name_en` varchar(100) DEFAULT NULL COMMENT '国家英文名简称',
  `full_name_en` varchar(150) DEFAULT NULL COMMENT '国家英文名全称',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `continent_id` int(11) DEFAULT NULL COMMENT '所属洲id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=339000001 DEFAULT CHARSET=utf8;


CREATE TABLE `state` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '省州郡',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `cr_id` int(11) DEFAULT NULL COMMENT '国家地区id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省州郡表';

CREATE TABLE `city` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '市区名称',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `state_id` int(11) DEFAULT NULL COMMENT '省份州郡id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='市区表';


CREATE TABLE `region` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '县名称',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `city_id` int(11) DEFAULT NULL COMMENT '所属市id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='县区表';

CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `user_password` varchar(50) DEFAULT NULL COMMENT '密码',
  `user_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_info` text COMMENT '简介',
  `head_img` blob COMMENT '头像',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10008 DEFAULT CHARSET=utf8 COMMENT='用户表';

CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `enabled` tinyint(4) DEFAULT NULL COMMENT '有效标示符',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8 COMMENT='角色表';

CREATE TABLE `sys_privilege` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `privilege_name` varchar(50) DEFAULT NULL COMMENT '权限名称',
  `privilege_url` varchar(200) DEFAULT NULL COMMENT '权限URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8 COMMENT='权限表';

CREATE TABLE `sys_user_role` (
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_role_privilege` (
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `privilege_id` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关系表';