CREATE TABLE person
(
 personName varchar(100) NOT NULL,
 personSurname varchar(100) NOT NULL,
  personId varchar(11) NOT NULL,
 personGiving varchar(100) DEFAULT NULL,
 personReceiving varchar(100) DEFAULT NULL,
 PRIMARY KEY (personId)
);

CREATE TABLE lottery
(
personId varchar(11) NOT NULL,
lotteryId varchar(11) NOT NULL,
amount DECIMAL(1000) NOT NULL,
id varchar(11) NOT NULL UNIQUE,
PRIMARY KEY (id)
)