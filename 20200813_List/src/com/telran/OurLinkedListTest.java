package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurLinkedListTest {

    OurLinkedList<Integer> ourList = new OurLinkedList<>();

    @BeforeEach
    void init() {
        ourList = new OurLinkedList<>();
    }

    @Test
    public void testSize_emptyLinkedList_zero() {
        assertEquals(0, ourList.size());
    }

    @Test
    public void testAddEltAndSize_1elt_1() {
        ourList.add(1);
        assertEquals(1, ourList.size());
    }

    @Test
    public void testSize_add5elt_3() {
        ourList.add(5);
        ourList.add(3);
        ourList.add(4);

        assertEquals(3, ourList.size());
    }

    @Test
    void testGetElt_emptyLinkedListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourList.get(0));
    }

    @Test
    void testSetElt_emptyLinkedListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourList.set(0, 5));
    }

    @Test
    void testSetAndGetElt_add3Elt_15() {
        ourList.add(12);
        ourList.add(1);
        ourList.add(2);
        ourList.set(0, 15);
        assertEquals(15, ourList.get(0));
    }

    @Test
    void testContainsElt_add5Elt_true() {
        ourList.add(10);
        ourList.add(8);
        ourList.add(9);
        ourList.add(6);
        ourList.add(5);

        assertTrue(ourList.contains(5));
    }

    @Test
    void testContainsElt_add5Elt_false() {
        ourList.add(10);
        ourList.add(8);
        ourList.add(9);
        ourList.add(6);
        ourList.add(5);

        assertFalse(ourList.contains(2));
    }

    @Test
    void testRemoveEltByIndex_emptyLinkedListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourList.remove(0));
    }

    @Test
    public void testRemoveByIndex_addOneElt_10() {
        ourList.add(10);
        assertEquals(10, ourList.remove(0));
    }

    @Test
    public void testRemoveByIndex_addTwoElt_10() {
        ourList.add(10);
        ourList.add(2);
        assertEquals(10, ourList.remove(0));
    }

    @Test
    public void testRemoveByIndex_addThreeElt_5() {
        ourList.add(10);
        ourList.add(0);
        ourList.add(5);
        assertEquals(5, ourList.remove(2));
    }

    @Test
    void testRemoveByElt_emptyLinkedList_False() {
        assertFalse(ourList.remove((Integer) 3));
    }

    @Test
    public void testRemoveByElt_addOneElt_true() {
        ourList.add(4);

        assertTrue(ourList.remove((Integer) 4));
    }

    @Test
    public void testRemoveByElt_addOneElt_false() {
        ourList.add(5);
        assertFalse(ourList.remove((Integer) 7));
    }

    @Test
    public void testLinkedListIterator() {

        ourList.add(2);
        ourList.add(-1);
        ourList.add(23);
        ourList.add(4);
        ourList.add(89);

        OurLinkedList<Integer> afterIteration = new OurLinkedList<>();

        OurLinkedList<Integer> expected = new OurLinkedList<>();
        expected.add(2);
        expected.add(-1);
        expected.add(23);
        expected.add(4);
        expected.add(89);

        Iterator<Integer> it = ourList.iterator();
        while (it.hasNext()) {
            int num = it.next();
            afterIteration.add(num);
        }

        assertEquals(expected, afterIteration);
    }

    @Test
    public void testStandardIteration() {
        OurLinkedList<Integer> list = new OurLinkedList<>();
        Integer[] items = { 12, 3, 4 };
        for (int i : items) {
            list.add(i);
        }
        Iterator<Integer> it = list.iterator();
        for (Integer item : items) {
            assertTrue(it.hasNext());
            //assertEquals(item, it.hasNext());
        }
    }

}