package com.harshpandya.springbootrestapi.controller;

import com.harshpandya.springbootrestapi.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Harsh", "Pandya");
        return ResponseEntity.ok()
                .header("custom-header", "Hello Header")
                .body(student);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student(1, "Harsh", "Pandya"));
        studentList.add(new Student(2, "Manvi", "Agrawal"));
        studentList.add(new Student(3, "Random", "Shandom"));
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    //    Spring Boot REST API with Path Variable
    @GetMapping("/student/{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId,
                                                       @PathVariable("firstName") String firstName,
                                                       @PathVariable("lastName") String lastName) {
        Student student = new Student(studentId, firstName, lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //    Spring boot REST API with Request Param
    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                                          @RequestParam String firstName,
                                                          @RequestParam String lastName) {
        Student student = new Student(id, firstName, lastName);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    @PutMapping("student/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                                 @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping("student/{id}/delete")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.OK);
    }
}
