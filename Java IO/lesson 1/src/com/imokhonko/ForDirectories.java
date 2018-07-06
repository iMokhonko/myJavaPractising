package com.imokhonko;

import java.io.File;

public class ForDirectories {

    public static void main(String[] args) {
        String path = "src/backup";
        File directory = new File ( path );

        if (!directory.exists ()) {
            directory.mkdir ();
        } else {
            if (directory.isDirectory ()) {
                String[] files = directory.list ();

                for (String file : files) {
                    File directoryFile = new File ( path + "/" + file );
                    System.out.println ( file + " (" + (directoryFile.isDirectory () ? "directory" : "file") + ")" );
                }
            }

        }

    }
}
