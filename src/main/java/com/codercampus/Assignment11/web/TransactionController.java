package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public String getAllTransactions(ModelMap model) {
        List<Transaction>transactions = transactionService.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return "transactions"; //for the URL
    }

    @GetMapping("/transactions{transactionId}")
    public String getTransactionDetails(@PathVariable Long transactionId, ModelMap model) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        model.addAttribute("transaction", transaction);
        return "transaction-details"; //

    }
}
