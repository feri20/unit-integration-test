package com.example.unit.strategy;

public class UserValidation implements ValidationStrategy {

    @Override
    public boolean isValid(String user) {
        return user.equals("admin");
    }
}
