DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS courses_taken;

CREATE TABLE students (
id BIGINT IDENTITY,
student_number VARCHAR(255),
age TINYINT,
first_name VARCHAR(255),
last_name VARCHAR(255),
primary key(id));

CREATE TABLE courses (
id BIGINT IDENTITY,
course_number VARCHAR(255),
name VARCHAR(250),
professor VARCHAR(250),
credits TINYINT,
primary key(id));

CREATE TABLE courses_taken (
student_id BIGINT,
course_id BIGINT);