package com.example.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.dao.StudentCourseDao;
import com.example.model.StudentCourse;

@Repository
public class StudentCourseDaoImpl extends GenericDaoImpl<StudentCourse, Integer> implements StudentCourseDao {}