package com.tavisca.javatraining.banking;

import com.tavisca.javatraining.banking.accounts.Account;
import com.tavisca.javatraining.banking.model.Transaction;

import java.util.Scanner;

public class Bank {
    private String name;
    Account[] accounts;
    Transaction[] transactions;
    AccountNumberGenerator generator = new AccountNumberGenerator();

    Scanner sc = new Scanner(System.in);

    public Bank(String name) {
        this.name = name;
        accounts = new Account[0];
        transactions = new Transaction[0];
    }

    public String getName() {
        return name;
    }

    public void openAccount() {
        System.out.println("Enter information");
        System.out.print("| Name: ");
        String name = sc.next();
        System.out.print("| Initial amount: ");
        double amount = sc.nextDouble();
        String accountNumber = generator.generate();
    }


    public void closeAccount() {

    }

    public void deposit() {

    }

    public void withdraw() {

    }

    public void printTransactions() {

    }
}
