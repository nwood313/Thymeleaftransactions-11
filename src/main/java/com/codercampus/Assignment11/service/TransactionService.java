package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
//Sort the transactions by date
public class TransactionService {
    @Autowired
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll().stream()
                                              .sorted(Comparator.comparing(Transaction::getDate))
                                              .collect(Collectors.toList());
    }
    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .findFirst()
                .orElse(null);
    }
}
