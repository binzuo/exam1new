package com.example.controller;

import com.example.model.StudentCourse;
import com.example.service.CourseService;
import com.example.service.DepartmentService;
import com.example.service.StudentCourseService;
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
    private final CourseService courseService;
    private final StudentCourseService studentCourseService;

    @Autowired
    public StudentController(StudentService studentService, DepartmentService departmentService, CourseService courseService, StudentCourseService studentCourseService) {
        this.studentService = studentService;
        this.departmentService = departmentService;
        this.courseService = courseService;
        this.studentCourseService = studentCourseService;
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

    @RequestMapping("queryAllCourses/{id}")
    private String queryAllCourses(@PathVariable int id) {
        getSession().setAttribute("studentId", id);
        getSession().setAttribute("courses", courseService.queryAll());
        return "redirect:/student/selectCourse.jsp";
    }

    @RequestMapping("selectCourse/{id}")
    private String selectCourse(@PathVariable int id) {
        int studentId = (int) getSession().getAttribute("studentId");
        StudentCourse studentCourse = new StudentCourse(null, studentId, id);
        studentCourseService.add(studentCourse);
        return "redirect:/student/selectCourse.jsp";
    }
}