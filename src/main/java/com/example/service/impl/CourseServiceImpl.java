package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.dao.GenericDao;
import com.example.model.Course;
import com.example.service.CourseService;

@Service
public class CourseServiceImpl extends GenericServiceImpl<Course, Integer> implements CourseService {

    @Override
    @Autowired
    @Qualifier("courseDaoImpl")
    public void setGenericDao(GenericDao<Course, Integer> genericDao) {
        super.genericDao = genericDao;
    }
}