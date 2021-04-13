CREATE TABLE images (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  image_url varchar(100) NOT NULL,
  user_id bigint(20) NOT NULL,
  description varchar(50) DEFAULT NULL,
  created_date DATETIME DEFAULT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Users: ID, Name, Email, Password, CreatedDate

CREATE TABLE users (
  ID bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(50) DEFAULT NULL,
  created_date DATETIME DEFAULT NULL,
  PRIMARY KEY (id),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
