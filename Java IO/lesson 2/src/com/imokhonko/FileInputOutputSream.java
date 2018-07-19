package com.imokhonko;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputSream {

    public static void main(String[] args) {

        final String pathFrom = "D:\\Java\\Java IO\\lesson 2\\text.txt";
        final String pathTo = "D:\\Java\\Java IO\\lesson 2\\createdByJava.txt";

        FileInputStream in = null;
        FileOutputStream out = null;

        try {

            in = new FileInputStream (pathFrom);
            out = new FileOutputStream(pathTo);

            // there will be bytes from file
            int c;

            while ((c = in.read()) != -1) {
                out.write(c);
                System.out.println (c);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
            if(out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        }

    }

}
