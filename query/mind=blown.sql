-- Choose the courses from prereq table whose prerequisite has been completed by the student
SELECT sc.student_id, p.prerequisite, p.course_id FROM student_courses sc JOIN prerequisite p ON sc.course_id=p.prerequisite WHERE sc.student_id = 1;

-- Count number of prerequisites that the course has
SELECT sc.student_id, COUNT(p.prerequisite), p.course_id 
FROM student_courses sc 
JOIN prerequisite p ON sc.course_id=p.prerequisite
WHERE sc.student_id = 1
GROUP BY p.course_id;

-- Count number of prerequisites that a specific course has
SELECT sc.student_id, COUNT(p.prerequisite), p.course_id
FROM student_courses sc
JOIN prerequisite p ON sc.course_id=p.prerequisite
WHERE sc.student_id = 1 AND p.course_id=8
GROUP BY p.course_id;

-- List all the available courses
SELECT c.course_id, c.course_code, c.name, c.year FROM courses c;

-- List all the courses of a specific year
SELECT c.course_id, c.course_code, c.name, c.year FROM courses c WHERE YEAR=2020;

-- Join courses list of a specific year with a specific student
SELECT sc.student_id, c.course_id, c.course_code, c.name, c.year
FROM courses c
LEFT JOIN student_courses sc ON sc.course_id=c.course_id
WHERE YEAR=2020;

-- Join above list with prerequisite table
SELECT sc.student_id, c.course_id, p.prerequisite, c.course_code, c.name, c.year
FROM courses c
LEFT JOIN student_courses sc ON sc.course_id=c.course_id
LEFT JOIN prerequisite p ON c.course_id=p.course_id
WHERE YEAR=2020;

-- Group the above list by course_id
SELECT sc.student_id, c.course_id, COUNT(p.prerequisite), c.course_code, c.name, c.year
FROM courses c
LEFT JOIN student_courses sc ON sc.course_id=c.course_id
LEFT JOIN prerequisite p ON c.course_id=p.course_id
WHERE YEAR=2020 GROUP BY c.course_id;

-- Use count for comparison
SELECT sc.student_id, c.course_id, p.prerequisite, COUNT(p.prerequisite), c.course_code, c.name, c.year
FROM courses c
LEFT JOIN student_courses sc ON sc.course_id=c.course_id
LEFT JOIN prerequisite p ON c.course_id=p.course_id
WHERE YEAR=2020 AND (sc.student_id = 1 OR sc.student_id IS NULL) GROUP BY c.course_id
HAVING COUNT(p.prerequisite) = (SELECT COUNT(p.prerequisite)
	FROM student_courses sc2
	JOIN prerequisite p ON sc2.course_id=p.prerequisite
	WHERE sc2.student_id = 1 AND p.course_id=c.course_id
	GROUP BY p.course_id) OR COUNT(p.prerequisite) = 0;
