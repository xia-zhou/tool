-- mysql 表结构初始化
create table area
(
    id   int unsigned NOT NULL AUTO_INCREMENT,
    code varchar(16) NOT NULL COMMENT '编码',
    name varchar(16) NOT NULL COMMENT '名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='省市区区域表';