package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasinoTest {

    Casino casino = new Casino();

    @Test
    public void testGetMinBets_1dollar_0() {
        assertEquals(0, casino.getMinBets(1, 1));
    }

    @Test
    public void testGetMinBets_2dollars_1() {
        assertEquals(1, casino.getMinBets(2, 1));
    }

    @Test
    public void testGetMinBets_3dollars_1() {
        assertEquals(2, casino.getMinBets(3, 1));
    }

    @Test
    public void testGetMinBets_4dollars_2() {
        assertEquals(2, casino.getMinBets(4, 2));
    }

    @Test
    public void testGetMinBets_5dollar_3() {
        assertEquals(3, casino.getMinBets(5, 2));
    }

    @Test
    public void testGetMinBets_20dollars_6() {
        assertEquals(6, casino.getMinBets(20, 2));
    }

    @Test
    public void testGetMinBets_20dollars_10() {
        assertEquals(10, casino.getMinBets(20, 1));
    }

    @Test
    public void testGetMinBets_19dollars_7() {
        assertEquals(7, casino.getMinBets(19, 2));
    }
}
