package com.imokhonko.decorators.liquid;

import com.imokhonko.components.liquids.Beverage;

public abstract class CondimentDecorator extends Beverage {

    public CondimentDecorator(final String description) {
        super(description);
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract double cost();
}
