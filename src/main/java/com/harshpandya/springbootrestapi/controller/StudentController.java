package com.harshpandya.springbootrestapi.controller;

import com.harshpandya.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent() {
        Student student = new Student(1, "Harsh", "Pandya");
        return student;
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Harsh", "Pandya"));
        studentList.add(new Student(2, "Manvi", "Agrawal"));
        studentList.add(new Student(3, "Random", "Shandom"));
        return studentList;
    }

    //    Spring Boot REST API with Path Variable
    @GetMapping("/student/{id}/{firstName}/{lastName}")
    public Student studentPathVariable(@PathVariable("id") int studentId,
                                       @PathVariable("firstName") String firstName,
                                       @PathVariable("lastName") String lastName) {
        return new Student(studentId, firstName, lastName);
    }
}
