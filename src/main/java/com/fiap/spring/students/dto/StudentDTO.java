package com.fiap.spring.students.dto;

import com.fiap.spring.students.entities.Student;

import java.util.UUID;

public class StudentDTO {

    private UUID id;
    private String name;
    private String enrollment;

    public StudentDTO(UUID id, String name, String enrollment) {
        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
    }

    public StudentDTO(Student student){
        id = student.getId();
        name = student.getName();
        enrollment = student.getEnrollment();
    }

    public UUID getId() {
        return id;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
