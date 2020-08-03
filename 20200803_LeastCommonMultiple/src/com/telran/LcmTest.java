package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LcmTest {

    Lcm lcm = new Lcm();

    @Test
    public void test_compute_1and1_1(){
        assertEquals(1, lcm.computeLeastCommonMultiple(1,1));
    }

    @Test
    public void test_compute_1and15_15(){
        assertEquals(15, lcm.computeLeastCommonMultiple(1,15));
        assertEquals(15, lcm.computeLeastCommonMultiple(15,1));
    }

    @Test
    public void test_compute_9and6_18(){
        assertEquals(18, lcm.computeLeastCommonMultiple(9,6));
    }

    @Test
    public void test_compute_100and5_100(){
        assertEquals(100, lcm.computeLeastCommonMultiple(100,5));
    }
}