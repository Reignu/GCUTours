DROP DATABASE IF EXISTS gcutours;
CREATE DATABASE IF NOT EXISTS gcutours DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE gcutours;

DROP TABLE IF EXISTS GCUTOUR;
CREATE TABLE IF NOT EXISTS GCUTOUR (
  GCUTOURID int(11) NOT NULL AUTO_INCREMENT,
  TOURDATE  varchar(10) NOT NULL,
  TOURDURATION  int(2) NOT NULL,
  PRIMARY KEY (GCUTOURID)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO GCUTOUR (GCUTOURID, TOURDATE, TOURDURATION) VALUES
(1, '24/03/2024', 7),
(2, '22/04/2024', 14),
(3, '06/06/2024', 10);

DROP TABLE IF EXISTS DESTINATION;
CREATE TABLE IF NOT EXISTS DESTINATION (
  DESTINATIONID int(11) NOT NULL AUTO_INCREMENT,
  DESTINATIONNAME varchar(30) NOT NULL,
  COUNTRY varchar(30) NOT NULL,
  GCUTOURID int(11) NOT NULL,
  PRIMARY KEY (DESTINATIONID)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO DESTINATION (DESTINATIONID, DESTINATIONNAME, COUNTRY, GCUTOURID) VALUES
(1, 'Paris', 'France', 1),
(2, 'London', 'England', 1),
(3, 'Manchester', 'England', 1),
(4, 'Barcelona', 'Spain', 2),
(5, 'Girona', 'Spain', 2),
(6, 'New York', 'USA', 3),
(7, 'New Jersey', 'USA', 3);

ALTER TABLE DESTINATION
  ADD CONSTRAINT PLACE_ibfk_1 FOREIGN KEY (GCUTOURID) REFERENCES GCUTOUR (GCUTOURID);
  
DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `AddGCUTour`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddGCUTour` (IN `inTourDate` TEXT, IN `inTourDuration` TEXT)  BEGIN
 INSERT INTO GCUTOUR (TOURDATE, TOURDURATION)
        VALUES (inTourDate, inTourDuration);
END$$

DROP PROCEDURE IF EXISTS `AddPlace`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `AddPlace` (IN `inPlaceName` TEXT, IN `inCountry` TEXT, IN `inGCUTourId` INT)  BEGIN
 INSERT INTO DESTINATION (DESTINATIONNAME, COUNTRY, GCUTOURID)
        VALUES (inPlaceName, inCountry, inGCUTourId);
END$$

DROP PROCEDURE IF EXISTS `GetGCUTour`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetGCUTour` (IN `inGCUTourId` INT)  BEGIN
 SELECT *
 FROM     GCUTOUR
 WHERE  GCUTOURID = inGCUTourId ;
END$$

DROP PROCEDURE IF EXISTS `GetGCUTours`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetGCUTours` ()  READS SQL DATA
BEGIN
  Select GCUTOURID, TOURDATE, TOURDURATION From GCUTOUR Order By GCUTOURID;
END$$

DROP PROCEDURE IF EXISTS `GetGCUToursPlaces`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetGCUToursPlaces` (IN `inGCUTourId` INT)  NO SQL
BEGIN
  SELECT DESTINATIONID, DESTINATIONNAME, COUNTRY FROM DESTINATION
  WHERE GCUTOURID = inGCUTourId
  Order By DESTINATIONNAME;
End$$

DELIMITER ;  

