package com.telran;

public class Transaction {

    String uuid;
    String accountId;
    long sum;

    public Transaction(String uuid, String accountId, long sum) {
        this.uuid = uuid;
        this.accountId = accountId;
        this.sum = sum;
    }

    public String getUuid() {
        return uuid;
    }

    public String getAccountId() {
        return accountId;
    }

    public long getSum() {
        return sum;
    }
}
