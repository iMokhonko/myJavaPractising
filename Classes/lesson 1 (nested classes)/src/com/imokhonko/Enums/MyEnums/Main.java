package com.imokhonko.Enums.MyEnums;

public class Main {

    public static void main(String[] args) {

        System.out.println (Tables.LARGE);

        for (Tables table : Tables.values ()) {
            System.out.println (table + ": " + table.customLegsWeight (5) + " kg");
        }

    }

}
