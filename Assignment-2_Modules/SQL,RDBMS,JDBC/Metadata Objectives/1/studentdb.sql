CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE student (
    rollno INT PRIMARY KEY,
    name VARCHAR(50),
    course VARCHAR(50),
    dob VARCHAR(20),
    fee INT
);
