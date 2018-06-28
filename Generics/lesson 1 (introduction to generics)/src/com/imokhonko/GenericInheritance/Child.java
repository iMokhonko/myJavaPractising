package com.imokhonko.GenericInheritance;

public class Child extends Parent {


    public Child(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
