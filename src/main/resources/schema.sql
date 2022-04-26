CREATE TABLE students (
id BIGINT IDENTITY,
age TINYINT,
first_name VARCHAR(255),
last_name VARCHAR(255),
primary key(id));

CREATE TABLE courses (
id BIGINT IDENTITY,
name VARCHAR(250),
professor VARCHAR(250),
credits TINYINT,
primary key(id));