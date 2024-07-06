package com.mongodb.starter.dtos;

import com.mongodb.starter.models.Car;

public record CarDTO(String brand, String model, Float maxSpeedKmH) {

    public CarDTO(Car c){
        this(c.getBrand(), c.getModel(), c.getMaxSpeedKmH());
    }

    public Car toCarModel() {
        return new Car(brand, model, maxSpeedKmH);
    }
}
