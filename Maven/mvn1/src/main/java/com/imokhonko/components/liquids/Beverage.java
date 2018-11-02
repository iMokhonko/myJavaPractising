package com.imokhonko.components.liquids;

public abstract class Beverage {

    // description for the beverage
    protected final String description;

    public Beverage(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Calculates the cost value for beverage.
     * @return cost value for beverage.
     */
    public abstract double cost();

}
