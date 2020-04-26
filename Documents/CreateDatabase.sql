-- Run AS root/Admin TO CREATE the Databases

DROP database IF EXISTS jmypicture;
CREATE database jmypicture
	CHARACTER SET = "utf8"
	COLLATE = "utf8_general_ci";

drop database if exists vpictures;
create database vpictures
	CHARACTER SET = "utf8"
	COLLATE = "utf8_general_ci";

USE jmypicture;
DROP USER IF EXISTS `adm_jmypicture`;
-- password('qK99bD@mcjt')
GRANT ALL PRIVILEGES ON jmypicture.* TO `adm_jmypicture`@`localhost` identified BY password '*D8659C13D267DF41277E1E8AA527D428FE534ED1';
GRANT ALL PRIVILEGES ON vpictures.* TO `adm_jmypicture`@`localhost`;

-- GRANT ALL PRIVILEGES ON *.* TO `root`@`localhost`;
