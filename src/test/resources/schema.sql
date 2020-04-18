CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT 'name',
  `age` int(10) NOT NULL DEFAULT 0 COMMENT 'age',
  `create_time` bigint(20) unsigned NOT NULL COMMENT 'create time',
  `update_time` bigint(20) unsigned NOT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
);
