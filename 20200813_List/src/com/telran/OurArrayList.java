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
    final int DEFAULT_CAPACITY = 16;
    int size;

    public OurArrayList() {
        this.source = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        int newSize = source.length * 2;
        source = Arrays.copyOf(source, newSize);
    }

    @Override
    public void add(T elt) {
        if (size == source.length)
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
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();
        else
            source[index] = elt;
    }

    @Override
    public T get(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        return (T) source[index];
    }

    @Override
    public boolean contains(T elt) {
        for (int i = 0; i < size; i++) {
            if(source[i] == elt)
                return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if(index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        T result = (T) source[index];
        source = Arrays.copyOf(source, size - index -1);
        size--;

        return result;
    }

    @Override
    public boolean remove(T elt) {
        for (int i = 0; i < size; i++) {
            if(source[i] == elt) {
                source = Arrays.copyOf(source, size - i - 1);
                size--;
                return true;
            }
        }
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
