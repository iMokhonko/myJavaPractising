package com.imokhonko.decorators.food;

import com.imokhonko.components.food.Corn;

import java.util.ArrayList;

public class Cheese extends CondimentDecorator {

    private final Corn corn;

    public Cheese(final Corn corn, String title) {
        super(title);
        this.corn = corn;
    }

    public Cheese(final Corn corn) {
        this(corn, "Cheese");
    }

    @Override
    public String getTitle() {
        return corn.getTitle() + ", " + this.title;
    }

    @Override
    public double cost() {
        return 2.55 + corn.cost();
    }
}
