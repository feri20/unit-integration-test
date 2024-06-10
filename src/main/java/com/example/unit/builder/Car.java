package com.example.unit.builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private Long  tripComputer;
    private CarType carType;
    private String  gpsNavigator;
    private double fuel = 0;

    public Car(Long tripComputer, CarType carType, String gpsNavigator) {
        this.tripComputer = tripComputer;
        this.carType = carType;
        this.gpsNavigator = gpsNavigator;
    }
}
