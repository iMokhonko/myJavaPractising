package com.imokhonko.SimpleGenerics;

public class GenericsMain {

    public static void main(String[] args) {

        Cell<String> cell = new Cell<>();
        Cell<ElectrinicThing> cell2 = new Cell<>();

        cell.setT ("cell things");
        cell2.setT(new ElectrinicThing ("Phone", 3));

        System.out.println (cell.getT ());
        System.out.println (cell2.getT ());

    }

}
