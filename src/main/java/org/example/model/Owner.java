package org.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Owner implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String ownerId, name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;

    public Owner() {
        this.ownerId = UUID.randomUUID().toString();
    }

    public Owner(String name, LocalDate birthdate) {
        this();
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId='" + ownerId + '\'' +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
