-- mysqldump -uroot -pMYSQL_ROOT_PASSWORD --no-data MYSQL_DATABASE > schema.sql
DROP TABLE IF EXISTS `SPRING_SESSION_ATTRIBUTES`;
DROP TABLE IF EXISTS `SPRING_SESSION`;
DROP TABLE IF EXISTS `user_authority`;
DROP TABLE IF EXISTS `header`;
DROP TABLE IF EXISTS `authority`;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `SPRING_SESSION` (
  `PRIMARY_ID` varchar(36) NOT NULL,
  `SESSION_ID` varchar(36) NOT NULL,
  `CREATION_TIME` bigint NOT NULL,
  `LAST_ACCESS_TIME` bigint NOT NULL,
  `MAX_INACTIVE_INTERVAL` bigint NOT NULL,
  `EXPIRY_TIME` bigint NOT NULL,
  `PRINCIPAL_NAME` varchar(100),
  PRIMARY KEY (`PRIMARY_ID`),
  UNIQUE KEY (`SESSION_ID`),
  KEY (`EXPIRY_TIME`),
  KEY (`PRINCIPAL_NAME`)
);
CREATE TABLE `SPRING_SESSION_ATTRIBUTES` (
  `SESSION_PRIMARY_ID` varchar(36) NOT NULL,
  `ATTRIBUTE_NAME` varchar(200) NOT NULL,
  `ATTRIBUTE_BYTES` blob NOT NULL,
  PRIMARY KEY (`SESSION_PRIMARY_ID`, `ATTRIBUTE_NAME`),
  FOREIGN KEY (`SESSION_PRIMARY_ID`) REFERENCES `SPRING_SESSION` (`PRIMARY_ID`) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS `authority` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `authority` varchar(255) NOT NULL,
  `order` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`authority`),
  KEY (`order`)
);
CREATE TABLE IF NOT EXISTS `header` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `header` varchar(255) NOT NULL,
  `src` varchar(255) NOT NULL,
  `authority_id` bigint,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE CASCADE
);
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`username`)
);
CREATE TABLE IF NOT EXISTS `user_authority` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `user_id` bigint NOT NULL,
  `authority_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`user_id`, `authority_id`),
  FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`) ON DELETE CASCADE,
  FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
);