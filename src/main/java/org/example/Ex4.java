package org.example;

import java.io.*;

public class Ex4 {

    public static void main(String[] args) {
        File source = new File("source/text.txt");
        File destination = new File("destination/text3.txt");
        try {
            copyAndPasteFile(source, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyAndPasteFile(File source, File destination) throws IOException {
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(destination));
        ) {
            byte[] buffer = new byte[1024];
            int b;
            while( (b=in.read(buffer))>0 ){
               // System.out.println( (char) b);
                out.write(buffer,0, b);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
