-- OLD TABLE
-- CREATE TABLE students(
--     student_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
--     roll_number BIGINT unique NOT NULL,
--     first_name VARCHAR(100) NOT NULL,
--     last_name VARCHAR(100),
--     email VARCHAR(100) NOT NULL,
--     photograph_path VARCHAR(100),
--     total_credits int NOT NULL,
--     password VARCHAR(100)
-- );

-- NEW TABLE -> roll_number changed from BIGINT to VARCHAR(6)
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

-- INSERT STATEMENTS
-- Passwords for all is Bycrypt("ryuu") with 10 rounds -> $2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW 
INSERT INTO students VALUES (1, "MT202001", "Luffy", "Monkey D", "luffy@op.com", "1", "4", "$2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW");
INSERT INTO students VALUES (2, "MT202002", "Zoro", "Roronoa", "zoro@op.com", "2", "4", "$2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW");
INSERT INTO students VALUES (3, "MT202003", "Sanji", "Vinsmoke", "sanji@op.com", "3", "4", "$2y$10$ULnKdFLwcq2D7QyGKKfoi.ef1ayegzle2f2Mg65y7PHqO.Z4KnViW");

