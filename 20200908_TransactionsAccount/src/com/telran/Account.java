package com.telran;

import java.util.List;

public class Account {

    private String uuid;
    private long balance;
    private List<Transaction> transactions;

    public Account(String uniq, long balance, List<Transaction> transactions) {
        this.uuid = uniq;
        this.balance = balance;
        this.transactions = transactions;
    }

    public String getUniq() {
        return uuid;
    }

    public long getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
