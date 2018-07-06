package com.imokhonko;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        String path = "D:\\Java\\Java IO\\lesson 1\\sampleFile.txt";

        File file = new File (path);
        File newName = new File ("sample.txt");

        System.out.println ("Filename: " + file.getName ());
        System.out.println ("File length: " + file.length () + " bytes");
        System.out.println ("Path: " + file.getPath ());
        System.out.println ("Absolute path: " + file.getAbsolutePath ());
        System.out.println ("Parent folder: " + file.getParent ());

        System.out.println ("Is file exist: " + (file.exists () ? "file exist" : "file not exist"));
        System.out.println ("Is file readable: " + (file.canRead () ? "file readable" : "file not readable"));
        System.out.println ("Is file writeable: " + (file.canWrite () ? "file writeable" : "file not writable"));

        System.out.println ("Renaming file to sample.txt" + file.renameTo(newName));

    }
}
