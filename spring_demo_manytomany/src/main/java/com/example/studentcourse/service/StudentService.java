package com.example.studentcourse.service;

import com.example.studentcourse.model.Student;
import com.example.studentcourse.model.Course;
import com.example.studentcourse.repository.StudentRepository;
import com.example.studentcourse.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);
        
        if (student != null && course != null) {
            student.getCourses().add(course);
            course.getStudents().add(student);
            studentRepository.save(student);
            return student;
        }
        return null;
    }
    
    public List<Course> getStudentCourses(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            return new ArrayList<>(student.getCourses());
        }
        return new ArrayList<>();
    }
}