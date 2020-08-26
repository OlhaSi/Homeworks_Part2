package com.telran;

import java.util.Comparator;

public class Point2DComparator implements Comparator<Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        int rSquared1 = computeRSquared(o1);
        int rSquared2 = computeRSquared(o2);
        return rSquared1 - rSquared2;
    }

    int computeRSquared(Point2D point) {
        return point.x * point.x + point.y * point.y;
    }
}
