-- Drop tables if exist
BEGIN
    EXECUTE IMMEDIATE 'DROP TABLE student';
EXCEPTION
    WHEN OTHERS THEN
        IF SQLCODE != -942 THEN RAISE; END IF;
END;
/

-- Create table
CREATE TABLE student (
    rollno NUMBER PRIMARY KEY,
    studentname VARCHAR2(50) NOT NULL,
    standard VARCHAR2(10),
    date_of_birth DATE,
    fees NUMBER(10,2)
);

-- Optional sample data
INSERT INTO student VALUES (101, 'Ravi', 'IV', TO_DATE('20-NOV-2001','DD-MON-YYYY'), 4000);
INSERT INTO student VALUES (102, 'Meera', 'V', TO_DATE('15-MAY-2002','DD-MON-YYYY'), 4500);
COMMIT;
