package com.telran;

import java.util.*;

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
        size = 0;
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
        int index = getIndex(elt);
        return index != -1;
    }

//    @Override
//    public boolean contains(T elt) {
//        for (int i = 0; i < size; i++) {
//            if(source[i].equals(elt));
//                return true;
//        }
//        return false;
//    }

    private int getIndex(T elt){
        for (int i = 0; i < size; i++) {
            if(elt.equals(source[i]))
                return i;
        }
        return -1;
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
        int index = getIndex(elt);

        if(index == -1)
            return false;

        remove(index);
        return true;
    }

//    @Override
//    public boolean remove(T elt) {
//        for (int i = 0; i < size; i++) {
//            if(source[i].equals(elt)) {
//                source = Arrays.copyOf(source, size - i - 1);
//                size--;
//                return true;
//            }
//        }
//        return false;
//    }

    @Override
    public void sort() {
        Arrays.sort(source, 0, size);
    }

    @Override
    public void sort(Comparator<T> comparator) {
        Arrays.sort((T[]) source, 0, size, comparator);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            int currentIndexOfNumber;

            @Override
            public boolean hasNext() {
                return currentIndexOfNumber < size;
            }

            @Override
            public T next() {
                T res = (T) source[currentIndexOfNumber];
                currentIndexOfNumber++;
                return res;
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OurArrayList)) return false;
        OurArrayList<?> that = (OurArrayList<?>) o;
        return DEFAULT_CAPACITY == that.DEFAULT_CAPACITY &&
                size == that.size &&
                Arrays.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(DEFAULT_CAPACITY, size);
        result = 31 * result + Arrays.hashCode(source);
        return result;
    }
}
