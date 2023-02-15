package com.korsuk.oop.polymorphism;

public class Triangle implements Shape{

    public final static String FORM = "Triangle";
    private double height;
    private double base;
    private double a;
    private double c;

    public Triangle(double height, double base, double a, double c) {
        this.height = height;
        this.base = base;
        this.a = a;
        this.c = c;
    }

    @Override
    public double findArea() {
        return height * base / 2;
    }

    @Override
    public double findPerimeter() {
        return a + base + c;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
}
