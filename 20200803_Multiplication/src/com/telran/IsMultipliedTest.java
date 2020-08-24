package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IsMultipliedTest {

    IsMultiplied m = new IsMultiplied();
    List<Integer> list = Arrays.asList(1,3,5,7,7,9,12);

    @Test
    public void testIsMultiplied_1_false(){
        assertFalse(m.isMultiplied(list, 1));
    }

    @Test
    public void testIsMultiplied_12_true(){
        assertTrue(m.isMultiplied(list,12));
    }

    @Test
    public void testIsMultiplied_25_false(){
        assertFalse(m.isMultiplied(list,25));
    }

    @Test
    public void testIsMultiplied_49_true(){
        assertTrue(m.isMultiplied(list,49));
    }

    @Test
    public void testIsMultiplied_124_false(){
        assertFalse(m.isMultiplied(list,124));
    }

}