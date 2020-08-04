package com.telran;

/**
 * The interface of deque with fixed capacity. The implementations must contain a constructor accepting
 * the max number of elements.
 * @param <T>
 */

public interface OurDeque<T> {

    void addLast(T el);

    void addFirst(T el);

    T removeFirst();

    T removeLast();

    T getFirst();

    T getLast();

    int size();

}

