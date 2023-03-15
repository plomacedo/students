package com.fiap.spring.students.controller;

import com.fiap.spring.students.dto.StudentDTO;
import com.fiap.spring.students.dto.TransactionDTO;
import com.fiap.spring.students.entities.Transaction;
import com.fiap.spring.students.mappers.StudentMapper;
import com.fiap.spring.students.services.StudentService;
import com.fiap.spring.students.services.TransactionService;
import com.github.javafaker.Faker;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/transactions")
@Api(value="API REST Transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private StudentService studentService;
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

    @GetMapping("/{studentId}/report")
    public ResponseEntity<byte[]> createTransactionReport(@PathVariable Long studentId) throws IOException {

        List<Transaction> transactionList = transactionService.getTransactionsByStudentId(studentId);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
        writer.write("ID,Card Number,Value, Type, Date\n");
        for (Transaction transaction : transactionList) {
            writer.write(String.format("%d,%s,%.2f, %s, %s", transaction.getId(), transaction.getCardNumber(), transaction.getAmount(), transaction.getType(), transaction.getDate()));
            writer.newLine();
        }

        writer.flush();
        writer.close();

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment; filename=transactions_student_%s.csv", studentId));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(outputStream.toByteArray().length)
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(outputStream.toByteArray());

    }

    @PostMapping("/random/{quantity}")
    @ApiOperation(value="this method creates a set of random transactions")
    public ResponseEntity<String> createRandomTransaction(@PathVariable Integer quantity) {

        List<StudentDTO> studentsDto = studentService.getAllStudents();
        Random rand = new Random();
        Faker faker = new Faker();
        for (int i = 0; i < quantity; i++) {
            TransactionDTO transactionDTO = new TransactionDTO();
            transactionDTO.setStudent(StudentMapper.mapToStudent(studentsDto.get(rand.nextInt(studentsDto.size()))));
            transactionDTO.setDate(faker.date().past(365, TimeUnit.DAYS));
            transactionDTO.setType(faker.business().creditCardType());
            transactionDTO.setCardNumber(faker.business().creditCardNumber());
            transactionDTO.setAmount(faker.random().nextDouble());
            transactionService.createTransaction(transactionDTO);
        }

        return new ResponseEntity<>(String.format("created: %s", quantity), HttpStatus.CREATED);
    }
}
