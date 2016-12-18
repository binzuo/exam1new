package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.dao.GenericDao;
import com.example.model.StudentCourse;
import com.example.service.StudentCourseService;

@Service
public class StudentCourseServiceImpl extends GenericServiceImpl<StudentCourse, Integer> implements StudentCourseService {

    @Override
    @Autowired
    @Qualifier("studentCourseDaoImpl")
    public void setGenericDao(GenericDao<StudentCourse, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}