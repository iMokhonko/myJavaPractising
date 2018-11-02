package com.imokhonko.decorators.liquid;

import com.imokhonko.components.liquids.Beverage;

public class Milk extends CondimentDecorator {

    private final Beverage beverage;

    public Milk(final Beverage beverage, final String description) {
        super(description);
        this.beverage = beverage;
    }

    public Milk(final Beverage beverage) {
        super("Milk");
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + this.description;
    }

    @Override
    public double cost() {
        return 0.25 + beverage.cost();
    }
}
