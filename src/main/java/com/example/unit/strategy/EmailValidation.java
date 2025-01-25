package com.example.unit.strategy;

public class EmailValidation implements ValidationStrategy {

    @Override
    public boolean isValid(String input) {
        return input != null && input.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
