package com.telran;

public class Account {

    private String id;
    private long sum;
    private boolean isLocked;

    public Account(String id, long sum) {
        this.id = id;
        this.sum = sum;
        this.isLocked = false;
    }

    public String getId() {
        return id;
    }

    public long getSum() {
        return sum;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", sum=" + sum +
                ", isLocked=" + isLocked +
                '}';
    }
}


