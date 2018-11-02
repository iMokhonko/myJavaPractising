package com.imokhonko.components.food;

import java.util.ArrayList;

public abstract class Corn {
    protected final String title;

    public Corn(String title) {
        this.title = title;
    }

    public Corn() {
        this.title = "corn";
    }

    public String getTitle() {
        return title;
    }

    public abstract double cost();
}
