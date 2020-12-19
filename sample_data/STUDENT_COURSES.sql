CREATE TABLE student_courses(
	id BIGINT not null AUTO_INCREMENT PRIMARY KEY,
	student_id BIGINT NOT NULL,
	course_id BIGINT NOT NULL,
	comments VARCHAR(100), 
	FOREIGN KEY (student_id) REFERENCES students(student_id), 
	FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- INSERT STATEMENTS

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
