package com.telran;

public class Point2D implements Comparable<Point2D>{

    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public int compareTo(Point2D point2) {

        double r1 = Math.sqrt(this.x * this.x + this.y * this.y);
        double r2 = Math.sqrt(point2.getX() * point2.getX() + point2.getY() * point2.getY());

        if(r1 == r2)
            return 0;
        else
            return r1 > r2 ? 1 : -1;
    }
}
