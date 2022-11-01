create table if not exists `order` (
    id int auto_increment primary key ,
    order_number varchar(255) default null ,
    order_time datetime default null ,
    order_status int default null ,
    is_close tinyint(1) default null,
    price bigint default null
);