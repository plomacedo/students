package com.fiap.spring.students.controller;

import com.fiap.spring.students.dto.TransactionDTO;
import com.fiap.spring.students.entities.Transaction;
import com.fiap.spring.students.services.TransactionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    @ApiOperation(value="this method creates a new transaction")
    public ResponseEntity<TransactionDTO> createTransaction(@RequestBody TransactionDTO transactionDTO) {

        TransactionDTO savedTransaction = transactionService.createTransaction(transactionDTO);
        return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<List<Transaction>> getTransactionsByStudentId(@PathVariable Long studentId) {
        List<Transaction> transactions = transactionService.getTransactionsByStudentId(studentId);
        return ResponseEntity.ok(transactions);
    }
}
