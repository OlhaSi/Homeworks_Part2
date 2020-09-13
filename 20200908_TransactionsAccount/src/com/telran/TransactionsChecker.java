package com.telran;

import java.util.List;
import java.util.function.Predicate;

public class TransactionsChecker {

    Predicate<Transaction> cancelledTransaction = transaction -> transaction.getState() == State.CANCELLED;
    Predicate<Account> overZero = account -> account.getBalance() > 0;

    public long getSumOfCancelled(List<Account> accounts) {
        return accounts.stream()
                .filter(overZero)
                .flatMap(account -> account.getTransactions()
                        .stream())
                .filter(cancelledTransaction)
                .mapToLong(Transaction::getBalance)
                .sum();
    }
}
