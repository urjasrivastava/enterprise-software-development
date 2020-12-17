CREATE DATABASE IF NOT EXISTS erp;
USE erp;

-- Table Creation 

CREATE TABLE courses(
	course_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	course_code VARCHAR(6) NOT NULL UNIQUE,
	name VARCHAR(100) NOT NULL,
	description VARCHAR(1000),
	term VARCHAR(100),
	faculty VARCHAR(100) NOT NULL,
	year INT, 
	credits INT NOT NULL,
	capacity INT NOT NULL, 
	available_seats INT
);

CREATE TABLE students(
    student_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    roll_number VARCHAR(10) unique NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(100) NOT NULL,
    photograph_path VARCHAR(100),
    total_credits int NOT NULL,
    password VARCHAR(100)
);

CREATE TABLE student_courses(
	id BIGINT not null AUTO_INCREMENT PRIMARY KEY,
	student_id BIGINT NOT NULL,
	course_id BIGINT NOT NULL,
	comments VARCHAR(100), 
	FOREIGN KEY (student_id) REFERENCES Students(student_id), 
	FOREIGN KEY (course_id) REFERENCES Courses(course_id)
);

CREATE TABLE prerequisite(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	course_id BIGINT NOT NULL,
	prerequisite BIGINT NOT NULL,
	description VARCHAR(100), 
	FOREIGN KEY (course_id) REFERENCES Courses(course_id), 
	FOREIGN KEY (prerequisite) REFERENCES Courses(course_id)
);

-- Insertion into tables

-- 1st sem courses
INSERT INTO courses VALUES (1, "CS511", "Algorithms", "Some algorithms stuff goes here...", "2019-2020", "Prof. Muralidhara", 2019, 4, 150, 0);
INSERT INTO courses VALUES (2, "NC501", "Networking", "Some networking stuff goes here...", "2019-2020", "Prof. Debabrata Das, Prof. Jyotnsa", 2019, 4, 150, 0);
INSERT INTO courses VALUES (3, "AI101", "Machine Learning", "Some ML stuff goes here...", "2019-2020", "Prof. Pro no 1", 2019, 4, 150, 0);
INSERT INTO courses VALUES (4, "AI102", "Mathematics for Machine Learning", "Some MML stuff goes here...", "2019-2020", "Prof. Pro no 2, Prof. Pro no 3", 2019, 4, 150, 0);
INSERT INTO courses VALUES (5, "CS513", "Discrete Mathematics & Computability", "Some DM&C stuff goes here...", "2019-2020", "Prof. Meenakshi, Prof. Srinivas", 2019, 4, 150, 0);

-- 2nd sem courses
-- Pre-req -> DM&C
INSERT INTO courses VALUES (6, "CS616", "Foundation of Cryptography", "Some crypto stuff goes here...", "2020-2021", "Prof. Ashish Choudhury, Prof. Srinivas Vivek", 2020, 4, 50, 50); 
-- No prereq
INSERT INTO courses VALUES (7, "CS816", "Software Production & Engineering", "Some SPE stuff goes here...", "2020-2021", "Prof. Thangaraju", 2020, 4, 150, 150);
-- Pre-req -> ML, MML
INSERT INTO courses VALUES (8, "AI829", "Natural Language Processing", "Some NLP stuff goes here...", "2020-2021", "Prof. G Srinivasa", 2020, 4, 100, 100);
-- No pre-req
INSERT INTO courses VALUES (9, "NC824", "Cyber Security Fundamentals with toolds and techniques for defense", "Some Cyber Sec stuff goes here...", "2020-2021", "Prof. Harish", 2020, 4, 10, 10);
-- Pre-req -> NC501
INSERT INTO courses VALUES (10, "NC601", "Wireless Access Networks", "Some WAN stuff goes here...", "2020-2021", "Prof. Debabrata", 2020, 4, 20, 20);
-- Pre-req -> NC501
INSERT INTO courses VALUES (11, "NC861", "Advanced Computer Networks", "Some ACN stuff goes here...", "2020-2021", "Prof. Samar", 2020, 4, 50, 50);
-- No Pre-req
INSERT INTO courses VALUES (12, "AI817", "Optimization, Learning and Cognition", "Some OLC stuff goes here...", "2020-2021", "Prof. G Srinivasa", 2020, 4, 10, 10);

-- Passwords for all is Bycrypt("ryuu") with 10 rounds -> $2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW 
INSERT INTO students VALUES (1, "MT202001", "Luffy", "Monkey D", "luffy@op.com", "1", "4", "$2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW");
INSERT INTO students VALUES (2, "MT202002", "Zoro", "Roronoa", "zoro@op.com", "2", "4", "$2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW");
INSERT INTO students VALUES (3, "MT202003", "Sanji", "Vinsmoke", "sanji@op.com", "3", "4", "$2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW");

-- Luffy
INSERT INTO student_courses VALUES (1, 1, 1, "Some");
INSERT INTO student_courses VALUES (2, 1, 2, "random");
INSERT INTO student_courses VALUES (3, 1, 3, "stuff");
INSERT INTO student_courses VALUES (4, 1, 4, "goes");
-- Zoro
INSERT INTO student_courses VALUES (5, 2, 1, "here");
INSERT INTO student_courses VALUES (6, 2, 2, "Some");
INSERT INTO student_courses VALUES (7, 2, 3, "random");
INSERT INTO student_courses VALUES (8, 2, 5, "stuff");
-- Sanji
INSERT INTO student_courses VALUES (9, 3, 2, "goes");
INSERT INTO student_courses VALUES (10, 3, 3, "here");
INSERT INTO student_courses VALUES (11, 3, 4, "Some");
INSERT INTO student_courses VALUES (12, 3, 5, "random");


-- FoC <- DM&C
INSERT INTO prerequisite VALUES (1, 6, 5, "Some stuff");
-- NLP <- ML
INSERT INTO prerequisite VALUES (2, 8, 3, "Some stuff");
-- NLP <- MML
INSERT INTO prerequisite VALUES (3, 8, 4, "Some stuff");
-- WAN <- NC501
INSERT INTO prerequisite VALUES (4, 10, 2, "Some stuff");
-- ACN <- NC501
INSERT INTO prerequisite VALUES (5, 11, 2, "Some stuff");

