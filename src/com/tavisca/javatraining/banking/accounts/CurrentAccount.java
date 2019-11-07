package com.tavisca.javatraining.banking.accounts;

public class CurrentAccount extends Account {
    private static final double MAX_WITHDRAW_LIMIT = 50000;

    public CurrentAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    public CurrentAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if (MAX_WITHDRAW_LIMIT + getBalance() - amount < 0)
            return false;
        return super.withdraw(amount);
    }

}
