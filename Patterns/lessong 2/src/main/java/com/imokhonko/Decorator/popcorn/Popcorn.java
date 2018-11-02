package com.imokhonko.Decorator.popcorn;

public abstract class Popcorn {

    private final Size size;

    public Popcorn(Size size) {
        this.size = size;
    }

    public Size getSize() {
        return size;
    }

    public abstract double getCost();

}
