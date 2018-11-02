package com.imokhonko.decorators.liquid;

import com.imokhonko.components.liquids.Beverage;

public class Mocha extends CondimentDecorator {

    private final Beverage beverage;

    public Mocha(final Beverage beverage, final String description) {
        super(description);
        this.beverage = beverage;
    }

    public Mocha(final Beverage beverage) {
        super("Mocha");
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + this.description;
    }

    @Override
    public double cost() {
        return .35 + beverage.cost();
    }
}
