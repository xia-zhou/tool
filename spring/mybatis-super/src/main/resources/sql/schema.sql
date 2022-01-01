DROP TABLE IF EXISTS agent_short_url;
CREATE TABLE `agent_short_url`
(
    `id`           bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
    `agent_id`     bigint(20) unsigned NOT NULL COMMENT '商户ID',
    `name`         varchar(64)         NOT NULL COMMENT '短链名称',
    `source_url`   varchar(512)        NOT NULL DEFAULT '' COMMENT '原地址',
    `source_hash`  bigint(20)          NOT NULL DEFAULT '0' COMMENT '原地址的hash值',
    `short_url`    varchar(64)         NOT NULL DEFAULT '' COMMENT '短链',
    `invalid_time` datetime            NOT NULL COMMENT '短链失效时间',
    `page_view`    bigint(20)          NOT NULL DEFAULT '0' COMMENT 'pv',
    `unique_view`  bigint(20)          NOT NULL DEFAULT '0' COMMENT 'uv',
    `deleted`      tinyint(1)          NOT NULL DEFAULT '0' COMMENT '0-未删除 1-删除',
    `gmt_created`  datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_modified` datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='短链列表';




