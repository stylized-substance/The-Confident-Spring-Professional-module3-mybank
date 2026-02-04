package org.stylizedsubstance.mybank.model;

import org.stylizedsubstance.mybank.util.DateTimeUtil;

import java.util.UUID;

public class Transaction {
    private String id;
    private int amount; // Monetary amount in cents
    private String timestamp;
    private String reference;
    private String bankSlogan;

    public Transaction(int amount, String reference, DateTimeUtil dateTimeUtil, String bankSlogan) {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.timestamp = dateTimeUtil.createTimeStamp();
        this.reference = reference;
        this.bankSlogan = bankSlogan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getBankSlogan() { return bankSlogan; }

    public void setBankSlogan(String bankSlogan) { this.bankSlogan = bankSlogan; }
}
