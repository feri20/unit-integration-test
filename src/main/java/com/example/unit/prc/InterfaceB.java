package com.example.unit.prc;
public interface InterfaceB {

    default String hi() {
        return "default!";
    }

    static String hello() {
        return "static!";
    }

    public String hey();

    private String salam(){
        return "salam";
    }

}