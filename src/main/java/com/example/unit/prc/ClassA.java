package com.example.unit.prc;

public class ClassA implements InterfaceB{
    @Override
    public String hi() {
        return InterfaceB.super.hi();
    }

    @Override
    public String hey() {
        return null;
    }
}
