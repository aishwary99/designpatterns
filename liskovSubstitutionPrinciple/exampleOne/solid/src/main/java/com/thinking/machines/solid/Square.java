package com.thinking.machines.solid;

public class Square implements Shape {
    private int height;

    public Square(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int calculateShape() {
        return this.height * this.height;
    }
}
