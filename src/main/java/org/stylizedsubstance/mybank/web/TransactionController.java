package org.stylizedsubstance.mybank.web;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.stylizedsubstance.mybank.dto.TransactionDto;
import org.stylizedsubstance.mybank.model.Transaction;
import org.stylizedsubstance.mybank.service.TransactionService;

import java.util.List;

@RestController
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions() {
        return transactionService.findAll();
    }

    @PostMapping("/transactions")
    public Transaction createTransaction(@RequestBody @Valid TransactionDto transactionDto) {
        return transactionService.create(transactionDto.getAmount(), transactionDto.getReference());
    }
}
