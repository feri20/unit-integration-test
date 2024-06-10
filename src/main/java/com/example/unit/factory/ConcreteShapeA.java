package com.example.unit.factory;

import com.example.unit.factory.Shape;

public class ConcreteShapeA implements Shape {
    @Override
    public void doSth() {
        System.out.println("Product A is doing something.");
    }
}
