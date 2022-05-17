package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Olle");
        names.add("Anna");
        names.add("Leo");
        names.add("Sofia");

        names.forEach(s ->  {
            try{
                writeNameToFile(s);
            }catch (IOException e){
                e.printStackTrace();
            }
    });
        try {
            writeNameToFile("--------");

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void writeNameToFile(String name) throws IOException{
        File file = new File("destination/names.txt");
        if(!file.exists()) file.createNewFile();

        try(
                BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))
        ){
            writer.append(name);
            writer.newLine();
            writer.flush();
        }
    }
}
