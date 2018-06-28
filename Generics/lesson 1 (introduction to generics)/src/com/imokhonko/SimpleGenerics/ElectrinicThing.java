package com.imokhonko.SimpleGenerics;

public class ElectrinicThing {

    String name;
    int weight;

    public ElectrinicThing(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return this.name + "(" + this.weight + " кг)";
    }
}
