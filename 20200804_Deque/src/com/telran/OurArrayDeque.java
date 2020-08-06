package com.telran;

import java.util.Iterator;

public class OurArrayDeque<T> implements OurDeque<T> {

    int size;
    int firstElementId;
    final int capacity;

    final Object[] source;

    public OurArrayDeque(int capacity){
        this.capacity = capacity;
        source = new Object[capacity];
    }

    @Override
    public void addLast(T el) {
        if(size == capacity)
            throw new OurDequeOverflowException();

        int nextIndex = (firstElementId + size) % capacity;
        source[nextIndex] = el;

        size++;
    }

    @Override
    public void addFirst(T elt) {
        if (size == capacity)
            throw new OurDequeOverflowException();

        if (firstElementId > 0)
            firstElementId--;
        else
            firstElementId = capacity - 1;

        source[firstElementId] = elt;
        size++;
    }

    /*@Override
    public void addFirst(T el) {
        if(size == capacity)
            throw new OurDequeOverflowException();

        if(firstElementId == 0)
            source[firstElementId] = el;

        else
            firstElementId = (firstElementId + size -1) % capacity;
            source[firstElementId] = el;

        size++;
    }*/

    @Override
    public T removeFirst() {
        if(size == 0)
            throw new OurDequeEmptyException();

        T result = (T) source[firstElementId];
        firstElementId = (firstElementId + 1) % capacity;
        size--;

        return result;
    }

    @Override
    public T removeLast() {
        if(size == 0)
            throw new OurDequeEmptyException();

        int lastElementId = (firstElementId + size - 1) % capacity;
        T result = (T) source[lastElementId];
        size--;

        return result;
    }

    @Override
    public T getFirst() {
        if(size == 0)
            throw new OurDequeEmptyException();

        return (T) source[firstElementId];
    }

    @Override
    public T getLast() {
        if(size == 0)
            throw new OurDequeEmptyException();

        int lastElementId = (firstElementId + size - 1) % capacity;
        T result = (T) source[lastElementId];

        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new DefaultIterator();
    }

    private class DefaultIterator implements Iterator<T> {

        /**
         * the number of the current element from 0 to (size-1)
         */
        int currentIndexNumber;

        @Override
        public boolean hasNext() {
            return currentIndexNumber < size;
        }

        @Override
        public T next() {
            int indexInSourceToReturn = (firstElementId + currentIndexNumber) % capacity;
            T res = (T) source[indexInSourceToReturn];
            currentIndexNumber++;
            return res;
        }
    }
}
