package com.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIteratorTest {

    @Test
    public void testIterator(){
        Integer[] array = new Integer[]{8, -5, 2, -1, 10, 0, -7};
        List<Integer> expected = Arrays.asList(-5, -1, -7, 8, 2, 10, 0);
        List<Integer> arrayNegativ = new ArrayList<>();
        List<Integer> arrayPositiv = new ArrayList<>();

        ArrayIterator it = new ArrayIterator(array);
        while (it.hasNext()){
            int num = it.next();
            if(num < 0){
                arrayNegativ.add(num);
            }
            if(num >= 0){
                arrayPositiv.add(num);
            }
        }
        arrayNegativ.addAll(arrayPositiv);

        assertEquals(expected, arrayNegativ);
    }
}