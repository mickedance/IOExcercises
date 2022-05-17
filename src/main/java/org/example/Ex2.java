package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {

    public static void main(String[] args) {
        List<String> result = readFileReturnCollection();
        result.forEach(s -> System.out.println(s));
    }

    private static List<String> readFileReturnCollection() {

        List<String> result = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("source/names.txt")))){
        String line;
        while( (line = reader.readLine())!=null ){
            result.add(line);
        }
        }catch (IOException e){
            e.printStackTrace();;
        }

        return  result;
    }
}
