package com.telran;

import java.util.List;

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

    public long getSumOfBlocked(List<Account> blocked) {
        return blocked.stream()
                .filter(account -> account.isLocked())
                .reduce(0L, (account, account2) -> account + account2.getSum(), Long::sum);
    }
}
