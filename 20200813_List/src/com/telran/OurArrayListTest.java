package com.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {

    OurArrayList list = new OurArrayList<Integer>();

    @BeforeEach
    void init() {
        list = new OurArrayList<Integer>();
    }



    @Test
    public void testSize_emptyList_0() {
        assertEquals(0, list.size);
    }

    @Test
    public void testAddEltAndSize_1elt_1() {
        list.add(6);
        assertEquals(1, list.size);
    }

    @Test
    public void testSize_add7elt_3() {
        list.add(7);
        list.add(7);
        list.add(7);

        assertEquals(3, list.size);
    }

    @Test
    void testGetElt_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
    }

    @Test
    void testSetAndGetElt_addOneElt_10() {
        list.add(9);
        list.set(0, 10);
        assertEquals(10, list.get(0));
    }

    @Test
    void testGetElt_add5Elt_7() {
        list.add(9);
        list.add(8);
        list.add(9);
        list.add(6);
        list.add(5);
        list.set(2, 7);
        assertEquals(7, list.get(2));
    }

    @Test
    void testComtainsElt_add6Elt_true() {
        list.add(10);
        list.add(8);
        list.add(9);
        list.add(6);
        list.add(5);
        list.add(2);
        assertTrue(list.contains(9));
    }

    @Test
    void testComtainsElt_add6Elt_false() {
        list.add(9);
        list.add(8);
        list.add(9);
        list.add(6);
        list.add(5);
        list.add(2);
        assertFalse(list.contains(1));
    }

    @Test
    void testRemoveEltByIndex_emptyListException_IndexOutOfBoundsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
    }

    @Test
    public void testRemoveEltByIndex_addOneElt_56() {
        list.add(56);
        assertEquals(56, list.remove(0));
    }

    @Test
    void testRemoveEltByIndex_add6Elt_99() {
        list.add(99);
        list.add(87);
        list.add(9);
        list.add(66);
        list.add(99);
        list.add(20);
        assertEquals(99, list.remove(4));
    }

    @Test
    void testRemoveByElt_emptyList_False() {
        assertFalse(list.remove((Integer) 7));
    }

    @Test
    public void testRemoveByElt_addOneElt_true() {
        list.add(56);
        assertTrue(list.remove((Integer) 56));
    }

    @Test
    public void testRemoveByElt_addOneElt_false() {
        list.add(56);
        assertFalse(list.remove((Integer) 57));
    }

    @Test
    void testRemoveByElt_add6Elt_true() {
        list.add(99);
        list.add(87);
        list.add(9);
        list.add(66);
        list.add(99);
        list.add(20);
        assertTrue(list.remove((Integer) 66));
    }

    @Test
    void testRemoveByElt_add6Elt_false() {
        list.add(99);
        list.add(87);
        list.add(9);
        list.add(66);
        list.add(99);
        list.add(20);
        assertFalse(list.remove((Integer) 100));
    }






    @Test
    void testAdd_oneE_size1_equalTo() {
        list.add(5);
        assertEquals(5,list.get(0));
        assertEquals(1,list.size());
        assertTrue(list.contains(5));
    }

    @Test
    void testAdd_threeDifferentE_size3_equalTo() {
        list.add(16);
        list.add(5);
        list.add(0);
        assertEquals(16,list.get(0));
        assertEquals(5,list.get(1));
        assertEquals(0,list.get(2));
        assertEquals(3,list.size());
        assertTrue(list.contains(16));
        assertTrue(list.contains(5));
        assertTrue(list.contains(0));
        assertFalse(list.contains(100));
    }

    @Test
    void testAdd_1to100E_size100_equalTo() {
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        assertEquals(100,list.size());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(i,list.get(i));
        }
        for (int i = 0; i < 100; i++) {
            assertTrue(list.contains(i));
        }
    }

    @Test
    void testRemoveIndex_oneE_size0() {
        list.add(1);
        assertEquals(1,list.remove(0));
        assertEquals(0,list.size());
    }




    @Test
    void testRemove16E_RemoveIndex15() {
        for (int i = 0; i < 16; i++) {
            list.add(i);
        }
        assertEquals(15,list.remove(15));

    }

    @Test
    void testRemoveIndex_IndexOutOfBoundException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
    }

    @Test
    void testGet_oneE_equalTo() {
        list.add(88);
        assertEquals(88,list.get(0));
    }

    @Test
    void testGet_threeE_equalTo() {
        list.add(88);
        list.add(17);
        list.add(910);
        assertEquals(910,list.get(2));
    }

    @Test
    void testGet_IndexOutOfBoundsException() {
        list.add(1);
        assertThrows(IndexOutOfBoundsException.class,() -> list.get(1));
    }

}