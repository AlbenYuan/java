CREATE DATABASE IF NOT EXISTS `mybatis`;

USE mybatis;

DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
  id            INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  username      VARCHAR(32)                  DEFAULT '',
  password      VARCHAR(255)                 DEFAULT '',
  email         VARCHAR(64)                  DEFAULT '',
  state         INT(2)                       DEFAULT 0,
  register_time DATETIME                     DEFAULT current_timestamp,
  login_ip      VARCHAR(32)                  DEFAULT '',
  login_time    DATETIME                     DEFAULT current_timestamp
);

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  id          INT(11) PRIMARY KEY AUTO_INCREMENT,
  user_id     INT(11)             DEFAULT NULL,
  role_id     INT(11)             DEFAULT NULL,
  state       INT(2)              DEFAULT 0,
  create_time DATETIME            DEFAULT current_timestamp,
  update_time DATETIME            DEFAULT current_timestamp
  ON UPDATE current_timestamp
);
DROP TABLE IF EXISTS `role`;
CREATE TABLE role (
  id          INT(11) PRIMARY KEY,
  name        VARCHAR(32),
  code        VARCHAR(16) DEFAULT '',
  create_time DATETIME    DEFAULT current_timestamp
);

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  id          INT(11) PRIMARY KEY AUTO_INCREMENT,
  role_id     INT(11)             DEFAULT NULL,
  menu_id     INT(11)             DEFAULT NULL,
  state       INT(2)              DEFAULT 0,
  create_time DATETIME            DEFAULT current_timestamp,
  update_time DATETIME            DEFAULT current_timestamp
  ON UPDATE current_timestamp
);

DROP TABLE IF EXISTS `menu`;
CREATE TABLE menu (
  id           INT(11) PRIMARY KEY,
  name         VARCHAR(32)  DEFAULT '',
  is_directory BIT(1)       DEFAULT FALSE,
  father_id    INT(11)      DEFAULT NULL,
  url          VARCHAR(255) DEFAULT '',
  icon         VARCHAR(64)  DEFAULT '',
  create_time  DATETIME     DEFAULT current_timestamp
);