package org.example.model;

import java.io.Serializable;

public class Car implements Serializable {
    private String brand;
    private String regNr;
    private String color;

    public Car(String brand, String regNr, String color) {
        this.brand = brand;
        this.regNr = regNr;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", regNr='" + regNr + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
