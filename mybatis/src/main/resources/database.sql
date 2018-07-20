create database if not exists `mybatis`;

use mybatis;

drop table if exists `user`;
create table user (
  id            int(11) not null primary key auto_increment,
  username      varchar(32)                  default '',
  password      varchar(255)                 default '',
  email         varchar(64)                  default '',
  register_time datetime                     default current_timestamp,
  login_ip      varchar(32)                  default '',
  login_time    datetime                     default current_timestamp
);

create table role (
  id          int(11) primary key,
  name        varchar(32),
  code        varchar(16) default '',
  create_time datetime    default current_timestamp
);


create table menu (
  id          int(11) primary key,
  name        varchar(32)  default '',
  father_id   int(11)      default null,
  url         varchar(255) default '',
  icon        varchar(64)  default '',
  create_time datetime     default current_timestamp
);