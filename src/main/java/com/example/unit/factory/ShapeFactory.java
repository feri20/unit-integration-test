package com.example.unit.factory;

public class ShapeFactory {

    public static Shape getShape(String shapeType){
        if (shapeType.equals("shapeA")){
            return new ConcreteShapeA();
        }else if (shapeType.equals("shapeB")){
            return new ConcreteShapeB();
        }else {
            throw new IllegalArgumentException(""+shapeType);
        }
    }
}
