package com.imokhonko.Enums.FromOracleDocs;

public class Main {

    public static void main(String[] args) {


        for (Planet planet : Planet.values ()) {
            System.out.println (planet + ": " + planet.surfaceWeight (175));
        }

    }

}
