-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: big_task
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id_city` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Batumi'),(2,'Qutaisi'),(3,'Tbilisi'),(4,'teeeeest');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `distances`
--

DROP TABLE IF EXISTS `distances`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `distances` (
  `station_id_1` int NOT NULL,
  `station_id_2` int NOT NULL,
  `distance` int DEFAULT NULL,
  PRIMARY KEY (`station_id_1`,`station_id_2`),
  KEY `fk_Stations_has_Stations_Stations2_idx` (`station_id_2`),
  KEY `fk_Stations_has_Stations_Stations1_idx` (`station_id_1`),
  CONSTRAINT `fk_Stations_has_Stations_Stations1` FOREIGN KEY (`station_id_1`) REFERENCES `stations` (`id_stations`),
  CONSTRAINT `fk_Stations_has_Stations_Stations2` FOREIGN KEY (`station_id_2`) REFERENCES `stations` (`id_stations`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `distances`
--

LOCK TABLES `distances` WRITE;
/*!40000 ALTER TABLE `distances` DISABLE KEYS */;
INSERT INTO `distances` VALUES (1,1,0),(2,1,5),(2,2,0),(2,3,235),(3,1,999999),(3,2,235),(3,3,0),(3,4,12),(3,5,217),(3,6,999999),(3,7,999999),(4,1,999999),(4,2,999999),(4,3,12),(4,4,0),(4,5,999999),(4,6,999999),(4,7,999999),(5,1,999999),(5,2,999999),(5,3,217),(5,4,999999),(5,5,0),(5,6,25),(5,7,11),(6,1,999999),(6,2,999999),(6,3,999999),(6,4,999999),(6,5,25),(6,6,0),(6,7,18),(7,1,999999),(7,2,999999),(7,3,999999),(7,4,999999),(7,5,11),(7,6,18),(7,7,0);
/*!40000 ALTER TABLE `distances` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stations`
--

DROP TABLE IF EXISTS `stations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stations` (
  `id_stations` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `city_id` int NOT NULL,
  PRIMARY KEY (`id_stations`),
  KEY `fk_Stations_City_idx` (`city_id`),
  CONSTRAINT `fk_Stations_City` FOREIGN KEY (`city_id`) REFERENCES `city` (`id_city`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stations`
--

LOCK TABLES `stations` WRITE;
/*!40000 ALTER TABLE `stations` DISABLE KEYS */;
INSERT INTO `stations` VALUES (1,'sadguri',1),(2,'plaza',1),(3,'maki',2),(4,'bikentia',2),(5,'didube',3),(6,'ortachala',3),(7,'station_square',3);
/*!40000 ALTER TABLE `stations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transport` (
  `transport_id` int NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `speed` int DEFAULT NULL,
  PRIMARY KEY (`transport_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transport`
--

LOCK TABLES `transport` WRITE;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
INSERT INTO `transport` VALUES (1,'car',80),(2,'bus',60),(3,'minibus',70);
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-02-14 15:26:37
