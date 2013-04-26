CREATE TABLE `T_FILM` (
  `F_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_ADDED_DATE` datetime DEFAULT NULL,
  `F_ENG_NAME` varchar(255) NOT NULL,
  `F_RUS_NAME` varchar(255) NOT NULL,
  `F_YEAR` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`F_ID`)
);


CREATE TABLE `T_TRAILER` (
  `F_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `F_ADDED_DATE` datetime DEFAULT NULL,
  `F_DESCRIPTION` varchar(255) DEFAULT NULL,
  `F_NAME` varchar(255) NOT NULL,
  `F_SHORT_NAME` varchar(255) NOT NULL,
  `F_URL` varchar(255) DEFAULT NULL,
  `FILM_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`F_ID`),
  FOREIGN KEY (`FILM_ID`) REFERENCES `T_FILM` (`F_ID`)
);

INSERT INTO `T_FILM` VALUES ('1', '2013-02-22 15:12:22', 'Pacific Rim', 'Тихоокеанский рубеж', '2013');
INSERT INTO `T_TRAILER` VALUES ('1', '2013-02-22 15:20:41', 'Тихоокеанский рубеж - русский тизер (2013)', 'Русский тизер (2013)', 'Русский тизер (2013)', 'http://www.youtube.com/embed/kQSZKAu60ug', '1');
