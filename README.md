# springboot-auth
Spring boot Authentication and authorization using spring security

#Database Tables

CREATE TABLE `user` (</br>
  `user_id` int(11) NOT NULL AUTO_INCREMENT,</br>
  `active` int(11) DEFAULT NULL,</br>
  `email` varchar(255) NOT NULL,</br>
  `last_name` varchar(255) NOT NULL,</br>
  `name` varchar(255) NOT NULL,</br>
  `password` varchar(255) NOT NULL,</br>
  PRIMARY KEY (`user_id`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;</br>


--</br>
-- Table structure for table `user_role`</br>
--</br>

DROP TABLE IF EXISTS `user_role`;</br>
CREATE TABLE `user_role` (</br>
  `user_id` int(11) NOT NULL,</br>
  `role_id` int(11) NOT NULL,</br>
  PRIMARY KEY (`user_id`,`role_id`),</br>
  KEY `FK_roleId` (`role_id`),</br>
  CONSTRAINT `FK_userId` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),</br>
  CONSTRAINT `FK_roleId` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)</br>
) ENGINE=InnoDB DEFAULT CHARSET=utf8;</br>

#Database Query
INSERT INTO `role` VALUES (1,'ADMIN');

