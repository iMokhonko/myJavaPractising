package com.imokhonko;

import java.io.*;

public class BufferedReaderStream {

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader ("D:\\Java\\Java IO\\lesson 2\\text.txt"));
            outputStream = new PrintWriter(new FileWriter ("characteroutput_by_bufferedReader.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
                System.out.println (l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }

    }

}
