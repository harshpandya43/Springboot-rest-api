package com.harshpandya.springbootrestapi.controller;

import com.harshpandya.springbootrestapi.bean.Student;
import org.springframework.web.bind.annotation.*;

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

    //    Spring boot REST API with Request Param
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id,
                                          @RequestParam String firstName,
                                          @RequestParam String lastName) {
        return new Student(id, firstName, lastName);
    }

    @PostMapping("students/create")
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return student;
    }
}
