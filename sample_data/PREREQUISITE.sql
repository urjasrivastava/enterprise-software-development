CREATE TABLE prerequisite(
	id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	course_id BIGINT NOT NULL,
	prerequisite BIGINT NOT NULL,
	description VARCHAR(100), 
	FOREIGN KEY (course_id) REFERENCES Courses(course_id), 
	FOREIGN KEY (prerequisite) REFERENCES Courses(course_id)
);

-- INSERT STATEMENT

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
