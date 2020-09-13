package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TransactionsCheckerTest {

    TransactionsChecker transactionsChecker = new TransactionsChecker();

    @Test
    public void testTransactionsChecker() {
        Transaction transaction1 = new Transaction("t1", State.PROCESSING, 400);
        Transaction transaction2 = new Transaction("t2", State.CANCELLED, 500);
        Transaction transaction3 = new Transaction("t3", State.FINISHED, 600);
        Transaction transaction4 = new Transaction("t4", State.CANCELLED, 0);
        Transaction transaction5 = new Transaction("t5", State.CANCELLED, 1000);

        Account account1 = new Account("a1", 300, Arrays.asList(transaction1, transaction2));
        Account account2 = new Account("a2", 700, Arrays.asList(transaction3, transaction4, transaction5));

        assertEquals(1500, transactionsChecker.getSumOfCancelled(Arrays.asList(account1, account2)));
    }

}