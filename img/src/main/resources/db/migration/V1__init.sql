CREATE TABLE role (
    id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL
);

CREATE TABLE image (
  id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  image_url varchar(100) NOT NULL,
  user_id bigint(20) NOT NULL,
  description varchar(50) DEFAULT NULL,
  created_date DATETIME DEFAULT NULL
);

CREATE TABLE user (
  id bigint(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  password varchar(50) DEFAULT NULL,
  confirm_password varchar(50) DEFAULT NULL,
  created_date DATETIME DEFAULT NULL,
  reset_token varchar(256) DEFAULT NULL,
  confirmation_token varchar(256) DEFAULT NULL,
  enabled tinyint(1) DEFAULT 0,
  role_id bigint(20),
  FOREIGN KEY(role_id) REFERENCES role (id)
);





