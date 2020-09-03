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

    private Node<T> getNode(int index) {
        Node<T> res = first;
        for (int i = 0; i < index; i++) {
            res = res.next;
        }
        return res;
    }

    private Node<T> getNodeByIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public void set(int index, T elt) {
        Node<T> node = getNodeByIndex(index);
        node.element = elt;

//        if (index >= size || index < 0)
//            throw new IndexOutOfBoundsException();
//
//        Node res = first;
//        for (int i = 0; i < index; i++) {
//            res = res.next;
//        }
//        res.element = elt;
    }

    /**
     * @param index of the element to return
     * @return element by index
     * @throws IndexOutOfBoundsException if the index is not between 0 and (size-1)
     */
    @Override
    public T get(int index) {
        Node<T> node = getNodeByIndex(index);
        return node.element;

//        if (index >= size || index < 0)
//            throw new IndexOutOfBoundsException();
//
//        Node res = first;
//        for (int i = 0; i < index; i++) {
//            res = res.next;
//        }
//        return (T) res.element;
    }

    @Override
    public boolean contains(T elt) {
        return findNode(elt) != null;

//        Node<T> current = first;
//
//        while (current != null) {
//            if (current.element.equals(elt)) {
//                return true;
//            }
//            current = current.next;
//        }
//
//        return false;
    }

    /**
     * The method returns the node corresponding to the elt.
     *
     * @param elt to find the node
     * @return node if found or null otherwise
     */
    private Node<T> findNode(T elt) {
        Node<T> current = first;
        while (current != null) {
            if (elt.equals(current.element))
                return current;
            current = current.next;
        }
        return null;
    }

    @Override
    public T remove(int index) {
        Node<T> nodeToRemove = getNodeByIndex(index);
        T res = nodeToRemove.element;
        removeByNode(nodeToRemove);
        return res;

//        if (index >= size || index < 0)
//            throw new IndexOutOfBoundsException();
//
//        if (index == 0) {
//            Node<T> toRemove = first;
//            first = first.next;
//            first.prev = null;
//            size--;
//            return toRemove.element;
//        }
//
//        if (index == size - 1) {
//            Node<T> toRemove = last;
//            last = last.prev;
//            last.next = null;
//            size--;
//            return toRemove.element;
//        }
//
//        Node<T> nodeToRemove = getNode(index);
//
//        nodeToRemove.next = nodeToRemove.prev.next;
//        nodeToRemove.prev = nodeToRemove.next.prev;
//
//        return nodeToRemove.element;
    }

    @Override
    public boolean remove(T elt) {
        Node<T> nodeToRemove = findNode(elt);
        if (nodeToRemove == null)
            return false;
        removeByNode(nodeToRemove);
        return true;

//        if (elt.equals(first.element)) {
//            first = first.next;
//            first.prev = null;
//            size--;
//        }
//
//        if (elt.equals(last.element)) {
//            last = last.prev;
//            last.next = null;
//            size--;
//        }
//
//        for (int i = 0; i < size - 1; i++) {
//            Node<T> nodeToRemove = getNode(i);
//            nodeToRemove.next = nodeToRemove.prev.next;
//            nodeToRemove.prev = nodeToRemove.next.prev;
//            size--;
//            return true;
//        }
//
//        return false;
    }

    private void removeByNode(Node<T> toRemove) {
        Node<T> left = toRemove.prev;
        Node<T> right = toRemove.next;

        toRemove.prev = null;
        toRemove.next = null;
        toRemove.element = null;

        if (size == 1) {
            first = last = null;
        } else if (first == toRemove) {
            right.prev = null;
            first = right;
        } else if (last == toRemove) {
            left.next = null;
            last = left;
        } else {
            right.prev = left;
            left.next = right;
        }

        size--;

    }

    @Override
    public void sort() {
        T[] array = toArray();
        Arrays.sort(array);
        updateThis(array);
    }

    private void updateThis(T[] array) {
        Node<T> current = first;
        for (int i = 0; i < size; i++) {
            current.element = array[i];
            current = current.next;
        }
    }

    private T[] toArray() {
        Object[] res = new Object[size];

        Iterator<T> it = iterator();
        int i = 0;
        while ((it.hasNext())) {
            res[i++] = it.next();
        }
        return (T[]) res;
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
            }

            @Override
            public T next() {

                T res = current.element;
                current = current.next;
                return res;

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
