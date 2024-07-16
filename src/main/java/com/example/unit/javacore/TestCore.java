package com.example.unit.javacore;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestCore  implements CarInterface{

    @Override
    public String getSerialNumber() {
        return null;
    }

    @Override
    public List<Integer> getColorCodes() {
        return null;
    }

}
