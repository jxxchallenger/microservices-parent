
CREATE TABLE `continent` (
  `id` int(4) NOT NULL COMMENT '主键',
  `short_name_cn` varchar(20) DEFAULT NULL COMMENT '名称',
  `full_name_cn` varchar(50) DEFAULT NULL COMMENT '中文全称',
  `short_name_en` varchar(25) DEFAULT NULL COMMENT '英文简称',
  `full_name_en` varchar(50) DEFAULT NULL COMMENT '英文全称',
  `code` varchar(20) DEFAULT NULL COMMENT '编码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='世界七大洲表'


CREATE TABLE `country_region` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `short_name_cn` varchar(50) NOT NULL COMMENT '国家中文名简称',
  `full_name_cn` varchar(100) DEFAULT NULL COMMENT '国家中文名全称',
  `short_name_en` varchar(100) DEFAULT NULL COMMENT '国家英文名简称',
  `full_name_en` varchar(150) DEFAULT NULL COMMENT '国家英文名全称',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `continent_id` int(11) DEFAULT NULL COMMENT '所属洲id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=339000001 DEFAULT CHARSET=utf8


CREATE TABLE `state` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '省州郡',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `cr_id` int(11) DEFAULT NULL COMMENT '国家地区id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='省州郡表'

CREATE TABLE `city` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '市区名称',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `state_id` int(11) DEFAULT NULL COMMENT '省份州郡id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='市区表'


CREATE TABLE `region` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(30) DEFAULT NULL COMMENT '县名称',
  `code` varchar(10) DEFAULT NULL COMMENT '代码',
  `city_id` int(11) DEFAULT NULL COMMENT '所属市id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='县区表'
