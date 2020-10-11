package de.telran.shapes.model;

public class Line implements Shape {

    private final int length;
    private final char symbol;

    public Line(int length, char symbol) {
        this.length = length;
        this.symbol = symbol;
    }

    @Override
    public void draw() {
        for (int i = 0; i < length; i++) {
            System.out.print(this.symbol);
        }
        System.out.println();
    }

    public char getSymbol() {
        return symbol;
    }
}
