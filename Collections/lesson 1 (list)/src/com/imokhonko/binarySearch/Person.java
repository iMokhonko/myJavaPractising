package com.imokhonko.binarySearch;

public class Person implements Comparable {

    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        return id - ((Person) o).getId();
    }
}
