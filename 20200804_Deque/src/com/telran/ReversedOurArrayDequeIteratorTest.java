package com.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReversedOurArrayDequeIteratorTest {

    OurArrayDeque<Integer> ourArrayDeque = new OurArrayDeque<>(16);

    @Test
    public void testIterator(){

        ourArrayDeque.addFirst(8);
        ourArrayDeque.addLast(3);
        ourArrayDeque.addFirst(10);
        ourArrayDeque.addFirst(-3);
        ourArrayDeque.addLast(5);
        ourArrayDeque.addFirst(-5);

        List<Integer> result = new ArrayList<>();
        List<Integer> expected = Arrays.asList(5, 3, 8, 10, -3, -5);

        Iterator<Integer> it = new ReversedOurArrayDequeIterator<>(ourArrayDeque);
        while(it.hasNext()){
            int current = it.next();
            result.add(current);
        }

        assertEquals(expected, result);
    }

    @Test
    public void testIterator_mixedDeque_(){
        //ourArrayDeque = new OurArrayDeque<>(2);

        ourArrayDeque.addFirst(8);
        ourArrayDeque.addLast(3);
        ourArrayDeque.addFirst(10);
        ourArrayDeque.addFirst(-3);
        ourArrayDeque.addLast(5);
        ourArrayDeque.addFirst(-5);

        List<Integer> result = new ArrayList<>();
        List<Integer> expected = Arrays.asList(5, 3, 8, 10, -3, -5);

        Iterator<Integer> it = new ReversedOurArrayDequeIterator<>(ourArrayDeque);
        while(it.hasNext()){
            int current = it.next();
            result.add(current);
        }

        assertEquals(expected, result);
    }

    @Test
    public void testIterator_noElements_noIteration(){
        Iterator<Integer> it = new ReversedOurArrayDequeIterator<>(ourArrayDeque);

        assertFalse(it.hasNext());
    }

}