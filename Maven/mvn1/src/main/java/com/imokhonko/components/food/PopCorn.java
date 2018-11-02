package com.imokhonko.components.food;

import java.util.ArrayList;

public class PopCorn extends Corn {

    public PopCorn(String title) {
        super(title);
    }

    public PopCorn() {
        this("popcorn");
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    @Override
    public double cost() {
        return 5.99;
    }
}
