package com.imokhonko.decorators.food;

import com.imokhonko.components.food.Corn;

import java.util.ArrayList;

public class Chocolate extends CondimentDecorator {

    private final Corn corn;

    public Chocolate(final Corn corn, String title) {
        super(title);
        this.corn = corn;
    }

    public Chocolate(final Corn corn) {
        this(corn, "Chocolate");
    }

    @Override
    public String getTitle() {
        return corn.getTitle() + ", " + this.title;
    }

    @Override
    public double cost() {
        return 3.05 + corn.cost();
    }
}
