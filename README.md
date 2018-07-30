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
-- Table structure for table `role`</br>
--</br>
DROP TABLE IF EXISTS `role`;</br>
/*!40101 SET @saved_cs_client     = @@character_set_client */;</br>
/*!40101 SET character_set_client = utf8 */;</br>
CREATE TABLE `role` (</br>
  `role_id` int(11) NOT NULL AUTO_INCREMENT,</br>
  `role` varchar(255) DEFAULT NULL,</br>
  PRIMARY KEY (`role_id`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;</br>
/*!40101 SET character_set_client = @saved_cs_client */;</br>

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

#Database Query</br>
INSERT INTO `role` VALUES (1,'ADMIN');<br/>


<h3>Set properties values in application.properties file as below-</h3>

server.port = 8091<br/>

# ===============================
# = DATA SOURCE
# ===============================
spring.datasource.url = jdbc:mysql://localhost:3306/interviewportal_db?verifyServerCertificate=false&useSSL=false&requireSSL=false<br/>
spring.datasource.username = root<br/>
spring.datasource.password = root<br/>
spring.datasource.testWhileIdle = true<br/>
spring.datasource.validationQuery = SELECT 1<br/>


# ===============================
# = JPA / HIBERNATE
# ===============================
spring.jpa.show-sql = true<br/>
spring.jpa.hibernate.ddl-auto = update<br/>
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy<br/>
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect<br/>

# ==============================================================
# = Spring Security / Queries for AuthenticationManagerBuilder  
# ==============================================================
spring.queries.users-query=select email, password, active from user where email=?<br/>
spring.queries.roles-query=select u.email, r.role from user u inner join user_role ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?<br/>

# ===============================
# = Spring Boot Admin configuration
# ===============================
#spring.boot.admin.client.url= "http://localhost:1111" <br/>

#endpoints.beans.sensitive=false<br/>
#endpoints.beans.enabled=true<br/>
#management.endpoint.shutdown.enabled=true<br/>
#management.endpoints.enabled-by-default=false<br/>
#management.endpoint.info.enabled=true<br/>
#management.endpoints.jmx.exposure.include=health,info<br/>

# ===============================
# = Spring Boot Logging configuration
# ===============================
logging.file=log/application.log <br/>
logging.pattern.file=%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(%5p) %clr(${PID}){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n%wEx <br/>

# ===============================
# = Spring Boot view resolver
# ===============================
#spring.mvc.view.prefix=/WEB-INF/view/<br/>
#spring.mvc.view.suffix=.jsp<br/>

