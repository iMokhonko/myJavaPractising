package com.imokhonko.decorators.liquid;

import com.imokhonko.components.liquids.Beverage;

public class Whip extends CondimentDecorator {

    private final Beverage beverage;

    public Whip(final Beverage beverage, final String description) {
        super(description);
        this.beverage = beverage;
    }

    public Whip(final Beverage beverage) {
        super("Whip");
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", " + this.description;
    }

    @Override
    public double cost() {
        return .40 + beverage.cost();
    }
}
