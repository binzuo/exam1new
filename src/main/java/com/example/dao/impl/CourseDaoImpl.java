package com.example.dao.impl;

import org.springframework.stereotype.Repository;

import com.example.dao.CourseDao;
import com.example.model.Course;

@Repository
public class CourseDaoImpl extends GenericDaoImpl<Course, Integer> implements CourseDao {}