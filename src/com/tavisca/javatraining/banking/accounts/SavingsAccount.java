package com.tavisca.javatraining.banking.accounts;

import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class SavingsAccount extends Account {

    private double sumOfEverydayBalance;
    private int dayOfQuarter;
    private double previousQAB;

    public SavingsAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
    }

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    @Override
    public void process(Instant now) {
        if (!resetQuarter(now)) {
            sumOfEverydayBalance += getBalance();
            dayOfQuarter++;
        }
    }

    private boolean resetQuarter(Instant now) {
        boolean isFirstQuarter = LocalDate.from(now).isEqual(
                LocalDate.from(now)
                        .withMonth(2)
                        .with(TemporalAdjusters.lastDayOfMonth())
        );

        boolean isSecondQuarter = LocalDate.from(now).isEqual(
                LocalDate.from(now)
                        .withMonth(5)
                        .with(TemporalAdjusters.lastDayOfMonth())
        );

        boolean isThirdQuarter = LocalDate.from(now).isEqual(
                LocalDate.from(now)
                        .withMonth(8)
                        .with(TemporalAdjusters.lastDayOfMonth())
        );

        boolean isFourthQuarter = LocalDate.from(now).isEqual(
                LocalDate.from(now)
                        .withMonth(11)
                        .with(TemporalAdjusters.lastDayOfMonth())
        );

        if (!(isFirstQuarter && isSecondQuarter && isThirdQuarter && isFourthQuarter))
            return false;

        previousQAB = sumOfEverydayBalance / dayOfQuarter;
        sumOfEverydayBalance = getBalance();
        dayOfQuarter = 1;
        return true;
    }
}
