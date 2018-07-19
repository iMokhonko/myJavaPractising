package com.imokhonko;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamExample {

    public static void main(String[] args) {

        try (FileInputStream readingText = new FileInputStream (new File ("file.txt"))) {

            int symbol;

            while((symbol = readingText.read ()) != -1) {
                System.out.println ((char) symbol);
            }

        } catch (IOException e) {
            System.out.println ("error reading file");
        }

    }

}
