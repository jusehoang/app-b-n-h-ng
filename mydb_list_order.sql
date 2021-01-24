-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.7.28-log

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
-- Table structure for table `list_order`
--

DROP TABLE IF EXISTS `list_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_order` (
  `idlist_order` int(11) NOT NULL AUTO_INCREMENT,
  `soluong` int(11) NOT NULL,
  `dongia` int(11) NOT NULL,
  `monan_idmonan` int(11) DEFAULT NULL,
  `hoadon_idhoadon` int(11) NOT NULL,
  PRIMARY KEY (`idlist_order`,`hoadon_idhoadon`),
  UNIQUE KEY `idlist_order_UNIQUE` (`idlist_order`),
  KEY `fk_list_order_monan_idx` (`monan_idmonan`),
  KEY `fk_list_order_hoadon1_idx` (`hoadon_idhoadon`),
  CONSTRAINT `fk_list_order_hoadon1` FOREIGN KEY (`hoadon_idhoadon`) REFERENCES `hoadon` (`idhoadon`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_list_order_monan` FOREIGN KEY (`monan_idmonan`) REFERENCES `monan` (`idmonan`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_order`
--

LOCK TABLES `list_order` WRITE;
/*!40000 ALTER TABLE `list_order` DISABLE KEYS */;
INSERT INTO `list_order` VALUES (1,1,30000,1,1),(2,1,20000,2,1),(3,1,25000,3,1),(4,1,30000,1,2),(5,1,30000,1,5),(6,1,20000,2,5),(7,1,25000,3,5),(8,0,0,1,5),(9,1,30000,1,5),(10,1,30000,1,10),(11,1,20000,2,10),(12,3,75000,3,10),(13,1,30000,1,13),(14,6,180000,1,14),(15,2,60000,1,15),(16,2,60000,1,16),(17,2,50000,3,18),(18,1,25000,3,19),(19,2,40000,2,20),(20,3,90000,1,21),(21,3,90000,1,22),(22,3,60000,2,22),(23,3,60000,2,23),(24,2,40000,2,24),(25,2,50000,3,24),(26,3,90000,1,26),(27,2,60000,1,27),(28,14,420000,1,28),(29,4,80000,2,31),(30,1,30000,1,34);
/*!40000 ALTER TABLE `list_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-25 13:39:07
