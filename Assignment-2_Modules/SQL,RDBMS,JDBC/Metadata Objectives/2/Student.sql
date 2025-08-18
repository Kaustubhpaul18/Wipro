CREATE TABLE student (
rollno NUMBER(4) PRIMARY KEY,
studentname VARCHAR2(20) NOT NULL,
standard VARCHAR2(2) NOT NULL,
date_of_birth DATE,
fees NUMBER(9,2)
);
INSERT INTO student VALUES (1001, 'AJIT', 'IV', TO_DATE('20-Nov-2001', 'DD-Mon-YYYY'), 4000);
INSERT INTO student VALUES (1002, 'RAHUL', 'V', TO_DATE('15-Jan-2002', 'DD-Mon-YYYY'), 4500);
SELECT * FROM student;
GRANT ALL PRIVILEGES TO your_username;