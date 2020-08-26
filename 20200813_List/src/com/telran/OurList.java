package com.telran;

import java.util.Comparator;

/**
 * Standart list data structure
 * @param <T>
 */

public interface OurList<T> extends Iterable<T>{


    public void add(T elt);

    public int size();

    public void set(int index, T elt);

    public T get(int index);

    public boolean contains(T elt);

    /**
     *
     * @param index
     * @return the elt to be removed
     */
    public T remove(int index);

    /**
     *
     * @param elt
     * @return yrue if the elt found and remove
     */
    public boolean remove(T elt);

    public void sort();

    public void sort(Comparator<T> comparator);


}
