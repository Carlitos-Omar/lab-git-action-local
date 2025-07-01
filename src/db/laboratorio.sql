/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19  Distrib 10.11.11-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: laboratorio_isa
-- ------------------------------------------------------
-- Server version	10.11.11-MariaDB-0+deb12u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas` (
  `id_area` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES
(1,'Hematologia');
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratorista`
--

DROP TABLE IF EXISTS `laboratorista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratorista` (
  `id_laboratorista` bigint(20) NOT NULL AUTO_INCREMENT,
  `contraseña` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `turno` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_laboratorista`),
  KEY `FKjkvldeh432oteao8iiif2aqef` (`id_usuario`),
  CONSTRAINT `FKjkvldeh432oteao8iiif2aqef` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratorista`
--

LOCK TABLES `laboratorista` WRITE;
/*!40000 ALTER TABLE `laboratorista` DISABLE KEYS */;
INSERT INTO `laboratorista` VALUES
(1,'clave123','luis.ramos@lab.com','2025-06-28 22:58:20.000000','2025-06-28 22:58:20.000000','Mañana',3);
/*!40000 ALTER TABLE `laboratorista` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicos` (
  `id_medico` bigint(20) NOT NULL AUTO_INCREMENT,
  `especialidad` varchar(255) DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_medico`),
  KEY `FKhei0g6fy15d5komevfsk1qepe` (`id_usuario`),
  CONSTRAINT `FKhei0g6fy15d5komevfsk1qepe` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` VALUES
(1,'cardiologia','2025-06-28 16:07:35.000000','2025-06-28 16:07:35.000000',2);
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenes`
--

DROP TABLE IF EXISTS `ordenes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenes` (
  `id_orden` bigint(20) NOT NULL AUTO_INCREMENT,
  `codigo_orden` varchar(30) NOT NULL,
  `estado` enum('COMPLETADA','PENDIENTE') DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `id_paciente` bigint(20) NOT NULL,
  `id_laboratorista` bigint(20) NOT NULL,
  `id_medico` bigint(20) NOT NULL,
  PRIMARY KEY (`id_orden`),
  UNIQUE KEY `UKkg305gu6d8kfjvn1dlxymanl4` (`codigo_orden`),
  KEY `FKhy1xt3e55q8vet4lta6sfl7au` (`id_paciente`),
  KEY `FKpfwjbka9867tps7c2iew0nmgj` (`id_laboratorista`),
  KEY `FK9277354waxs3tmid4eednage5` (`id_medico`),
  CONSTRAINT `FK9277354waxs3tmid4eednage5` FOREIGN KEY (`id_medico`) REFERENCES `medicos` (`id_medico`),
  CONSTRAINT `FKhy1xt3e55q8vet4lta6sfl7au` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`),
  CONSTRAINT `FKpfwjbka9867tps7c2iew0nmgj` FOREIGN KEY (`id_laboratorista`) REFERENCES `laboratorista` (`id_laboratorista`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenes`
--

LOCK TABLES `ordenes` WRITE;
/*!40000 ALTER TABLE `ordenes` DISABLE KEYS */;
INSERT INTO `ordenes` VALUES
(1,'ORD-0001','PENDIENTE','2025-06-28 23:02:44.000000','2025-06-28 23:02:44.000000',1,1,1);
/*!40000 ALTER TABLE `ordenes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_details`
--

DROP TABLE IF EXISTS `orders_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders_details` (
  `id_orden_detalle` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `id_orden` bigint(20) DEFAULT NULL,
  `id_parametro` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_orden_detalle`),
  KEY `FKj7vh02jo9wh3ap72tqu4hp9yo` (`id_parametro`),
  KEY `FK33ar4211rw3na65dvl9nnbg77` (`id_orden`),
  CONSTRAINT `FK33ar4211rw3na65dvl9nnbg77` FOREIGN KEY (`id_orden`) REFERENCES `ordenes` (`id_orden`),
  CONSTRAINT `FKj7vh02jo9wh3ap72tqu4hp9yo` FOREIGN KEY (`id_parametro`) REFERENCES `parametros` (`id_parametro`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_details`
--

LOCK TABLES `orders_details` WRITE;
/*!40000 ALTER TABLE `orders_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pacientes`
--

DROP TABLE IF EXISTS `pacientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `pacientes` (
  `id_paciente` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `numero_historia` varchar(255) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_paciente`),
  KEY `FK34je9ip2cpgvy3m4ove9lmmqk` (`id_usuario`),
  CONSTRAINT `FK34je9ip2cpgvy3m4ove9lmmqk` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pacientes`
--

LOCK TABLES `pacientes` WRITE;
/*!40000 ALTER TABLE `pacientes` DISABLE KEYS */;
INSERT INTO `pacientes` VALUES
(1,'2025-06-28 16:02:04.000000','2025-06-28 16:02:04.000000','001',1);
/*!40000 ALTER TABLE `pacientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `parametros` (
  `id_parametro` bigint(20) NOT NULL AUTO_INCREMENT,
  `es_analisis` bit(1) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `id_unidad` bigint(20) NOT NULL,
  PRIMARY KEY (`id_parametro`),
  KEY `FKs5uk4ruvlpsstdybgsf8j1ehi` (`id_unidad`),
  CONSTRAINT `FKs5uk4ruvlpsstdybgsf8j1ehi` FOREIGN KEY (`id_unidad`) REFERENCES `unidades` (`id_unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` VALUES
(1,'','Hemoglobina',2),
(2,'\0','Hematocrito',3),
(3,'\0','Linfocitos',3),
(4,'\0','Monocitos',3),
(5,'\0','VCM',4),
(6,'\0','Eosinófilos',3),
(7,'\0','Basófilos',3),
(8,'\0','Neutrófilos',3),
(9,'\0','CHGM',2),
(10,'\0','RDW',3),
(11,'\0','Hematíes',5),
(12,'\0','Plaquetas',6),
(13,'\0','Granulocitos',3),
(14,'\0','Prueba de Parametro 001 editado',3);
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil_parametro`
--

DROP TABLE IF EXISTS `perfil_parametro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil_parametro` (
  `id_perfil_parametro` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_parametro` bigint(20) NOT NULL,
  `id_perfil` bigint(20) NOT NULL,
  PRIMARY KEY (`id_perfil_parametro`),
  KEY `FKt2t6bsgmc9cwimdnsmjsspceh` (`id_parametro`),
  KEY `FKtj3sqpvt8ymh9juivwwu9ictc` (`id_perfil`),
  CONSTRAINT `FKt2t6bsgmc9cwimdnsmjsspceh` FOREIGN KEY (`id_parametro`) REFERENCES `parametros` (`id_parametro`),
  CONSTRAINT `FKtj3sqpvt8ymh9juivwwu9ictc` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id_perfil`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_parametro`
--

LOCK TABLES `perfil_parametro` WRITE;
/*!40000 ALTER TABLE `perfil_parametro` DISABLE KEYS */;
INSERT INTO `perfil_parametro` VALUES
(1,1,1),
(2,2,1),
(3,3,1),
(4,4,1),
(5,5,1),
(6,6,1),
(7,7,1),
(8,8,1),
(9,9,1),
(10,10,1),
(11,11,1),
(12,12,1),
(13,13,1),
(14,14,1);
/*!40000 ALTER TABLE `perfil_parametro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `id_perfil` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  `id_area` bigint(20) NOT NULL,
  PRIMARY KEY (`id_perfil`),
  KEY `FKqu4ccag9q7pj97r8o997uihb0` (`id_area`),
  CONSTRAINT `FKqu4ccag9q7pj97r8o997uihb0` FOREIGN KEY (`id_area`) REFERENCES `areas` (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES
(1,'Hemograma',1);
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `results`
--

DROP TABLE IF EXISTS `results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `results` (
  `id_resultado` bigint(20) NOT NULL AUTO_INCREMENT,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_registro` datetime(6) DEFAULT NULL,
  `valor_resultado` varchar(255) DEFAULT NULL,
  `id_laboratorista` bigint(20) DEFAULT NULL,
  `id_orden_detalle` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id_resultado`),
  KEY `FKdfop4en6omrcgmisto9ek9ffa` (`id_laboratorista`),
  KEY `FKnqw8gp0lo9cib2fhhxs5ncafi` (`id_orden_detalle`),
  CONSTRAINT `FKdfop4en6omrcgmisto9ek9ffa` FOREIGN KEY (`id_laboratorista`) REFERENCES `laboratorista` (`id_laboratorista`),
  CONSTRAINT `FKnqw8gp0lo9cib2fhhxs5ncafi` FOREIGN KEY (`id_orden_detalle`) REFERENCES `orders_details` (`id_orden_detalle`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `results`
--

LOCK TABLES `results` WRITE;
/*!40000 ALTER TABLE `results` DISABLE KEYS */;
/*!40000 ALTER TABLE `results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidades`
--

DROP TABLE IF EXISTS `unidades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidades` (
  `id_unidad` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_unidad`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidades`
--

LOCK TABLES `unidades` WRITE;
/*!40000 ALTER TABLE `unidades` DISABLE KEYS */;
INSERT INTO `unidades` VALUES
(1,'mg/dL'),
(2,'g/dL'),
(3,'%'),
(4,'fL'),
(5,'x10⁶/µL'),
(6,'x10³/µL');
/*!40000 ALTER TABLE `unidades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creacion` datetime(6) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `tipo_usuario` enum('ADMINISTRADOR','LABORATORISTA','MEDICO','PACIENTE') DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES
(1,'Garcia Santos','75091375','2005-03-24','2025-06-28 16:02:04.000000','2025-06-28 16:02:04.000000','Carlos ','M','987654321','PACIENTE'),
(2,'Perez Nieto','87654312','1980-02-24','2025-06-28 16:07:59.000000','2025-06-28 16:07:35.000000','Juan Gabriel','M','987654322','MEDICO'),
(3,'Torres','76543210','1995-10-20','2025-06-28 22:58:19.000000','2025-06-28 22:58:19.000000','Manuel','M','987654321','LABORATORISTA');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `valores_referencia`
--

DROP TABLE IF EXISTS `valores_referencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8mb4 */;
CREATE TABLE `valores_referencia` (
  `id_valor_referencia` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(255) NOT NULL,
  `fecha_actualizacion` datetime(6) DEFAULT NULL,
  `fecha_creaccion` datetime(6) NOT NULL,
  `id_parametro` bigint(20) NOT NULL,
  PRIMARY KEY (`id_valor_referencia`),
  KEY `FKlt145emqvv7xef1cqjfm7st4t` (`id_parametro`),
  CONSTRAINT `FKlt145emqvv7xef1cqjfm7st4t` FOREIGN KEY (`id_parametro`) REFERENCES `parametros` (`id_parametro`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `valores_referencia`
--

LOCK TABLES `valores_referencia` WRITE;
/*!40000 ALTER TABLE `valores_referencia` DISABLE KEYS */;
INSERT INTO `valores_referencia` VALUES
(1,'Hemoglobina normal: 13-17 g/dL','2025-06-27 21:30:04.000000','2025-06-21 17:15:00.000000',1),
(2,'prueba 1','2025-06-28 20:18:05.000000','2025-06-21 15:08:55.000000',2),
(3,'prueba2','2025-06-28 20:18:12.000000','2025-06-27 19:53:08.000000',10),
(4,'Prueba3',NULL,'2025-06-27 20:05:33.000000',9),
(5,'esto es una prueba',NULL,'2025-06-28 20:18:20.000000',11);
/*!40000 ALTER TABLE `valores_referencia` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-30 21:35:47
