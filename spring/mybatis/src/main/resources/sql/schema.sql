-- h2 表结构初始化
create table area
(
    id          int not null auto_increment,
    code        varchar(16),
    name        varchar(16),
    code_name   varchar(16),
    create_time timestamp,
    update_time timestamp
);