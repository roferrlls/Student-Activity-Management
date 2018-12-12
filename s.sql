-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: s
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Activity`
--

DROP TABLE IF EXISTS `Activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Activity` (
  `Aid` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Date` date DEFAULT NULL,
  `Venue` varchar(50) DEFAULT NULL,
  `Description` varchar(100) DEFAULT NULL,
  `Expected_Audience` varchar(50) DEFAULT NULL,
  `Result` varchar(50) DEFAULT NULL,
  `Contact_Details` varchar(50) DEFAULT NULL,
  `Club` varchar(20) DEFAULT NULL,
  `Department` varchar(20) DEFAULT NULL,
  `Deadline` date DEFAULT NULL,
  `Seats` int(11) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `Voice` int(11) DEFAULT NULL,
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activity`
--

LOCK TABLES `Activity` WRITE;
/*!40000 ALTER TABLE `Activity` DISABLE KEYS */;
INSERT INTO `Activity` VALUES (1,'Sports Quiz','07:30:00','2018-11-09','LT-10','Quiz related to sports','Y16',NULL,'8107970751','Quizzinga',NULL,NULL,NULL,NULL,NULL),(2,'Art','09:30:00','2018-11-23','sac','Draw your imageination','all',NULL,'9998887776','Art Club',NULL,NULL,NULL,NULL,NULL),(3,'thumb','09:30:00','2018-11-13','sac','Draw your imageination','all',NULL,'9998887776',NULL,NULL,NULL,NULL,NULL,NULL),(4,'Dance Competition','07:30:00','2018-11-16','SAC','cultural group event','All',NULL,'8107970751','Insignia',NULL,NULL,NULL,NULL,NULL),(5,'Music Competition','07:30:00','2018-11-16','SAC','cultural group event','All',NULL,'8107970751','Capricio',NULL,NULL,NULL,NULL,NULL),(6,'MATLAB Workshop','07:30:00','2018-11-12','lt-9','tutorial on MATLAB','Y16',NULL,'8889890184',NULL,'Physics',NULL,NULL,NULL,NULL),(7,'Harshit','11:00:00','2018-11-11','OAT','NONE','Y16',NULL,'8209772735','LC','ECE',NULL,NULL,NULL,NULL),(8,'MegaQuiz','02:00:00','2018-11-16','OAT','Not Rquired','NONE',NULL,'8209772735','Quizzinga','CSE',NULL,NULL,NULL,NULL),(9,'dance',NULL,'2018-12-23','gj',NULL,NULL,NULL,NULL,NULL,NULL,NULL,10,NULL,NULL),(10,'ddddd','07:30:00','2019-01-03','knjjm','nknz','bjnm',NULL,'1234','Quizzinga','CSE',NULL,23,NULL,NULL),(11,'music','08:30:00','2018-12-29','jcdc','cbsakn','cjxb',NULL,'12345','Quizzinga','CSE',NULL,NULL,NULL,NULL),(12,'nukkad','09:30:00','2019-02-11','cjksc','scikjckjd',' cmsn',NULL,'124566378','LC','ECE','2019-10-11',NULL,NULL,NULL),(13,'Nukkad2','10:10:10','2019-11-11','dfd','dfdfdgd','dfdf',NULL,'1234','Quizzinga','CCE',NULL,NULL,NULL,100),(14,'s','10:10:10','2018-11-12','s','s','s',NULL,'1','Quizzinga','CSE',NULL,12,'Male',NULL),(15,'hu','10:10:10','2018-12-29','kdj','cmnd','cnb',NULL,'cbm','Quizzinga','CSE',NULL,NULL,NULL,0),(16,'NEW Actvity','15:17:31','2018-12-14','OAT','3434','none',NULL,'124','Quizzinga','CSE',NULL,NULL,NULL,NULL),(17,'jhj','15:27:52','2018-12-12','defcffr','rftg','fde',NULL,'1','Quizzinga','CSE',NULL,NULL,NULL,NULL),(18,'fg','16:16:36','2018-12-15','avc','sdfg','a',NULL,'1234567890','LC','ECE',NULL,NULL,NULL,NULL),(19,'kkkkkkkkkkkkkddddd','16:48:01','2019-12-20','cccc','cc','cc',NULL,'1234568907','Quizzinga','CSE',NULL,NULL,NULL,NULL),(20,'DJDID','19:23:59','2018-12-08','OAT','dfdgrg','fdfd',NULL,'1234567890','LC','ECE',NULL,NULL,NULL,NULL),(21,'qqq','19:36:05','2018-12-15','qq','q','q',NULL,'1234567890','Quizzinga','CSE',NULL,NULL,NULL,6),(22,'BJBJnuihi','19:57:53','2018-12-28','ij','jijm','ijiuj',NULL,'1234567890','Quizzinga','CSE',NULL,NULL,NULL,NULL),(23,'hk','20:02:25','2018-12-28','OAT','HA','a',NULL,'1234567890','LC','ECE',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AddAct`
--

