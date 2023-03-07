package com.fiap.spring.students.repositories;


import com.fiap.spring.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
