create database shiro;
use shiro;

create table if not exists `users` (
  id       int(11)      auto_increment primary key,
  username varchar(32)  default '',
  password varchar(255) default ''


);

create table if not exists `user_roles` (
  id        int(11)     auto_increment primary key,
  username  varchar(32) default '',
  role_name varchar(32) default ''
);
create table if not exists `roles_permissions` (
  id         int(11)      auto_increment primary key,
  permission varchar(255) default '',
  role_name  varchar(32)  default ''
);


insert into users values (1,'AlbenYuan','password');