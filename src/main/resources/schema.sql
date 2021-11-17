CREATE TABLE person
(
 personName varchar(100) NOT NULL,
 personSurname varchar(100) NOT NULL,
  personId varchar(11) NOT NULL ,
 personGiving varchar(100) DEFAULT NULL,
 personReceiving varchar(100) DEFAULT NULL,
 PRIMARY KEY (personId)
);