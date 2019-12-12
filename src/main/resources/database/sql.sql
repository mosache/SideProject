#create database
create database if not exists vDataBase DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci;

use vDataBase;

#t_user
create table if not exists `t_user` (
    `id` integer primary key auto_increment,
    `username` varchar(20) not null ,
    `password` varchar(50) not null ,
    `create_time` integer NOT NULL

) ENGINE=InnoDB DEFAULT CHARSET = utf8mb4;


