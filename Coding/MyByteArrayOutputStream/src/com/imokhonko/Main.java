package com.imokhonko;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        ModifiedByteArrayOutputStream stream = new ModifiedByteArrayOutputStream (32, new AllocateStrategy () {
            @Override
            public int nextValue(int now) {
                return now + (now << 1);
            }
        });

        byte[] bytes = new byte[]{1,2,3,4,5,6,7};

        stream.write (bytes);
        stream.write (bytes);
        stream.write (bytes);
        stream.write (bytes);
        stream.write (bytes);
        stream.write (bytes);


        stream.getBufferListLength ();

        System.out.println ( Arrays.toString (stream.toByteArray ()));
    }
}
