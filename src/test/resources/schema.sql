CREATE TABLE if not exists `user`(
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(64) NOT NULL COMMENT 'name',
  `age` int(10) NOT NULL DEFAULT 0 COMMENT 'age',
  `create_time` bigint(20) unsigned NOT NULL COMMENT 'create time',
  `update_time` bigint(20) unsigned NOT NULL COMMENT 'update time',
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
);

CREATE TABLE if not exists `product`(
   `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
   `name` VARCHAR(50) NOT NULL COMMENT '名称',
   `stock` INT(11) NOT NULL DEFAULT 0 COMMENT '库存',
   `price` DECIMAL(10 , 2 ) NOT NULL COMMENT '价格',
   `create_time` bigint(20) unsigned NOT NULL COMMENT 'create time',
   `update_time` bigint(20) unsigned NOT NULL COMMENT 'update time',
   PRIMARY KEY (`id`)
);

CREATE TABLE if not exists `orders`(
     `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
     `product_id` bigint(20) NOT NULL COMMENT '商品id',
     `amount` DECIMAL(10 , 2 ) NOT NULL COMMENT '总金额',
     `create_time` bigint(20) unsigned NOT NULL COMMENT 'create time',
     `update_time` bigint(20) unsigned NOT NULL COMMENT 'update time',
     PRIMARY KEY (`id`)
);
