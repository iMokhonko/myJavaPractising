package com.imokhonko.SimpleGenerics;

public class Cell <T> {

    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
