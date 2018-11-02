package com.imokhonko.Decorator.popcorn;

public enum Size {
    EXTRA_SMALL(0),
    SMALL(1),
    MIDDLE(2),
    LARGE(3),
    EXTRA_LARGE(4);

    private double coef = 0;

    private Size(double coef) {
        this.coef = coef;
    }

    public double getCoef() {
        return coef;
    }
}
