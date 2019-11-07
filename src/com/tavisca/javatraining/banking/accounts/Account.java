package com.tavisca.javatraining.banking.accounts;

import java.time.Instant;

public abstract class Account {
    private double balance;
    private String accountNumber;
    private String accountHolder;
    private Instant openingInstant;
    protected boolean isFrozen;

    public Account(String accountNumber, String accountHolder) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public Account(String accountNumber, String accountHolder, double balance) {
        this.balance = balance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Instant getOpeningInstant() {
        return openingInstant;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public synchronized boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public synchronized boolean withdraw(double amount) {
        if (isFrozen)
            return false;
        balance -= amount;
        return true;
    }

    public abstract void process(Instant now);

    public void process() {
        process(Instant.now());
    }
}
