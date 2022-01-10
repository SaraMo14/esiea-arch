-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: usermanagedb
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(255) NOT NULL,
  `activated` bit(1) DEFAULT NULL,
  `creation_date` datetime(6) DEFAULT NULL,
  `end_date` datetime(6) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FK7m8ru44m93ukyb61dfxw0apf6` (`user_id`),
  CONSTRAINT `FK7m8ru44m93ukyb61dfxw0apf6` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('admin123',_binary '','2022-01-04 17:47:38.002000','2022-01-04 17:47:38.002000','$2a$10$CwZtG1zDQpTbr0fPmBa7geia3O0lHE2.o9U9oi4Fl3gSDA4CaH3SC','admin',NULL),('carl_account',_binary '\0','2000-01-01 01:00:00.000000','2001-02-10 01:00:00.000000','$2a$10$dN6lIEChr/0XcR1W5LPhvudMpyK7bR52nBVcjMqvQ//bTlEcCy7Xi','standard',21),('carl_user',_binary '','2000-02-02 01:00:00.000000','2030-02-02 01:00:00.000000','$2a$10$t0x5q/k7HknjqyD5Ojpbiuxso4RScfcmX2AZ./WXi3zaGnf0hxSgK','standard',21),('claire_username',_binary '','2000-02-02 01:00:00.000000','2022-02-01 01:00:00.000000','$2a$10$gUjhaQOr70NAyMO3rilMKulJLbD8mo34IKlA3.9JB8fkW/XlfYVF.','standard',13),('mario_username',_binary '','2022-01-09 01:00:00.000000','2022-01-31 01:00:00.000000','$2a$10$6jlwTpZuBkmrkYK7Zig97eG/GIhoHZUbtfmAVBS3CbZt7LliRV1Mq','admin',25),('mario_username2',_binary '','2022-01-11 01:00:00.000000','2022-02-25 01:00:00.000000','$2a$10$QjRQ04FV251WfZPF3Mq8n.dJqNPFldp8Pxk11am.mOTwjhtwp6dOO','standard',25),('standard123',_binary '\0','2022-01-04 17:47:38.196000','2022-01-04 17:47:38.196000','$2a$10$w50AfDwhGh.eVei1RxvUEOTGsKDbxKeNBy/4N.fuwamgF9DrF.1Re','standard',14),('standard345',_binary '\0','2022-01-04 17:50:42.338000','2022-01-04 17:50:42.338000','$2a$10$iDbVUSGs/0M6knWYlmTWBecGPrl5ZnKWT2G1nBAFPEIjBeO2kpc0O','standard',14);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-10 20:03:46
