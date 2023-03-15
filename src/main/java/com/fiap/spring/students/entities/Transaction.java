package com.fiap.spring.students.entities;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="tb_transaction")
public class Transaction{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String cardNumber;

    @Column(nullable = false)
    private double amount;

    @ManyToOne
    @JoinColumn(name="student_id", nullable=false)
    private Student student;

    public Transaction(Long id, Date date, String type, String cardNumber, double amount, Student student) {
        this.id = id;
        this.date = date;
        this.type = type;
        this.cardNumber = cardNumber;
        this.amount = amount;
        this.student = student;
    }

    public Transaction() {
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
