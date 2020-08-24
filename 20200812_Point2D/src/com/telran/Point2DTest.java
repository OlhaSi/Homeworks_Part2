package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    Point2D point1;
    Point2D point2;

    @Test
    public void testPoint2_0and0_0(){
        point1 = new Point2D(0,0);
        point2 = new Point2D(0,0);

        assertEquals(0, point1.compareTo(point2));
    }

    @Test
    public void testPoint2_0and1_minus1(){
        point1 = new Point2D(0,0);
        point2 = new Point2D(1,1);

        assertEquals(-1, point1.compareTo(point2));
        assertEquals(1, point2.compareTo(point1));
    }

    @Test
    public void testPoint2_0andMinus1_minus1(){
        point1 = new Point2D(0,0);
        point2 = new Point2D(-1,-1);

        assertEquals(-1, point1.compareTo(point2));
        assertEquals(1, point2.compareTo(point1));
    }

    @Test
    public void testPoint2_equalNums_0(){
        point1 = new Point2D(2,3);
        point2 = new Point2D(2,3);

        assertEquals(0, point1.compareTo(point2));
    }

    @Test
    public void testPoint2_100and0_1(){
        point1 = new Point2D(100,100);
        point2 = new Point2D(0,0);

        assertEquals(1, point1.compareTo(point2));
        assertEquals(-1, point2.compareTo(point1));
    }

}