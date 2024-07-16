package com.example.unit.javacore;

import java.util.List;

public interface CarInterface {
    public String getSerialNumber();
    public List<Integer> getColorCodes();
    default String notifyMe(){
        return "notifyMe";
    }


}
