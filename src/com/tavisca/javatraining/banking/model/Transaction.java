package com.tavisca.javatraining.banking.model;

import java.time.Instant;

public class Transaction {
    private String transactionId;
    private String accountNumber;
    private String type;
    private double amount;
    private Instant transactionTime;
}
