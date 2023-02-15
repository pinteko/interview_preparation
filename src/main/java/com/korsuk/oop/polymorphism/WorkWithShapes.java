package com.korsuk.oop.polymorphism;

public class WorkWithShapes {
    public static void main(String[] args) {

        Shape[] shapes = {new Circle(5.0), new Square(41.12), new Triangle(5, 4, 6, 7)};
        for (Shape shape: shapes
             ) {
            System.out.println(shape.getClass().getSimpleName() + ": area = " + shape.findArea()
                                + ", perimeter = " + shape.findPerimeter());
        }
    }
}
