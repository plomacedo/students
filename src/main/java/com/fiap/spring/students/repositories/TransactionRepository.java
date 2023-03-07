package com.fiap.spring.students.repositories;

import com.fiap.spring.students.entities.Student;
import com.fiap.spring.students.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByStudent(Student student);
}
