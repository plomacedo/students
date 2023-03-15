package com.fiap.spring.students.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="tb_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true)
    private String enrollment;

    public Student(Long id, String name, String enrollment) {
        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
    }

    public Student(String name, String enrollment) {
        this.id = id;
        this.name = name;
        this.enrollment = enrollment;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
