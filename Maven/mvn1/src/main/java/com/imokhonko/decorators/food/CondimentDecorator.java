package com.imokhonko.decorators.food;

import com.imokhonko.components.food.Corn;

import java.util.ArrayList;

public abstract class CondimentDecorator extends Corn {

    public CondimentDecorator(String title) {
        super(title);
    }

    public CondimentDecorator() {
        this("");
    }

    @Override
    public abstract String getTitle();

    @Override
    public abstract double cost();

}
