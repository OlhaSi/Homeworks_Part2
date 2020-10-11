package de.telran.shapes.model;

public class Square implements Shape {

    private int side;
    private char symbol;

    public Square(int side, char symbol) {
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
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print(this.symbol);
            }
            System.out.println();
        }
    }
}
