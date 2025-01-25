package com.example.unit.strategy;

public class PasswordValidation implements ValidationStrategy {

    @Override
    public boolean isValid(String input) {
        return false;
    }
}
