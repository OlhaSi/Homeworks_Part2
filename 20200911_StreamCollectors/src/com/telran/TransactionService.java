package com.telran;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionService {

    public Map<String, Long> getSumByAcc(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors
                        .groupingBy(Transaction::getAccountId, Collectors
                                .summingLong(Transaction::getSum)));
    }

}
