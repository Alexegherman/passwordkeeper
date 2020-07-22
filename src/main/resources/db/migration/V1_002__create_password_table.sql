CREATE TABLE  password(
id SERIAL NOT NULL PRIMARY KEY ,
user_name VARCHAR (50) NOT NULL ,
password  VARCHAR (100) NOT NULL,
active_from TIMESTAMP NOT NULL ,
active_to TIMESTAMP ,
application_id SERIAL NOT NULL,
CONSTRAINT fk_app_password FOREIGN KEY (application_id) REFERENCES application(id)
);
