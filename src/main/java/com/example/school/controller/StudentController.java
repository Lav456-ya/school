/*
 *
 * You can use the following import statemets
 *
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */
package com.example.school.controller;

import com.example.school.service.StudentH2Service;
import com.example.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class StudentController {

    @Autowired
    private StudentH2Service studentService;

    // API 1: GET /students
    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentService.getStudents();
    }

    // API 2: POST /students
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // API 3: POST /students/bulk
    @PostMapping("/students/bulk")
    public String addStudents(@RequestBody ArrayList<Student> students) {
        return studentService.addStudents(students);
    }

    // API 4: GET /students/{studentId}
    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return studentService.getStudentById(studentId);
    }

    // API 5: PUT /students/{studentId}
    @PutMapping("/students/{studentId}")
    public Student updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    // API 6: DELETE /students/{studentId}
    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
    }
}
