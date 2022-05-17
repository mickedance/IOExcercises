package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class CarEx6 implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String carId, regNumber, brand, model;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate regDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Owner owner;

    public CarEx6() {
        this.carId = UUID.randomUUID().toString();
    }

    public CarEx6(String regNumber, String brand, String model, LocalDate regDate, Owner owner) {
        this();
        this.regNumber = regNumber;
        this.brand = brand;
        this.model = model;
        this.regDate = regDate;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "CarEx6{" +
                "carId='" + carId + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", regDate=" + regDate +
                ", owner=" + owner +
                '}';
    }
}
