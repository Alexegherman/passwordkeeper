--// create_db_tables
-- Migration SQL that makes the change goes here.

CREATE TABLE public.application(
 id BIGSERIAL NOT NULL PRIMARY KEY ,
 name VARCHAR (50) NOT NULL ,
 url  VARCHAR (200) NOT NULL,
 CONSTRAINT uk_name_application UNIQUE (name)
);

CREATE TABLE public.password(
id BIGSERIAL NOT NULL PRIMARY KEY ,
user_name VARCHAR (50) NOT NULL,
password  VARCHAR (100) NOT NULL,
active_from TIMESTAMP NOT NULL,
active_to TIMESTAMP,
application_id BIGSERIAL NOT NULL,
FOREIGN KEY(application_id) REFERENCES application(id));

--//@UNDO
-- SQL to undo the change goes here.
-- DROP table password;
-- DROP TABLE application;

