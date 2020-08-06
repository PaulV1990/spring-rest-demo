package com.kryptovos.rest;

import com.kryptovos.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // Define endpoint
    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> theStudent = new ArrayList<>();

        theStudent.add(new Student("Bob", "Bobson"));
        theStudent.add(new Student("Peter", "Janell"));
        theStudent.add(new Student("Jason", "Dough"));

        return theStudent;
    }
}