package com.imokhonko.Decorator.popcorn;

public class ExtraordinaryPopcorn extends Popcorn {

    private double cost = 2;

    public ExtraordinaryPopcorn(Size size) {
        super(size);
    }

    public Size getSize() {
        return super.getSize();
    }

    public double getCost() {
        return cost + (cost * getSize().getCoef());
    }
}
