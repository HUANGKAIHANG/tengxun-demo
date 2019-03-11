drop table t_v if exists;

create table t_v (
    id bigint auto_increment,
    create_time timestamp,
    update_time timestamp,
    val bigint,
);