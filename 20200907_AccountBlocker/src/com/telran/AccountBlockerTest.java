package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AccountBlockerTest {

    AccountBlocker blocker = new AccountBlocker();

    @Test
    public void testBlockOverLimit_2accounts_true() {
        Account account1 = new Account("1", 5000);
        Account account2 = new Account("2", 1000);

        List<Account> accounts = Arrays.asList(account1, account2);

        blocker.blockOverLimit(accounts, 50);

        assertTrue(account1.isLocked());
        assertTrue(account2.isLocked());
    }

    @Test
    public void testBlockOverLimit_2accounts_false() {
        Account account1 = new Account("1", 5000);
        Account account2 = new Account("2", 1000);

        List<Account> accounts = Arrays.asList(account1, account2);

        blocker.blockOverLimit(accounts, 60000);

        assertFalse(account1.isLocked());
        assertFalse(account2.isLocked());
    }

    @Test
    public void testGetSumOfBlocked_2accounts_1blocked() {
        Account account1 = new Account("1", 5000);
        Account account2 = new Account("2", 1000);
        account1.setLocked(true);

        List<Account> accounts = Arrays.asList(account1, account2);

        long actual = blocker.getSumOfBlocked(accounts);
        assertEquals(5000, actual);
    }

    @Test
    public void testGetSumOfBlocked_2accounts_2blocked() {
        Account account1 = new Account("1", 5000);
        Account account2 = new Account("2", 1000);
        account1.setLocked(true);
        account2.setLocked(true);

        List<Account> accounts = Arrays.asList(account1, account2);

        long actual = blocker.getSumOfBlocked(accounts);
        assertEquals(6000, actual);
    }

}