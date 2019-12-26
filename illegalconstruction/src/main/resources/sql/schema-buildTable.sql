use wuhan_illegal_construction;
# 创建案件基本信息表
DROP TABLE IF EXISTS case_simple;
CREATE TABLE case_simple
(
    recordnumber VARCHAR(18) NOT NULL COMMENT '记录号，主键ID',
    ADDRESS VARCHAR(250) NULL DEFAULT NULL COMMENT '点位',
    discoverway INT(11) NOT NULL DEFAULT 1 COMMENT '渠道来源',
    a_street INT(11) NULL COMMENT '街道',
    record_date TIMESTAMP NULL COMMENT '记录时间',
    region INT(11)  NULL COMMENT '城区',
    match_ID INT(11) NULL DEFAULT NULL COMMENT '执法情况',
    Approval_progress_a INT(11) NULL DEFAULT NULL COMMENT '审批进展',
    Approval_progress_b INT(11) NULL DEFAULT NULL COMMENT '审批进展',
    addr_map VARCHAR(15) NULL COMMENT '地图坐标',
    PRIMARY KEY (RECORDNUMBER)
);

# 创建用户信息表
drop table if exists UserInfo;
create table UserInfo(
    id int(11) not null comment '用户ID，主键',
    name varchar(15) not null comment '用户名',
    fullName varchar(20) not null comment '区、街道名称',
    powerLevel int(11) not null default 1 comment '权限等级，1=街道，2=区，3=市，4=系统',
    password varchar(38) not null comment '密码',
    primary key (id)
);

# 创建附加信息表
drop  table if exists AppendInfo;
create table AppendInfo(
    id int(11) not null comment '主键ID',
    item varchar(10) not null comment '信息所属项',
    title varchar(20) not null comment '信息内容',
    primary key (id)
);