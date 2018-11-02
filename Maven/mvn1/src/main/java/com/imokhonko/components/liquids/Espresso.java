package com.imokhonko.components.liquids;

public class Espresso extends Beverage {

    public Espresso(final String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
