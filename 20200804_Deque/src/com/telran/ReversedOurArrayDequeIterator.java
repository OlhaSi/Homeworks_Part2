package com.telran;

import java.util.Iterator;

public class ReversedOurArrayDequeIterator<T> implements Iterator<T> {

    OurArrayDeque<T> toIterate;
    int currentIndexNumber;

    public ReversedOurArrayDequeIterator(OurArrayDeque<T> toIterate) {
        this.toIterate = toIterate;
    }


    @Override
    public boolean hasNext() {
        return currentIndexNumber > 0;
    }

    @Override
    public T next() {
        int indexInSourceToReturn = (toIterate.firstElementId + currentIndexNumber - 1) % toIterate.capacity;
        T res = (T) toIterate.source[indexInSourceToReturn];
        currentIndexNumber--;
        return res;
    }
}
