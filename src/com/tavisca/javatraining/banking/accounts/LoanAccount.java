package com.tavisca.javatraining.banking.accounts;

import java.time.Instant;

public class LoanAccount extends SavingsAccount {
    private double repaidBalance;
    private double interest;
    private static final double INTEREST_RATE = 3.0d;

    public LoanAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    public LoanAccount(String accountNumber, String accountHolder, double loanAmount) {
        super(accountNumber, accountHolder, -loanAmount);
    }

    public synchronized boolean pay(double amount) {
        if (getBalance() + repaidBalance + amount > 0)
            return false;
        repaidBalance += amount;
        return true;
    }

    public boolean deposit(double amount) {
        return pay(amount);
    }

    public void process(Instant now) {
        super.process();
        interest += getDailyInterest();
    }

    private double getDailyInterest() {
        return -getBalance() * (12.0d / 365.0d) * (INTEREST_RATE / 100);
    }

    @Override
    public double getBalance() {
        return super.getBalance() - interest;
    }
}
