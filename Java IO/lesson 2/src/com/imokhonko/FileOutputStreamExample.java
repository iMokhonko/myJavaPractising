package com.imokhonko;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {

    public static void main(String[] args) {


//        File myFile = new File("myFileUsingFileClass.txt");

        String myText = "this is my text;";
        byte[] myTextByteArray = myText.getBytes ();

        try(FileOutputStream writingStream = new FileOutputStream ("myFile.txt")) {

            for (byte b : myTextByteArray) {
                writingStream.write (b);
            }

        } catch (IOException e) {
            System.out.println ("error");
        }

    }

}
