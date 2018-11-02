package com.imokhonko.decorators.liquid;

import com.imokhonko.components.liquids.Beverage;

public class Soy extends CondimentDecorator {

    private final Beverage beverage;

    public Soy(final Beverage beverage, final String description) {
        super(description);
        this.beverage = beverage;
    }

    public Soy(final Beverage beverage) {
        super("Soy");
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + this.description;
    }

    @Override
    public double cost() {
        return .30 + beverage.cost();
    }
}
