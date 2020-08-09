package com.telran;

import java.util.Iterator;

public class ArrayIterator implements Iterator<Integer> {

    Integer [] array;
    int currentIndexOfNumber;

    public ArrayIterator(Integer[] array) {
        this.array = array;
        currentIndexOfNumber = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndexOfNumber < array.length;
    }

    @Override
    public Integer next() {
        int res = array[currentIndexOfNumber];
        currentIndexOfNumber++;
        return res;
    }
}
