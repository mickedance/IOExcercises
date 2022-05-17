package org.example;
/*
* In Java create a class called Car with properties like regnumber, brand and model etc... The
Car class must implement Serializable. To also fulfil the contract make a default constructor.
a. Create a List of Cars and add some objects into it.
b. Save the List of Cars to a file using ObjectOutputStream.
c. Read the List of Cars from file using ObjectInputStream.*/


import org.example.model.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex5 {
    public static void main(String[] args) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Volvo", "123", "red"));
        carList.add(new Car("Lada", "123RR", "blue"));
        carList.add(new Car("Saab", "1SAB3", "green"));
        File file = new File("source/obj6.ser");
        saveObjectToFile(file, carList.get(0));
        saveObjectToFile(file, carList.get(1));
        saveObjectToFile(file, carList.get(2));
        //List<Car> carFromFile = loadObjectFromFile(file);
       // System.out.println(carFromFile + "\n######");
    }

    private static <T> List<T> loadObjectFromFile(File file) {
        List<T> listToReturn = new ArrayList<>();
        try (
                //InputStream inStream = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))
        ) {
            ;
            return (List<T>) in.readObject();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listToReturn;
    }


    public static <T> void saveObjectToFile(File file, T t) {
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (
                OutputStream outStream = new FileOutputStream(file, true);
                ObjectOutputStream out = new ObjectOutputStream(outStream);
        ) {

            out.writeObject(t);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
