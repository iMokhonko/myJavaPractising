package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream ( "C:\\Users\\Ivan\\Desktop\\Java IO\\src\\com\\company\\xanadu.txt" );
            out = new FileOutputStream ( "C:\\Users\\Ivan\\Desktop\\Java IO\\src\\com\\company\\outagain.txt" );
            int c;

            while ((c = in.read ()) != -1) {
                System.out.println ( c );
                if (c < 100) {
                    throw new Exception ( "ТУПА АШЫЫБКА" );
                }
                out.write ( c );
            }

        } catch (Exception e) {
            System.out.println ( e.getMessage () );
        } finally {
            if (in != null) {
                in.close ();
            }
            if (out != null) {
                out.close ();
            }
        }

    }
}
