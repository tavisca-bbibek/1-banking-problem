package com.tavisca.javatraining.banking;

public class AccountNumberGenerator {
    private long sequence;

    public String generate() {
        return String.valueOf(++sequence);
    }
}
