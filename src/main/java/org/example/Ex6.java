package org.example;
/*
* Make a small program called car_register.
a. Create models Car and Owner.
b. Car should have fields: carId, regNumber, brand, model, regDate and owner. It
should also implement Serializable together with a default constructor.
c. Owner should have fields: ownerId, name, birthdate. Owner also need to implement
Serializable and have a default contructor.
d. Create two collections, one for Cars and the other for Owners.
e. Create functionality to serialize the collections to JSON files.
f. Create functionality to deserialize the JSON files to it’s resepective Collection.*/


import org.example.model.CarEx6;
import org.example.model.Owner;
import org.example.util.JsonIO;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ex6 {
    public static void main(String[] args) {
        List<Owner> owners = new ArrayList<>();
        owners.add(new Owner("Mi", LocalDate.parse("1970-04-04")));
        owners.add(new Owner("iM", LocalDate.parse("1940-03-04")));
        List<CarEx6> cars = new ArrayList<>();
        cars.add(new CarEx6("R333", "Audi", "fff", LocalDate.parse("2010-02-02"), owners.get(0)));
        cars.add(new CarEx6("r564", "Lada", "ffgf", LocalDate.parse("2020-02-02"), owners.get(1)));
        File file1 = new File("destination/owners2.json");
        File file2 = new File("destination/cars2.json");
        try {
            toJsonFile(owners, file1);
            toJsonFile(cars, file2);
            List<Owner> res = fromJsonFile(file1);
            System.out.println(res);
            List<CarEx6> re = fromJsonFile(file2);
            System.out.println(re);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> void toJsonFile(List<T> list, File file) throws IOException {
        JsonIO jsonMapper = new JsonIO();
        jsonMapper.toJson(file, list);
    }
    private static <T> List<T>  fromJsonFile( File file) throws IOException {
        JsonIO jsonMapper = new JsonIO();
        return jsonMapper.toList(file);
    }

}

