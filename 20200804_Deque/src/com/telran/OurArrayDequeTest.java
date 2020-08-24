package com.telran;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayDequeTest {

    OurArrayDeque<Integer> ourArrayDeque = new OurArrayDeque<>(16);

    @Test
    public void testSize_newInstance_0(){
        assertEquals(0, ourArrayDeque.size());
    }

    @Test
    public void testSize_addLast3Elements_3(){
        ourArrayDeque.addLast(5);
        ourArrayDeque.addLast(2);
        ourArrayDeque.addLast(7);

        assertEquals(3, ourArrayDeque.size());
    }

    @Test
    public void testSize_addFirst2Elements_2(){
        ourArrayDeque.addLast(5);
        ourArrayDeque.addLast(2);

        assertEquals(2, ourArrayDeque.size());
    }

    @Test
    public void testSize_addFirst2ElementsAndLast1_3(){
        ourArrayDeque.addLast(5);
        ourArrayDeque.addLast(2);
        ourArrayDeque.addLast(1);

        assertEquals(3, ourArrayDeque.size());
    }

    @Test
    public void testAddLast_add1el_present(){
        ourArrayDeque.addLast(5);

        assertEquals(5, ourArrayDeque.getLast());
    }

    @Test
    public void testAddLast_add2el_present(){
        ourArrayDeque.addLast(5);
        ourArrayDeque.addLast(7);
        assertEquals(7, ourArrayDeque.getLast());
    }

    @Test
    public void testAddLast_add3el_present(){
        ourArrayDeque.addLast(5);
        ourArrayDeque.addLast(7);
        ourArrayDeque.addLast(-1);
        assertEquals(-1, ourArrayDeque.getLast());
    }

    @Test
    public void testAddFirst_add1el_present(){
        ourArrayDeque.addFirst(5);

        assertEquals(5, ourArrayDeque.getFirst());
    }

    @Test
    public void testAddFirst_add2el_present(){
        ourArrayDeque.addFirst(5);
        ourArrayDeque.addFirst(7);
        assertEquals(7, ourArrayDeque.getFirst());
    }

    @Test
    public void testAddFirst_add3el_present(){
        ourArrayDeque.addFirst(5);
        ourArrayDeque.addFirst(7);
        ourArrayDeque.addFirst(-1);
        assertEquals(-1, ourArrayDeque.getFirst());
    }

    @Test
    public void testAddLast_add1el_getFirstGetLast(){
        ourArrayDeque.addLast(3);
        assertEquals(3, ourArrayDeque.getFirst());
        assertEquals(3, ourArrayDeque.getLast());
    }

    @Test
    public void testAddFirst_add2el_getFirstGetLast(){
        ourArrayDeque.addFirst(3);
        ourArrayDeque.addFirst(8);
        assertEquals(8, ourArrayDeque.getFirst());
        assertEquals(3, ourArrayDeque.getLast());
    }

    @Test
    public void testAddFirstAndAddLast_add5el_getFirstGetLast(){
        ourArrayDeque.addLast(3);
        ourArrayDeque.addFirst(8);
        ourArrayDeque.addFirst(4);
        ourArrayDeque.addLast(0);
        ourArrayDeque.addLast(-9);
        assertEquals(4, ourArrayDeque.getFirst());
        assertEquals(-9, ourArrayDeque.getLast());

        assertEquals(5, ourArrayDeque.size());
    }

    @Test
    public void testRemoveLast_addFirst1elAndRemove1_size0(){
        ourArrayDeque.addFirst(3);

        assertEquals(3, ourArrayDeque.removeLast());

        assertEquals(0, ourArrayDeque.size());
    }

    @Test
    public void testRemoveLast_addLast1elAndRemove1_size0(){
        ourArrayDeque.addLast(3);

        assertEquals(3, ourArrayDeque.removeLast());

        assertEquals(0, ourArrayDeque.size());
    }

    @Test
    public void testRemoveFirst_addFirst1elAndRemove1_size0(){
        ourArrayDeque.addFirst(3);

        assertEquals(3, ourArrayDeque.removeFirst());

        assertEquals(0, ourArrayDeque.size());
    }

    @Test
    public void testRemoveFirst_addLast1elAndRemove1_size0(){
        ourArrayDeque.addLast(3);

        assertEquals(3, ourArrayDeque.removeFirst());

        assertEquals(0, ourArrayDeque.size());
    }

    @Test
    public void testAddRemoveMix_severalElementsAdded_removeSeveralElements(){
        ourArrayDeque.addLast(3);
        ourArrayDeque.addFirst(8);

        assertEquals(3, ourArrayDeque.removeLast());

        ourArrayDeque.addFirst(-5);
        ourArrayDeque.addFirst(-2);
        ourArrayDeque.addFirst(7);
        ourArrayDeque.addLast(10);
        assertEquals(7, ourArrayDeque.removeFirst());

        ourArrayDeque.addLast(13);
        assertEquals(5, ourArrayDeque.size());
    }

    @Test
    public void testRemoveFirst_removeFromEmptyDeque_throwException(){
        assertThrows(OurDequeEmptyException.class, () -> ourArrayDeque.removeFirst());
    }

    @Test
    public void testRemoveLast_removeFromEmptyDeque_throwException(){
        assertThrows(OurDequeEmptyException.class, () -> ourArrayDeque.removeLast());
    }

    @Test
    public void testAddFirst_zeroCapacityAndAddToFullDeque_throwOurDequeOverflowException(){
        ourArrayDeque = new OurArrayDeque<>(0);
        assertThrows(OurDequeOverflowException.class, () -> ourArrayDeque.addFirst(5));
    }

    @Test
    public void testAddLast_zeroCapacityAndAddToFullDeque_throwOurDequeOverflowException(){
        ourArrayDeque = new OurArrayDeque<>(0);
        assertThrows(OurDequeOverflowException.class, () -> ourArrayDeque.addLast(7));
    }

    @Test
    public void testAddFirst_2CapacityAndAddToFullDeque_throwOurDequeOverflowException(){
        ourArrayDeque = new OurArrayDeque<>(2);

        ourArrayDeque.addLast(3);
        ourArrayDeque.addLast(8);
        assertThrows(OurDequeOverflowException.class, () -> ourArrayDeque.addFirst(5));
    }

    @Test
    public void testAddLast_2CapacityAndAddToFullDeque_throwOurDequeOverflowException(){
        ourArrayDeque = new OurArrayDeque<>(2);

        ourArrayDeque.addLast(3);
        ourArrayDeque.addLast(8);
        assertThrows(OurDequeOverflowException.class, () -> ourArrayDeque.addLast(7));
    }

    @Test
    public void testIterator(){
        ourArrayDeque = new OurArrayDeque<>(2);

        ourArrayDeque.addFirst(8);
        ourArrayDeque.addLast(3);

        List<Integer> result = new ArrayList<>();
        List<Integer> expected = Arrays.asList(3,8);

        Iterator<Integer> it = new ReversedOurArrayDequeIterator<>(ourArrayDeque);
        while(it.hasNext()){
            int current = it.next();
            result.add(current);
        }

        assertEquals(expected, result);
    }

}