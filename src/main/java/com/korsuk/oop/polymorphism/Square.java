package com.korsuk.oop.polymorphism;

public class Square implements Shape{

    public final static String FORM = "Square";
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double findArea() {
        return side * side;
    }

    @Override
    public double findPerimeter() {
        return side * 4;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
