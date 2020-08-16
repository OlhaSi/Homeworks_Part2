package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {

    OurArrayList<Integer> ourArrayList = new OurArrayList<Integer>();

    @BeforeEach
    void init() {
        ourArrayList = new OurArrayList<>();
    }

    @Test
    public void testSize_emptyList_zero() {
        assertEquals(0, ourArrayList.size);
    }

    @Test
    public void testAddEltAndSize_1elt_1() {
        ourArrayList.add(6);
        assertEquals(1, ourArrayList.size);
    }

    @Test
    public void testSize_add5elt_3() {
        ourArrayList.add(5);
        ourArrayList.add(5);
        ourArrayList.add(5);

        assertEquals(3, ourArrayList.size);
    }

    @Test
    void testGetElt_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourArrayList.get(0));
    }

    @Test
    void testSetAndGetElt_addOneElt_10() {
        ourArrayList.add(9);
        ourArrayList.set(0, 10);
        assertEquals(10, ourArrayList.get(0));
    }

    @Test
    void testGetElt_add5Elt_7() {
        ourArrayList.add(9);
        ourArrayList.add(8);
        ourArrayList.add(9);
        ourArrayList.add(6);
        ourArrayList.add(5);
        ourArrayList.set(2, 7);
        assertEquals(7, ourArrayList.get(2));
    }

    @Test
    void testContainsElt_add6Elt_true() {
        ourArrayList.add(10);
        ourArrayList.add(8);
        ourArrayList.add(9);
        ourArrayList.add(6);
        ourArrayList.add(5);
        ourArrayList.add(2);
        assertTrue(ourArrayList.contains(9));
    }

    @Test
    void testContainsElt_add6Elt_false() {
        ourArrayList.add(9);
        ourArrayList.add(8);
        ourArrayList.add(9);
        ourArrayList.add(6);
        ourArrayList.add(5);
        ourArrayList.add(2);
        assertFalse(ourArrayList.contains(1));
    }

    @Test
    void testRemoveEltByIndex_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> ourArrayList.remove(0));
    }

    @Test
    public void testRemoveEltByIndex_addOneElt_56() {
        ourArrayList.add(56);
        assertEquals(56, ourArrayList.remove(0));
    }

    @Test
    void testRemoveEltByIndex_add6Elt_99() {
        ourArrayList.add(99);
        ourArrayList.add(87);
        ourArrayList.add(9);
        ourArrayList.add(66);
        ourArrayList.add(99);
        ourArrayList.add(20);
        assertEquals(99, ourArrayList.remove(4));
    }

    @Test
    void testRemoveByElt_emptyList_False() {
        assertFalse(ourArrayList.remove((Integer) 7));
    }

    @Test
    public void testRemoveByElt_addOneElt_true() {
        ourArrayList.add(56);
        assertTrue(ourArrayList.remove((Integer) 56));
    }

    @Test
    public void testRemoveByElt_addOneElt_false() {
        ourArrayList.add(56);
        assertFalse(ourArrayList.remove((Integer) 57));
    }

    @Test
    void testRemoveByElt_add6Elt_true() {
        ourArrayList.add(99);
        ourArrayList.add(87);
        ourArrayList.add(9);
        ourArrayList.add(66);
        ourArrayList.add(99);
        ourArrayList.add(20);
        assertTrue(ourArrayList.remove((Integer) 66));
    }

    @Test
    void testRemoveByElt_add6Elt_false() {
        ourArrayList.add(99);
        ourArrayList.add(87);
        ourArrayList.add(9);
        ourArrayList.add(66);
        ourArrayList.add(99);
        ourArrayList.add(20);
        assertFalse(ourArrayList.remove((Integer) 100));
    }


    @Test
    void testAdd_oneE_size1_equalTo() {
        ourArrayList.add(5);
        assertEquals(5, ourArrayList.get(0));
        assertEquals(1, ourArrayList.size());
        assertTrue(ourArrayList.contains(5));
    }

    @Test
    void testAdd_threeDifferentE_size3_equalTo() {
        ourArrayList.add(16);
        ourArrayList.add(5);
        ourArrayList.add(0);
        assertEquals(16, ourArrayList.get(0));
        assertEquals(5, ourArrayList.get(1));
        assertEquals(0, ourArrayList.get(2));
        assertEquals(3, ourArrayList.size());
        assertTrue(ourArrayList.contains(16));
        assertTrue(ourArrayList.contains(5));
        assertTrue(ourArrayList.contains(0));
        assertFalse(ourArrayList.contains(100));
    }

    @Test
    void testAdd_1to100E_size100_equalTo() {
        for (int i = 0; i < 100; i++) {
            ourArrayList.add(i);
        }
        assertEquals(100, ourArrayList.size());
        for (int i = 0; i < ourArrayList.size(); i++) {
            assertEquals(i, ourArrayList.get(i));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(ourArrayList.contains(i));
        }
    }

    @Test
    void testRemoveIndex_oneE_size0() {
        ourArrayList.add(1);
        assertEquals(1, ourArrayList.remove(0));
        assertEquals(0, ourArrayList.size());
    }


    @Test
    void testRemove16consistentNums_RemoveIndex15() {
        for (int i = 0; i < 16; i++) {
            ourArrayList.add(i);
        }
        int res = ourArrayList.remove(15);
        assertEquals(15, res);

    }

    @Test
    void testRemoveIndex_IndexOutOfBoundException() {
        ourArrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> ourArrayList.remove(1));
    }


    @Test
    void testAdd_onePoint_containsExistingPoint() {
        OurArrayList<Point2D> pointList = new OurArrayList<>();

        pointList.add(new Point2D(1,1));

        Point2D expected = new Point2D(1,1);
        assertTrue(pointList.contains(expected));
    }


    @Test
    void testGet_oneE_equalTo() {
        ourArrayList.add(88);
        assertEquals(88, ourArrayList.get(0));
    }

    @Test
    void testGet_threeE_equalTo() {
        ourArrayList.add(88);
        ourArrayList.add(17);
        ourArrayList.add(910);
        assertEquals(910, ourArrayList.get(2));
    }

    @Test
    void testGet_IndexOutOfBoundsException() {
        ourArrayList.add(1);
        assertThrows(IndexOutOfBoundsException.class,() -> ourArrayList.get(1));
    }

    @Test
    public void testArrayIterator(){

        ourArrayList.add(2);
        ourArrayList.add(-1);
        ourArrayList.add(23);
        ourArrayList.add(4);
        ourArrayList.add(89);

        OurArrayList<Integer> afterIteration = new OurArrayList<>();

        OurArrayList<Integer> expected = new OurArrayList<>();
        expected.add(2);
        expected.add(-1);
        expected.add(23);
        expected.add(4);
        expected.add(89);

        Iterator<Integer> it = ourArrayList.iterator();
        while (it.hasNext()){
            int num = it.next();
            afterIteration.add(num);
        }

        assertEquals(expected, afterIteration);
    }

    @Test
    public void testSort_add16elt_9() {

        ourArrayList.add(15);
        ourArrayList.add(16);
        ourArrayList.add(11);
        ourArrayList.add(3);
        ourArrayList.add(12);
        ourArrayList.add(14);
        ourArrayList.add(1);
        ourArrayList.add(9);
        ourArrayList.add(8);
        ourArrayList.add(7);
        ourArrayList.add(4);
        ourArrayList.add(5);
        ourArrayList.add(6);
        ourArrayList.add(13);
        ourArrayList.add(10);
        ourArrayList.add(2);

        ourArrayList.sort();
        assertEquals(9, ourArrayList.get(8));
    }

    @Test
    public void testSortWithComparator_add10elt_9() {

        OurComparator comparator = new OurComparator();

        ourArrayList.add(15);
        ourArrayList.add(16);
        ourArrayList.add(11);
        ourArrayList.add(3);
        ourArrayList.add(12);
        ourArrayList.add(14);
        ourArrayList.add(1);
        ourArrayList.add(9);
        ourArrayList.add(8);
        ourArrayList.add(7);
        ourArrayList.add(4);
        ourArrayList.add(5);
        ourArrayList.add(6);
        ourArrayList.add(13);
        ourArrayList.add(10);
        ourArrayList.add(2);

        ourArrayList.sort(comparator);
        assertEquals(9, ourArrayList.get(8));
    }
}