package com.example.controller;

import com.example.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.model.Student;
import com.example.service.StudentService;

@Controller
@RequestMapping("student")
public class StudentController extends BaseController {

    private final StudentService studentService;
    private final DepartmentService departmentService;

    @Autowired
    public StudentController(StudentService studentService, DepartmentService departmentService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
    }

    @RequestMapping("add")
    private String add(Student student) {
        studentService.add(student);
        return "redirect:/student/list";
    }

    @RequestMapping("remove/{id}")
    private String remove(@PathVariable("id") Integer id) {
        studentService.remove(id);
        return "redirect:/student/list";
    }

    @RequestMapping("modify")
    private String modify(Student student) {
        studentService.modify(student);
        return "redirect:/student/list";
    }

    @RequestMapping("list/{page}")
    private String list(@PathVariable int page) {
        getSession().setAttribute("pagination", studentService.list(page));
        return "redirect:/student/list.jsp";
    }

    @RequestMapping("list")
    private String list() {
        getSession().setAttribute("departments", departmentService.queryAll());
        return list(1);
    }

    @RequestMapping("search/{id}")
    private String search(@PathVariable("id") Integer id) {
        getSession().setAttribute("student", studentService.search(id));
        return "redirect:/student/edit.jsp";
    }

    @RequestMapping("queryAllDepartments")
    private String queryAllDepartments() {
        getSession().setAttribute("departments", departmentService.queryAll());
        return "redirect:/student/add.jsp";
    }
}