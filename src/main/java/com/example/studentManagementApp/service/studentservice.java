package com.example.studentManagementApp.service;

import com.example.studentManagementApp.model.Student;
import com.example.studentManagementApp.repositary.studentrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class studentservice {
    @Autowired
    private studentrepo stdrepo;
    public Student enrollStudent(Student std) {
        if(stdrepo.findByrollno(std.getRollno()).isPresent()){
            throw new RuntimeException("student with"+std.getRollno()+"already exists");
        }
        return stdrepo.save(std);
    }

    public List<Student> getStudents() {
        return stdrepo.findAll();
    }

    public Student getStudentByrollno(String rollno) {
        Student std=stdrepo.findByrollno(rollno).orElseThrow(()->new RuntimeException("student not found with rollno"+rollno));
        return std;
    }

    public Student updateStudent(String rollno,Student student) {
        Student existingstudent=stdrepo.findByrollno(rollno).orElseThrow(()->new RuntimeException("student not found"));
        existingstudent.setAddress(student.getAddress());
        existingstudent.setAdmissionDate(student.getAdmissionDate());
        existingstudent.setDepartment(student.getDepartment());
        existingstudent.setGender(student.getGender());
        existingstudent.setDateOfBirth(student.getDateOfBirth());
        existingstudent.setRollno(student.getRollno());
        existingstudent.setPhone(student.getPhone());
        existingstudent.setName(student.getName());
        existingstudent.setEmail(student.getEmail());
       return  stdrepo.save(existingstudent);
    }

    @Transactional
    public String deleteStudentbyrollno(String rollno) {
        Student existingstudent=stdrepo.findByrollno(rollno).orElseThrow(()->new RuntimeException("no student found"));
        stdrepo.deleteByRollno(rollno);
        return "student with rollno "+rollno+" deleted successfully";
    }
}
