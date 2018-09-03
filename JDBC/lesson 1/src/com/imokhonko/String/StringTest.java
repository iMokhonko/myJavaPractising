package com.imokhonko.String;

import java.math.BigInteger;
import java.util.Arrays;

public class StringTest {

    public static void main(String[] args) {

        String text = "java";
        String text2 = new String("java").intern ();

        long start = System.currentTimeMillis ();
        for (int i = 0; i < 100_000_000; i++) {
            //if(text == text2) {}
            if(text.equals (text2)){}
        }
        long finish = System.currentTimeMillis ();

        System.out.println ("Time: " + (finish - start) + " ms");

    }

}
