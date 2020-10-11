package de.telran.shapes.model;

public class Triangle implements Shape {

    private int side;
    private char symbol;

    public Triangle(int side, char symbol) {
        this.side = side;
        this.symbol = symbol;
    }

    public int getSide() {
        return side;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public void draw() {
        for (int i = 1; i < 10; i += 2) {
            for (int j = 0; j < i; j++) {
                System.out.print(this.symbol);
            }
            System.out.println();
        }
    }
}
