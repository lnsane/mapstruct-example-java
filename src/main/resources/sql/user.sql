create table if not exists `user` (
    id int auto_increment primary key ,
    user_name varchar(60) null,
    age int null,
    start_time datetime null
);