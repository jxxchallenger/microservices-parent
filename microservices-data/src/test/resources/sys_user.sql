/*
SQLyog Ultimate
MySQL - 10.1.23-MariaDB 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `sys_user` (
	`id` bigint (20),
	`user_name` varchar (150),
	`user_password` varchar (150),
	`user_email` varchar (150),
	`user_info` text ,
	`head_img` blob ,
	`create_time` datetime 
); 
insert into `sys_user` (`id`, `user_name`, `user_password`, `user_email`, `user_info`, `head_img`, `create_time`) values('10000','admin','123456','admin@qq.com','管理员',NULL,'2018-06-10 11:47:00');
insert into `sys_user` (`id`, `user_name`, `user_password`, `user_email`, `user_info`, `head_img`, `create_time`) values('10001','test','123456','test@qq.com','测试用户',NULL,'2018-06-10 11:47:56');
