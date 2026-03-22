package com.example.studentManagementApp.repositary;

import com.example.studentManagementApp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface studentrepo extends JpaRepository<Student,Long> {
    Optional<Student> findByrollno(String rollno);
    void deleteByRollno(String rollno);
}
