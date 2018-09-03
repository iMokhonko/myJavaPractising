package com.imokhonko;


public class Main {

    public static void main(String[] args) {

        Person person = new Person.Builder()
                .name("Ivan")
                .age(19)
                .build();

        System.out.println ("Name: " + person.getName ());
        System.out.println ("Age: " + person.getAge ());
    }
}
