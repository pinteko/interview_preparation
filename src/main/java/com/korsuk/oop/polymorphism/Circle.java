package com.korsuk.oop.polymorphism;

public class Circle implements Shape{

    public final static String FORM = "Circle";
    public final static double PI = 3.14;
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return PI * radius * radius;
    }

    @Override
    public double findPerimeter() {
        return 2 * PI * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
