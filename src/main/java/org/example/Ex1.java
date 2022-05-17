package org.example;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Ex1 {

    public static void main(String[] args) {
        String s = readFileAndReturnString();
        System.out.println(s);
    }

    public static String readFileAndReturnString() {
        StringBuilder result = new StringBuilder();
        try(FileReader reader = new FileReader(new File("source/text.txt") )    )
        {
            int i;
            while( (i = reader.read())!=-1 ){
                result.append((char) i );
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return result.toString();
    }

}
