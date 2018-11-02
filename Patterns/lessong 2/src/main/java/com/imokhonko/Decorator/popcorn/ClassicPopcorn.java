package com.imokhonko.Decorator.popcorn;

public class ClassicPopcorn extends Popcorn {

    private double cost = 1.5;

    public ClassicPopcorn(Size size) {
        super(size);
    }

    public Size getSize() {
        return super.getSize();
    }

    public double getCost() {
        return cost + (cost * getSize().getCoef());
    }

}
