package com.imokhonko.Decorator.popcorn.popcornCondiments;

import com.imokhonko.Decorator.popcorn.Popcorn;
import com.imokhonko.Decorator.popcorn.Size;

public class Salt extends PopcornСondiment {

    private Size size;
    private final double cost = .5;

    public Salt(Popcorn condiment) {
        super(condiment);
    }

    public Salt(Popcorn condiment, Size size) {
        super(condiment, size);
    }

    @Override
    public Size getSize() {
        return super.getSize();
    }

    public double getCost() {
        double thisCost = cost + (cost * getSize().getCoef());
        return thisCost + super.getCondiment().getCost();
    }

}
