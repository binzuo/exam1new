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
  id            INT AUTO_INCREMENT PRIMARY KEY
  COMMENT 'PK',
  sname         VARCHAR(255) COMMENT '学生姓名',
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

-- FK
ALTER TABLE exam.student
  ADD CONSTRAINT
  fk_student_departmentId
FOREIGN KEY (departmentId)
REFERENCES exam.department (id);


SELECT *
FROM exam.user;

SELECT *
FROM exam.student;

SELECT *
FROM exam.department;

SELECT
  s.sname,
  d.dname
FROM exam.student s INNER JOIN exam.department d
    ON s.department_id = d.id;