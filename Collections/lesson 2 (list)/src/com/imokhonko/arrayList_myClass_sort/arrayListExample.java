package com.imokhonko.arrayList_myClass_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class arrayListExample {

    public static void main(String[] args) {

        List<Person> list = new ArrayList<>();

        list.add(new Person(3,"Ivan"));
        list.add(new Person(4,"Lexa"));
        list.add(new Person(1, "Sanya"));
        list.add(new Person(2, "Viola"));
        list.add(new Person(5, "Yarik"));

        for (Person s : list) {
            System.out.println (s);
        }

        Collections.sort(list);
        System.out.println ("----------------------------------------");

        for (Person s : list) {
            System.out.println (s);
        }

    }

}
