Oracle Table Creation SQL:

CREATE TABLE Student (
    Rollno NUMBER(4) PRIMARY KEY,
    StudentName VARCHAR2(20) NOT NULL,
    Standard VARCHAR2(2) NOT NULL,
    Date_Of_Birth DATE,
    Fees NUMBER(9,2)
);

-- Sample data
INSERT INTO Student VALUES (1001, 'JOHN DOE', 'X', TO_DATE('2005-06-15', 'YYYY-MM-DD'), 5000.00);
COMMIT;