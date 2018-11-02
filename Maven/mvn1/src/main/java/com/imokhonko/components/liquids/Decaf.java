package com.imokhonko.components.liquids;

public class Decaf extends Beverage {

    public Decaf(final String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 1.35;
    }
}
