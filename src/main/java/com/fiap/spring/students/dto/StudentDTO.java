package com.fiap.spring.students.dto;

import com.fiap.spring.students.entities.Student;

public class StudentDTO {

    private Long id;
    private String name;
    private String enrollment;

    public StudentDTO(Long id, String name, String enrollment) {
        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
    }

    public StudentDTO(Student student){
        id = student.getId();
        name = student.getName();
        enrollment = student.getEnrollment();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

}


