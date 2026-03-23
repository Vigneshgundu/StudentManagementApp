package com.example.studentManagementApp.service;

import com.example.studentManagementApp.model.Course;
import com.example.studentManagementApp.repositary.courserepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class courseservice {
    @Autowired
    private courserepo correpo;
    public Course enrollcourse(Course course) {
        if(correpo.findById(course.getCourse_id()).isPresent()){
         throw new RuntimeException("course with "+course.getCourse_id()+" already exists");
        }
        return correpo.save(course);
    }

    public List<Course> getAllCourses() {
        return correpo.findAll();
    }

    public Course getCourseById(Long courseId) {
       return correpo.findById(courseId).orElseThrow(()->new RuntimeException("course not found exception"));
    }

    public Course updateCourseById(Long courseId,Course updatedcourse) {
        Course existingCourse=correpo.findById(courseId).orElseThrow(()->new RuntimeException("course not found exception"));
        existingCourse.setCourseName(updatedcourse.getCourseName());
        existingCourse.setDescription(updatedcourse.getDescription());
        existingCourse.setDurationMonths(updatedcourse.getDurationMonths());
        return correpo.save(existingCourse);

    }

    public String deleteCourseById(Long courseId) {
        if(correpo.findById(courseId).isPresent()){
            correpo.deleteById(courseId);
            return "course deleted successfully";
        }else{
            return "no course found";
        }
    }
}
