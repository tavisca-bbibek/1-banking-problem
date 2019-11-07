package com.tavisca.javatraining.banking.accounts;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class SalaryAccount extends SavingsAccount {
    private LocalDate lastTransactionDate;

    public SalaryAccount(String accountNumber, String accountHolder) {
        super(accountNumber, accountHolder);
        lastTransactionDate = LocalDate.now();
    }

    public SalaryAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
        lastTransactionDate = LocalDate.now();
    }

    @Override
    public void process(Instant now) {
        super.process();
        if ((lastTransactionDate == null &&
                Period.between(
                        LocalDate.from(getOpeningInstant()), LocalDate.from(now)
                ).get(ChronoUnit.MONTHS) >= 2) ||
                (Period.between(LocalDate.from(getOpeningInstant()), lastTransactionDate)
                        .get(ChronoUnit.MONTHS) >= 2
                )
        )
            isFrozen = true;
    }
}
