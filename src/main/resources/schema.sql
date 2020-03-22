create database studentdetails;
use studentdetails;

create table student(
id integer not null primary key,
name varchar(100) not null,
marks float not null
);