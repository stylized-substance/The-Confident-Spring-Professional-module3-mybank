package org.stylizedsubstance.mybank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.stylizedsubstance.mybank.model.Transaction;
import org.stylizedsubstance.mybank.util.DateTimeUtil;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {
    @Autowired
    private DateTimeUtil dateTimeUtil;

    private final String bankSlogan;

    public TransactionService(@Value("${bank.slogan}") String bankSlogan) {
        this.bankSlogan = bankSlogan;
    }

    List<Transaction> transactions = new CopyOnWriteArrayList<>();

    public List<Transaction> findAll() {
        return transactions;
    }

    public Transaction create(int amount, String reference) {
        Transaction transaction = new Transaction(amount, reference, dateTimeUtil, bankSlogan);
        transactions.add(transaction);
        return transaction;
    }
}