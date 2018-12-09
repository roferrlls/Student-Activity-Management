-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: localhost    Database: s
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

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
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Activity`
--

LOCK TABLES `Activity` WRITE;
/*!40000 ALTER TABLE `Activity` DISABLE KEYS */;
INSERT INTO `Activity` VALUES (1,'Sports Quiz','07:30:00','2018-11-09','LT-10','Quiz related to sports','Y16',NULL,'8107970751','Quizzinga',NULL),(2,'Art','09:30:00','2018-11-23','sac','Draw your imageination','all',NULL,'9998887776','Art Club',NULL),(3,'thumb','09:30:00','2018-11-13','sac','Draw your imageination','all',NULL,'9998887776',NULL,NULL),(4,'Dance Competition','07:30:00','2018-11-16','SAC','cultural group event','All',NULL,'8107970751','Insignia',NULL),(5,'Music Competition','07:30:00','2018-11-16','SAC','cultural group event','All',NULL,'8107970751','Capricio',NULL),(6,'MATLAB Workshop','07:30:00','2018-11-12','lt-9','tutorial on MATLAB','Y16',NULL,'8889890184',NULL,'Physics'),(7,'Harshit','11:00:00','2018-11-11','OAT','NONE','Y16',NULL,'8209772735','LC','ECE'),(8,'MegaQuiz','02:00:00','2018-11-16','OAT','Not Rquired','NONE',NULL,'8209772735','Quizzinga','CSE');
/*!40000 ALTER TABLE `Activity` ENABLE KEYS */;
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
INSERT INTO `Contains` VALUES ('J@lnmiita.ac.in',1),('abc@lnmiit.ac.in',2),('abc@lnmiit.ac.in',3),('abcd@lnmiit.ac.in',3);
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
INSERT INTO `Enrolls` VALUES (2,'16ucs06'),(3,'16ucs073'),(3,'16ucs076'),(1,'16ucs082'),(2,'16ucs082'),(1,'16ucs094'),(2,'16ucs094');
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
INSERT INTO `Evaluation` VALUES (1,'16ucs082','J@lnmiita.ac.in',9),(1,'16ucs094','J@lnmiita.ac.in',-5),(2,'16ucs082','J@lnmiita.ac.in',NULL),(2,'16ucs094','J@lnmiita.ac.in',-5),(3,'16ucs094','abc@lnmiit.ac.in',-5),(3,'16ucs094','J@lnmiita.ac.in',-5);
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
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Judge`
--

LOCK TABLES `Judge` WRITE;
/*!40000 ALTER TABLE `Judge` DISABLE KEYS */;
INSERT INTO `Judge` VALUES ('abc@lnmiit.ac.in','J2','123456789'),('abcd@lnmiit.ac.in','J3','123456789'),('abcde@lnmiit.ac.in','J4','123456789'),('abcdef@lnmiit.ac.in','J5','123456789'),('J@lnmiita.ac.in','J1','123456789');
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
  PRIMARY KEY (`Pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Participant`
--

LOCK TABLES `Participant` WRITE;
/*!40000 ALTER TABLE `Participant` DISABLE KEYS */;
INSERT INTO `Participant` VALUES ('16ucs06','16ucs076@lnmiit.ac.in','Harshit','123456789','Y17'),('16ucs073','73@lnmiit.ac.in','hhg','123456789','Y18'),('16ucs076','16ucs076@lnmiit.ac.in','Harshit','123456789','Y15'),('16ucs082','16ucs082@lnmiit.ac.in','Jatin','123456789','Y16'),('16ucs094','16ucs094@lnmiit.ac.in','kritika','123456789','Y16');
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

-- Dump completed on 2018-12-09 16:56:14
