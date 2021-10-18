CREATE DATABASE /*!32312 IF NOT EXISTS*/`videojuegos_db` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `videojuegos_db`;

/*Table structure for table `categorias` */

DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `categorias` */

insert  into `categorias`(`id`,`activo`,`nombre`) values (1,'','Aventura'),(2,'','Acción'),(3,'\0','Familiar');

/*Table structure for table `estudios` */

DROP TABLE IF EXISTS `estudio`;

CREATE TABLE `estudio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `estudios` */

insert  into `estudio`(`id`,`activo`,`nombre`) values (1,'','Estudio videojuegos 1'),(2,'','Estudio videojuegos 2'),(3,'\0','Estudio videojuegos 3');

/*Table structure for table `videojuegos_db` */

DROP TABLE IF EXISTS `videojuegos`;

CREATE TABLE `videojuegos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `activo` bit(1) NOT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fecha_lanzamiento` datetime DEFAULT NULL,
  `imagen` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `precio` float NOT NULL,
  `stock` int(11) NOT NULL,
  `titulo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fk_categoria` bigint(20) NOT NULL,
  `fk_estudio` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK54ev8cdsfhbdfxufd9wc8g23x` (`fk_categoria`),
  KEY `FKev9v8m1hnvqlpne73pgko027c` (`fk_estudio`),
  CONSTRAINT `FK54ev8cdsfhbdfxufd9wc8g23x` FOREIGN KEY (`fk_categoria`) REFERENCES `categorias` (`id`),
  CONSTRAINT `FKev9v8m1hnvqlpne73pgko027c` FOREIGN KEY (`fk_estudio`) REFERENCES `estudio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `videojuegos` */

insert  into `videojuegos`(`id`,`activo`,`descripcion`,`fecha_lanzamiento`,`imagen`,`precio`,`stock`,`titulo`,`fk_categoria`,`fk_estudio`) values (1,'\0','Descripcion 1a','2021-08-28 03:00:00','https://e.rpp-noticias.io/normal/2016/10/14/035103_266475.png',155,10,'Crash ',1,1),(2,'','Descripcion 2','2021-07-26 21:49:36','https://e.rpp-noticias.io/normal/2016/10/14/035103_266475.png',250,0,'Pacman ',1,1),(3,'','Descripcion 3','2021-09-06 21:50:17','https://e.rpp-noticias.io/normal/2016/10/14/035103_266475.png',375,12,'Call of duty',1,1);