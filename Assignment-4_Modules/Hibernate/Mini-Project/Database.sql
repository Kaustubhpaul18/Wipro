CREATE TABLE employee (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    gender VARCHAR(10),
    designation VARCHAR(50),
    salary DECIMAL(10,2),
    city VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    mobile VARCHAR(15)
);

CREATE TABLE users (
    userid VARCHAR(50) PRIMARY KEY,
    password VARCHAR(100) NOT NULL
);
