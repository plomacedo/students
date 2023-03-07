package com.fiap.spring.students.services;

import com.fiap.spring.students.dto.StudentDTO;
import com.fiap.spring.students.dto.TransactionDTO;
import com.fiap.spring.students.entities.Student;
import com.fiap.spring.students.entities.Transaction;
import com.fiap.spring.students.mappers.StudentMapper;
import com.fiap.spring.students.mappers.TransactionMapper;
import com.fiap.spring.students.repositories.StudentRepository;
import com.fiap.spring.students.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        Transaction entity = TransactionMapper.mapToTransaction(transactionDTO);
        Transaction savedTransaction = repository.save(entity);
        TransactionDTO savedTransactionDTO = TransactionMapper.maptoTransactionDTO(savedTransaction);
        return savedTransactionDTO;
    }

    public List<Transaction> getAllTransactions() {
        return repository.findAll();
    }

    public List<Transaction> getTransactionsByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id " + studentId + " not found"));

        return repository.findByStudent(student);
    }
}
