DROP DATABASE IF EXISTS exam;
CREATE DATABASE exam;

# user table
DROP TABLE IF EXISTS exam.user;
CREATE TABLE exam.user (
  id       INT                   AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  username VARCHAR(255) UNIQUE
  COMMENT '用户名',
  password VARCHAR(255) NOT NULL
  COMMENT '密码',
  role     VARCHAR(255) NOT NULL DEFAULT 'user'
  COMMENT 'admin:管理员; user:普通用户'
)
  COMMENT '用户表';

INSERT INTO exam.user VALUES (NULL, 'a', 'a', 'admin');

# student table
DROP TABLE IF EXISTS exam.student;
CREATE TABLE exam.student (
  id           INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  sname        VARCHAR(255) COMMENT '学生姓名',
  departmentId INT COMMENT '所在系 ID'
)
  COMMENT '';

# department table
DROP TABLE IF EXISTS exam.department;
CREATE TABLE exam.department (
  id    INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  dname VARCHAR(255) COMMENT '系名'
)
  COMMENT '';

# course table
DROP TABLE IF EXISTS exam.course;
CREATE TABLE exam.course (
  id    INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  cname VARCHAR(255) COMMENT '课程名'
)
  COMMENT '';

# student_course table
DROP TABLE IF EXISTS exam.student_course;
CREATE TABLE exam.student_course (
  id        INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  studentId INT COMMENT 'FK',
  courseId  INT COMMENT 'FK'
)
  COMMENT '';

-- FK
ALTER TABLE exam.student
  ADD CONSTRAINT
  fk_student_departmentId
FOREIGN KEY (departmentId)
REFERENCES exam.department (id);

ALTER TABLE exam.student_course
  ADD CONSTRAINT
  fk_student_course_studentId
FOREIGN KEY (studentId)
REFERENCES exam.student (id);

ALTER TABLE exam.student_course
  ADD CONSTRAINT
  fk_student_course_courseId
FOREIGN KEY (courseId)
REFERENCES exam.course (id);


SELECT *
FROM exam.user;

SELECT *
FROM exam.student;

SELECT *
FROM exam.department;

SELECT *
FROM exam.student_course;

SELECT
  s.sname,
  d.dname
FROM exam.student s INNER JOIN exam.department d
    ON s.department_id = d.id;

SELECT
  s.id,
  s.sname,
  c.cname
FROM exam.student s LEFT JOIN exam.student_course sc
  LEFT JOIN exam.course c
    ON s.id = sc.studentId AND c.id = sc.courseId
ORDER BY s.id