 CREATE TABLE `person` (
  `person_id` varchar(255) NOT NULL,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  PRIMARY KEY (`person_id`)
)