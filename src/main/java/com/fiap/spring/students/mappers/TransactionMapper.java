package com.fiap.spring.students.mappers;

import com.fiap.spring.students.dto.TransactionDTO;
import com.fiap.spring.students.entities.Transaction;


public class TransactionMapper {

    public static TransactionDTO maptoTransactionDTO(Transaction transaction){

        TransactionDTO transactionDTO = new TransactionDTO(
                transaction.getId(),
                transaction.getDate(),
                transaction.getType(),
                transaction.getCardNumber(),
                transaction.getAmount(),
                transaction.getStudent()
        );
        return transactionDTO;
    }

    public static Transaction mapToTransaction (TransactionDTO transactionDTO){
        Transaction transaction = new Transaction(
                transactionDTO.getId(),
                transactionDTO.getDate(),
                transactionDTO.getType(),
                transactionDTO.getCardNumber(),
                transactionDTO.getAmount(),
                transactionDTO.getStudent()
        );
        return transaction;
    }
}
