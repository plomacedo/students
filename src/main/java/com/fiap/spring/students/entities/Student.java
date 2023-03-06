package com.fiap.spring.students.entities;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="tb_student")
public class Student {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String enrollment;

    public Student(UUID id, String name, String enrollment) {
        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
    }

    public Student() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
