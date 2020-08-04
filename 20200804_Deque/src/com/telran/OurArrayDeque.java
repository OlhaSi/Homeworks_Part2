package com.telran;

public class OurArrayDeque<T> implements OurDeque<T> {

    private int size;
    private int firstElementId;
    private final int capacity;

    private final Object[] source;

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
    public void addFirst(T el) {
        if(size == capacity)
            throw new OurDequeOverflowException();

        if(firstElementId == 0)
            source[firstElementId] = el;

        else
            firstElementId = (firstElementId - 1 + size) % capacity;
            source[firstElementId] = el;

        size++;
    }

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

        T result = (T) source[firstElementId];
        firstElementId = (firstElementId - 1 + size) % capacity;
        size--;

        return result;
    }

    @Override
    public T getFirst() {
        return (T) source[firstElementId];
    }

    @Override
    public T getLast() {
        return (T) source[firstElementId + size - 1];
    }

    @Override
    public int size() {
        return size;
    }
}
