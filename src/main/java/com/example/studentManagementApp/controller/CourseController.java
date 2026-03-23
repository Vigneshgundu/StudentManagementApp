package com.example.studentManagementApp.controller;

import com.example.studentManagementApp.model.Course;
import com.example.studentManagementApp.service.courseservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
public class CourseController {
    @Autowired
    private courseservice corser;
    @PostMapping("/enrollcourses")
    public ResponseEntity<Course>enrollcourse(@RequestBody Course course){
        Course cor=corser.enrollcourse(course);
        return ResponseEntity.ok(cor);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>>allcourses(){
        List<Course>courses=corser.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courseById")
    public ResponseEntity<Course>getCourseById(@RequestParam Long course_id){
        Course course=corser.getCourseById(course_id);
        return ResponseEntity.ok(course);
    }

    @PutMapping("/updateCourseById")
    public ResponseEntity<Course>updateCourseById(@RequestParam Long course_id,@RequestBody Course updatedcourse){
        Course course=corser.updateCourseById(course_id,updatedcourse);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/deleteCourseById/{course_id}")
    public ResponseEntity<String>deleteCourseById(@PathVariable Long course_id){
        String msg=corser.deleteCourseById(course_id);
        return ResponseEntity.ok(msg);
    }
}
