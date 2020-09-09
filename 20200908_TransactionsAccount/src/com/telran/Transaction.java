package com.telran;

public class Transaction {

    private String uuid;
    private State state;
    private long balance;
    private long created;

    public Transaction(String uuid, State state, long balance, long created) {
        this.uuid = uuid;
        this.state = state;
        this.balance = balance;
        this.created = created;
    }

    public String getUniq() {
        return uuid;
    }

    public State getState() {
        return state;
    }

    public long getBalance() {
        return balance;
    }

    public long getCreated() {
        return created;
    }
}
