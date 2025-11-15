package com.example.studentcourse.controller;

import com.example.studentcourse.model.Student;
import com.example.studentcourse.model.Course;
import com.example.studentcourse.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentService studentService;
    
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    
    @PostMapping("/{studentId}/courses/{courseId}")
    public String enrollInCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        Student student = studentService.enrollStudentInCourse(studentId, courseId);
        if (student != null) {
            return "Student enrolled successfully!";
        } else {
            return "Error: Student or Course not found!";
        }
    }
    
    @GetMapping("/{id}/courses")
    public List<Course> getStudentCourses(@PathVariable Long id) {
        return studentService.getStudentCourses(id);
    }
}