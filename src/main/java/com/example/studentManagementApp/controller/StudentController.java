package com.example.studentManagementApp.controller;

import com.example.studentManagementApp.model.Student;
import com.example.studentManagementApp.service.studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    private studentservice stdservice;
    @PostMapping("/enrollstudent")
    public ResponseEntity<?> enrollStudent(@RequestBody Student std){
        Student saved= stdservice.enrollStudent(std);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/Students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student>students=stdservice.getStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/StudentByrollno")
    public ResponseEntity<Student>getStudentByrollno(@RequestParam String rollno){
        Student student=stdservice.getStudentByrollno(rollno);
        return ResponseEntity.ok(student);
    }
    @PutMapping("/updatestudent/{rollno}")
    public ResponseEntity<Student> updateStudent(@PathVariable String rollno,@RequestBody Student newstudent){
        Student std=stdservice.updateStudent(rollno,newstudent);
        return ResponseEntity.ok(std);
    }

    @DeleteMapping("deleteStudentByrollno/{rollno}")
    public ResponseEntity<String>deleteStudentByrollno(@PathVariable String rollno){
        String msg=stdservice.deleteStudentbyrollno(rollno);
        return ResponseEntity.ok(msg);
    }
}
