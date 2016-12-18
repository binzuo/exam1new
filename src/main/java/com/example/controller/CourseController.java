package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.model.Course;
import com.example.service.CourseService;

@Controller
@RequestMapping("course")
public class CourseController extends BaseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @RequestMapping("add")
    private String add(Course course) {
        courseService.add(course);
        return "redirect:/course/list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        courseService.remove(id);
        return "redirect:/course/list";
    }

    @RequestMapping("modify")
    private String modify(Course course) {
        courseService.modify(course);
        return "redirect:/course/list";
    }

    @RequestMapping("list/{page}")
    private String list(@PathVariable int page) {
        getSession().setAttribute("pagination", courseService.list(page));
        return "redirect:/course/list.jsp";
    }

    @RequestMapping("list")
    private String list() {
        return list(1);
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        getSession().setAttribute("course", courseService.search(id));
        return "redirect:/course/edit.jsp";
    }
}