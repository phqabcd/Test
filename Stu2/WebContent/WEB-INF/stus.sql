/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.20-log : Database - stus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`stus` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `stus`;

/*Table structure for table `stu` */

DROP TABLE IF EXISTS `stu`;

CREATE TABLE `stu` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `sname` varchar(20) DEFAULT NULL,
  `gender` varchar(5) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `hobby` varchar(50) DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `stu` */

insert  into `stu`(`sid`,`sname`,`gender`,`phone`,`birthday`,`hobby`,`info`) values (1,'a',NULL,NULL,NULL,NULL,NULL),(2,'b',NULL,NULL,NULL,NULL,NULL),(3,'c',NULL,NULL,NULL,NULL,NULL),(4,'d',NULL,NULL,NULL,NULL,NULL),(5,'e',NULL,NULL,NULL,NULL,NULL),(6,'f',NULL,NULL,NULL,NULL,NULL),(7,'g',NULL,NULL,NULL,NULL,NULL),(8,'h',NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
