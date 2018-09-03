package com.imokhonko.Arrays;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArraysTest {

    public static void main(String[] args){

        int[] array = new int[10];
        int[] coppied = new int[5];

        Random random = new Random (5);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt (10);
        }
        System.out.println ("Array: " + Arrays.toString (array));
        System.arraycopy (array, 4, coppied, 0, 5);
        System.out.println ("Coppied: " + Arrays.toString (coppied));




    }

}
