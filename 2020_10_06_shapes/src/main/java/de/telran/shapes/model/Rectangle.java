package de.telran.shapes.model;

public class Rectangle implements Shape {

    private final int width;
    private final int height;
    private final char symbol;

    public Rectangle(int width, int height, char symbol) {
        this.width = width;
        this.height = height;
        this.symbol = symbol;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getSymbol() {
        return symbol;
    }

    @Override
    public void draw() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(this.symbol);
            }
            System.out.println();
        }
    }
}
