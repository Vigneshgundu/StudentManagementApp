package com.example.studentManagementApp.repositary;

import com.example.studentManagementApp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courserepo extends JpaRepository<Course,Long> {
}
