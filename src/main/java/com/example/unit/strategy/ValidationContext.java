package com.example.unit.strategy;

import java.util.ArrayList;
import java.util.List;

public class ValidationContext {

    private final List<ValidationStrategy> strategies = new ArrayList<>();

    public void addValidation(ValidationStrategy validation) {
        strategies.add(validation);
    }

    public boolean validateAll(String input){
        for (ValidationStrategy strategy : strategies) {
            if (!strategy.isValid(input)) {
                return false;
            }
        }
        return true;
    }
}
