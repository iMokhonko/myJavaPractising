package com.imokhonko.GenericInheritance;

public class Parent {

    String name;

    public Parent(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
