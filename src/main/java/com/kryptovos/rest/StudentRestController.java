package com.kryptovos.rest;

import com.kryptovos.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e) {

        StudentErrorResponse errorResponse = new StudentErrorResponse();

        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(e.getMessage());
        errorResponse.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Define endpoint for all students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // Define endpoint for students based on ID
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // Check student ID against list size
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student not found - ID: " + studentId);
        }

        return theStudents.get(studentId);
    }
}