package com.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxElementInStackTest {

    MaxElementInStack stack = new MaxElementInStack();

    @Test
    public void testStack_mixedArray_correctMaxNumber(){
        stack.insert(2);
        stack.insert(-1);
        stack.insert(5);
        stack.insert(8);
        stack.insert(3);

        assertEquals(8, stack.getMax());
    }

}