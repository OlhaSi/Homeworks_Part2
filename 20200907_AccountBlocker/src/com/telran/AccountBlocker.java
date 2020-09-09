package com.telran;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AccountBlocker {

    public AccountBlocker() {
    }

    public void blockOverLimit(List<Account> accounts, int limit) {
//        for (Account account : accounts) {
//            if (account.getSum() > limit) {
//                account.setLocked(true);
//            }
//        }
        accounts.stream()
                .filter(account -> account.getSum() > limit)
                .forEach(account -> account.setLocked(true));
    }

    // another option
//    public void blockOverLimit2(List<Account> accounts, int limit) {
//        Stream<Account> accountStream = accounts.stream();
//
//        List<Boolean> res = accountStream
//                .filter(account -> account.getSum() > limit)
//                .map(account -> account.isLocked() = false)
//                .collect(Collectors.toList());
//    }

    public long getSumOfBlocked(List<Account> blocked) {
        return blocked.stream()
                .filter(account -> account.isLocked())
                .reduce(0L, (account, account2) -> account + account2.getSum(), Long::sum);
    }

    // the same option but using map
    public long getSumOfBlocked2(List<Account> blocked) {
        return blocked.stream()
                .filter(account -> account.isLocked())
                .mapToLong(Account::getSum)
                .sum();
    }
}
