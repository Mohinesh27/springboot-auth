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


<h3>Set properties values in application.properties file as below-</h3>

server.port = 8091

# ===============================
# = DATA SOURCE
# ===============================
spring.datasource.url = jdbc:mysql://localhost:3306/interviewportal_db?verifyServerCertificate=false&useSSL=false&requireSSL=false
spring.datasource.username = root
spring.datasource.password = root
spring.datasource.testWhileIdle = true
spring.datasource.validationQuery = SELECT 1


# ===============================
# = JPA / HIBERNATE
# ===============================
spring.jpa.show-sql = true
spring.jpa.hibernate.ddl-auto = update
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

# ==============================================================
# = Spring Security / Queries for AuthenticationManagerBuilder  
# ==============================================================
spring.queries.users-query=select email, password, active from user where email=?
spring.queries.roles-query=select u.email, r.role from user u inner join user_role ur on(u.user_id=ur.user_id) inner join role r on(ur.role_id=r.role_id) where u.email=?

# ===============================
# = Spring Boot Admin configuration
# ===============================
#spring.boot.admin.client.url= "http://localhost:1111" 

#endpoints.beans.sensitive=false
#endpoints.beans.enabled=true
#management.endpoint.shutdown.enabled=true
#management.endpoints.enabled-by-default=false
#management.endpoint.info.enabled=true
#management.endpoints.jmx.exposure.include=health,info

# ===============================
# = Spring Boot Logging configuration
# ===============================
logging.file=log/application.log 
logging.pattern.file=%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} %clr(%5p) %clr(${PID}){magenta} %clr(---){faint} %clr([%15.15t]){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n%wEx 

# ===============================
# = Spring Boot view resolver
# ===============================
#spring.mvc.view.prefix=/WEB-INF/view/
#spring.mvc.view.suffix=.jsp

