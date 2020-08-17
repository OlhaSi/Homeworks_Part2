package com.telran;

import java.util.*;

public class OurLinkedList<T> implements OurList<T> {

    private int size;
    Node<T> first;
    Node<T> last;

    private static class Node<T> {
        T element;
        Node<T> prev;
        Node<T> next;

        public Node(T elt, Node<T> prev, Node<T> next) {
            this.element = elt;
            this.prev = prev;
            this.next = next;
        }
    }


    @Override
    public void add(T elt) {
        Node<T> newNode = new Node<>(elt, null, last);

        if (size == 0) {
            last = first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void set(int index, T elt) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        res.element = elt;
    }

    /**
     * @param index of the element to return
     * @return element by index
     * @throws IndexOutOfBoundsException if the index is not between 0 and (size-1)
     */
    @Override
    public T get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        Node res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return (T) res.element;
    }

    @Override
    public boolean contains(T elt) {
        Node<T> current = first;

        while (current != null) {
            if (current.element.equals(elt)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    private Node<T> getNode(int index) {
        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();

        if (index == 0) {
            Node<T> toRemove = first;
            first = first.next;
            first.prev = null;
            size--;
            return toRemove.element;
        }

        if (index == size - 1) {
            Node<T> toRemove = last;
            last = last.prev;
            last.next = null;
            size--;
            return toRemove.element;
        }

        Node<T> nodeToRemove = getNode(index);

        nodeToRemove.next = nodeToRemove.prev.next;
        nodeToRemove.prev = nodeToRemove.next.prev;

        return nodeToRemove.element;
    }

    @Override
    public boolean remove(T elt) {
        if (elt.equals(first.element)) {
            first = first.next;
            first.prev = null;
            size--;
        }

        if (elt.equals(last.element)) {
            last = last.prev;
            last.next = null;
            size--;
        }

        for (int i = 0; i < size - 1; i++) {
            Node<T> nodeToRemove = getNode(i);
            nodeToRemove.next = nodeToRemove.prev.next;
            nodeToRemove.prev = nodeToRemove.next.prev;
            size--;
            return true;
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
        return new Iterator<T>() {

            private Node<T> current = first;

            @Override
            public boolean hasNext() {

                return current != null;

//                if (current == null){
//                    return true;
//                } else if (current == last){
//                    return false;
//                }
//                return true;
            }

            @Override
            public T next() {

                if (!hasNext())
                    throw new NoSuchElementException();

                if (current == null) {
                    current = first;
                    return current.element;
                }

                current = current.next;
                return current.element;

//                Node next = current;
//                current = current.next;
//                return (T) next.element;
            }
        };
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OurLinkedList)) return false;
        OurLinkedList<?> that = (OurLinkedList<?>) o;
        return size == that.size &&
                Objects.equals(first, that.first) &&
                Objects.equals(last, that.last);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, first, last);
    }
}
