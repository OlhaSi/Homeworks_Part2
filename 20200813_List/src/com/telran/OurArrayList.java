package com.telran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/**
 * An implementation of the list data structure,
 * made via array under the hood.
 * The initial array has length 16.
 * In the case the array is full, a new array with the capacity
 * of 2*<old length> must be created as a new source for the elements.
 *
 * @param <T>
 */

public class OurArrayList<T> implements OurList<T> {

    Object[] source;
    int capacity;
    int size;

    public OurArrayList(int capacity) {
        this.source = new Object[capacity];
        this.capacity = 16;
    }

    private void ensureCapacity() {
        int newSize = source.length * 2;
        source = Arrays.copyOf(source, newSize);
    }

    @Override
    public void add(T elt) {
        if (size == capacity)
            ensureCapacity();

        source[size] = elt;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T elt) {

    }

    @Override
    public T get(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return (T) source[index];
    }

    @Override
    public boolean contains(T elt) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public boolean remove(T elt) {
        return false;
    }

    @Override
    public void sort() {

    }

    @Override
    public void sort(Comparator<T> comparator) {

    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
