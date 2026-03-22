package com.example.studentManagementApp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotBlank(message = "Student roll no is required")
    @Column(unique = true)
    private String rollno;
    @NotBlank(message = "student name is required")
    private String name;
    @NotBlank(message = "student email is required")
    private String email;
    @NotBlank(message = "student phone no is required")
    private String phone;
    @NotBlank(message = "student gender is required")
    private String gender;
    @NotNull(message = "date of birth is required")
    private LocalDate dateOfBirth;
    @NotBlank(message = "student address is required")
    private String address;
    private String department;
    private LocalDate admissionDate;

    public void setId(Long id) {
        this.id = id;
    }

    public String getRollno() {
        return rollno;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }
}
