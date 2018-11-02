package com.imokhonko.Decorator.popcorn.popcornCondiments;

import com.imokhonko.Decorator.popcorn.Popcorn;
import com.imokhonko.Decorator.popcorn.Size;

public abstract class PopcornСondiment extends Popcorn {

    private final Popcorn condiment;
    private Size size = null;

    public PopcornСondiment(Popcorn condiment) {
        super(null);
        this.condiment = condiment;
    }

    public PopcornСondiment(Popcorn condiment, Size size) {
        this(condiment);
        this.size = size;
    }

    public Popcorn getCondiment() {
        return condiment;
    }

    @Override
    public Size getSize() {
        return size != null ? size : condiment.getSize();
    }
}
