package com.imokhonko;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        File file = new File ("hello.txt");

        try(InputStream input = new Sniffer (
                new BufferedInputStream(
                        new FileInputStream (file)))) {
            readFile (input);
        } catch (IOException e) {
            System.out.println ("error reading file" + file);
        }
    }


    private static void readFile(InputStream in) throws IOException {

        byte[] buffer = new byte[2];
        int count;

        while((count = in.read (buffer)) != -1) {
//            System.out.print("count of bytes: " + count);
            System.out.println("bytes array: " + Arrays.toString (buffer));
//            System.out.print(" | str: " + new String(buffer, 0, count, "UTF8"));
//            System.out.println ("");
        }

    }

}

class Sniffer extends InputStream {

    private final  InputStream stream;

    public Sniffer(InputStream stream) {
        this.stream = stream;
    }

    @Override
    public int read() throws IOException {
        int read = this.stream.read ();
        System.out.println ("reading: " + read);
        return read;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int read = this.stream.read (b);
        System.out.println ("reading: " + read);
        return read;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = this.stream.read ( b, off, len );
        System.out.println ("reading: " + read);
        return read;
    }
}
