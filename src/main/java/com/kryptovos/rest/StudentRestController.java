package com.kryptovos.rest;

import com.kryptovos.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData() {
        theStudents.add(new Student("Bob", "Bobson"));
        theStudents.add(new Student("Peter", "Janell"));
        theStudents.add(new Student("Jason", "Dough"));
    }

    // Define endpoint for all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // Define endpoint for students based on ID
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }
}