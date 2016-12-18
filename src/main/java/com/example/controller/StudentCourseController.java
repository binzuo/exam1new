package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.model.StudentCourse;
import com.example.service.StudentCourseService;

@Controller
@RequestMapping("studentcourse")
public class StudentCourseController extends BaseController {

    private final StudentCourseService studentcourseService;

    @Autowired
    public StudentCourseController(StudentCourseService studentcourseService) {
        this.studentcourseService = studentcourseService;
    }

    @RequestMapping("add")
    private String add(StudentCourse studentcourse) {
        studentcourseService.add(studentcourse);
        return "redirect:/studentcourse/list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        studentcourseService.remove(id);
        return "redirect:/studentcourse/list";
    }

    @RequestMapping("modify")
    private String modify(StudentCourse studentcourse) {
        studentcourseService.modify(studentcourse);
        return "redirect:/studentcourse/list";
    }

    @RequestMapping("list/{page}")
    private String list(@PathVariable int page) {
        getSession().setAttribute("pagination", studentcourseService.list(page));
        return "redirect:/studentcourse/list.jsp";
    }

    @RequestMapping("list")
    private String list() {
        return list(1);
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        getSession().setAttribute("studentcourse", studentcourseService.search(id));
        return "redirect:/studentcourse/edit.jsp";
    }
}