DROP TABLE IF EXISTS `AddAct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AddAct` (
  `Aid` int(11) NOT NULL,
  `Uid` varchar(50) NOT NULL,
  PRIMARY KEY (`Aid`,`Uid`),
  KEY `Uid` (`Uid`),
  CONSTRAINT `AddAct_ibfk_1` FOREIGN KEY (`Uid`) REFERENCES `AuthorizedUser` (`Uid`),
  CONSTRAINT `AddAct_ibfk_2` FOREIGN KEY (`Aid`) REFERENCES `Activity` (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AddAct`
--

LOCK TABLES `AddAct` WRITE;
/*!40000 ALTER TABLE `AddAct` DISABLE KEYS */;
INSERT INTO `AddAct` VALUES (7,'16ucs076'),(2,'muk'),(18,'muk'),(19,'muk'),(20,'muk'),(21,'muk'),(22,'muk'),(23,'muk');
/*!40000 ALTER TABLE `AddAct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AuthorizedUser`
--

DROP TABLE IF EXISTS `AuthorizedUser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AuthorizedUser` (
  `Uid` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Uid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AuthorizedUser`
--

LOCK TABLES `AuthorizedUser` WRITE;
/*!40000 ALTER TABLE `AuthorizedUser` DISABLE KEYS */;
INSERT INTO `AuthorizedUser` VALUES ('16ucs076','Harshit','123'),('muk','chutiya','1');
/*!40000 ALTER TABLE `AuthorizedUser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Contains`
--

DROP TABLE IF EXISTS `Contains`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Contains` (
  `Judge_Email` varchar(50) NOT NULL,
  `Aid` int(11) NOT NULL,
  PRIMARY KEY (`Judge_Email`,`Aid`),
  KEY `Aid` (`Aid`),
  CONSTRAINT `Contains_ibfk_1` FOREIGN KEY (`Judge_Email`) REFERENCES `Judge` (`Email`),
  CONSTRAINT `Contains_ibfk_2` FOREIGN KEY (`Aid`) REFERENCES `Activity` (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contains`
--

LOCK TABLES `Contains` WRITE;
/*!40000 ALTER TABLE `Contains` DISABLE KEYS */;
INSERT INTO `Contains` VALUES ('J@lnmiita.ac.in',1),('abc@lnmiit.ac.in',2),('abc@lnmiit.ac.in',3),('abcd@lnmiit.ac.in',3),('abc@lnmiit.ac.in  ',22);
/*!40000 ALTER TABLE `Contains` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enrolls`
--

DROP TABLE IF EXISTS `Enrolls`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Enrolls` (
  `Aid` int(11) NOT NULL,
  `Pid` varchar(50) NOT NULL,
  `Rating` int(11) DEFAULT NULL,
  PRIMARY KEY (`Aid`,`Pid`),
  KEY `Pid` (`Pid`),
  CONSTRAINT `Enrolls_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `Participant` (`Pid`),
  CONSTRAINT `Enrolls_ibfk_2` FOREIGN KEY (`Aid`) REFERENCES `Activity` (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enrolls`
--

LOCK TABLES `Enrolls` WRITE;
/*!40000 ALTER TABLE `Enrolls` DISABLE KEYS */;
INSERT INTO `Enrolls` VALUES (1,'16ucs082',NULL),(1,'16ucs094',NULL),(2,'16ucs06',NULL),(2,'16ucs082',5),(2,'16ucs094',2),(3,'16ucs073',NULL),(3,'16ucs076',NULL);
/*!40000 ALTER TABLE `Enrolls` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Evaluation`
--

DROP TABLE IF EXISTS `Evaluation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Evaluation` (
  `Aid` int(11) NOT NULL,
  `Pid` varchar(50) NOT NULL,
  `Judge_Email` varchar(50) NOT NULL,
  `Score` int(11) DEFAULT NULL,
  `Remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Aid`,`Pid`,`Judge_Email`),
  KEY `Pid` (`Pid`),
  KEY `Judge_Email` (`Judge_Email`),
  CONSTRAINT `Evaluation_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `Participant` (`Pid`),
  CONSTRAINT `Evaluation_ibfk_2` FOREIGN KEY (`Aid`) REFERENCES `Activity` (`Aid`),
  CONSTRAINT `Evaluation_ibfk_3` FOREIGN KEY (`Judge_Email`) REFERENCES `Judge` (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Evaluation`
--

LOCK TABLES `Evaluation` WRITE;
/*!40000 ALTER TABLE `Evaluation` DISABLE KEYS */;
INSERT INTO `Evaluation` VALUES (2,'16ucs082','abc@lnmiit.ac.in',10,'kghh'),(2,'16ucs094','abc@lnmiit.ac.in  ',-5,'NONE');
/*!40000 ALTER TABLE `Evaluation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Judge`
--

DROP TABLE IF EXISTS `Judge`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Judge` (
  `Email` varchar(50) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `PhoneNumber` varchar(10) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Judge`
--

LOCK TABLES `Judge` WRITE;
/*!40000 ALTER TABLE `Judge` DISABLE KEYS */;
INSERT INTO `Judge` VALUES ('abc@lnmiit.ac.in','J2','123456789',NULL),('abcd@lnmiit.ac.in','J3','123456789',NULL),('abcde@lnmiit.ac.in','J4','123456789',NULL),('abcdef@lnmiit.ac.in','J5','123456789',NULL),('J@lnmiita.ac.in','J1','123456789',NULL);
/*!40000 ALTER TABLE `Judge` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Participant`
--

DROP TABLE IF EXISTS `Participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Participant` (
  `Pid` varchar(50) NOT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `PhoneNumber` varchar(10) DEFAULT NULL,
  `Batch` varchar(10) DEFAULT NULL,
  `Password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Participant`
--

LOCK TABLES `Participant` WRITE;
/*!40000 ALTER TABLE `Participant` DISABLE KEYS */;
INSERT INTO `Participant` VALUES ('16ucs06','16ucs076@lnmiit.ac.in','Harshit','123456789','Y17',NULL),('16ucs073','73@lnmiit.ac.in','hhg','123456789','Y18',NULL),('16ucs076','16ucs076@lnmiit.ac.in','Harshit','123456789','Y15',NULL),('16ucs082','16ucs082@lnmiit.ac.in','Jatin','123456789','Y16','123'),('16ucs094','16ucs094@lnmiit.ac.in','kritika','123456789','Y16','1');
/*!40000 ALTER TABLE `Participant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-13  0:23:10
