-- OLD TABLE
-- CREATE TABLE courses(
-- 	course_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
-- 	course_code INT NOT NULL UNIQUE,
-- 	name VARCHAR(100) NOT NULL,
-- 	description VARCHAR(1000),
-- 	term VARCHAR(100),
-- 	faculty VARCHAR(100) NOT NULL,
-- 	year INT, 
-- 	credits INT NOT NULL,
-- 	capacity INT NOT NULL, 
-- 	available_seats INT
-- );
-- NEW TABLE -> course_code changed from INT to VARCHAR
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

-- INSERT STATEMENTS

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