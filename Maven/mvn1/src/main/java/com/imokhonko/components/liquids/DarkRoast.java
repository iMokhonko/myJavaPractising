package com.imokhonko.components.liquids;

public class DarkRoast extends Beverage {

    public DarkRoast(final String description) {
        super(description);
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 1.85;
    }
}
