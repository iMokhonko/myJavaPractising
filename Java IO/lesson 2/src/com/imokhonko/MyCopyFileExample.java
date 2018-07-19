package com.imokhonko;

import java.io.*;

public class MyCopyFileExample {

    public static void main(String[] args) {

        MyCopyFileExample main = new MyCopyFileExample();

        try {
            main.copyFile("myFile.txt", "usingFileReaderWriter.txt");
        } catch (IOException e) {
            System.out.println ("error");
            e.printStackTrace ();
        }

    }

    public boolean copyFile(final String path, final String newPath) throws IOException {

        File currentFile = new File (path);
        File newFile = new File (newPath);

        FileReader reading = new FileReader (currentFile);
        FileWriter writing = new FileWriter (newFile);

        int symbol;

        while((symbol = reading.read ()) != -1) {
            writing.write ((char) symbol);
        }

        if(reading != null)
            reading.close ();
        if(writing != null)
            writing.close ();

        return true;
    }

    public boolean copyFileToDirectory(final String filePath, final String directoryPath) throws  IOException {

        File file = new File (filePath);
        File directory = new File (directoryPath);

        if(!directory.exists ())
            directory.mkdir ();

        FileInputStream inputStream = new FileInputStream (file);
        FileOutputStream outputStream = new FileOutputStream (directory + "/" + file);

        int symbol;

        while((symbol = inputStream.read ()) != -1) {
            outputStream.write (symbol);
        }

        if(inputStream != null)
            inputStream.close ();
        if(outputStream != null)
            outputStream.close ();

        return true;
    }

}
