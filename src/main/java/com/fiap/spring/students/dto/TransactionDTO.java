package com.fiap.spring.students.dto;

import com.fiap.spring.students.entities.Student;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

public class TransactionDTO {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Date date;

    private String type;

    private String cardNumber;

    private double amount;

    private Student student;

    public TransactionDTO(Long id, Date date, String type, String cardNumber, double amount, Student student) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.student = student;
    }

    public TransactionDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
