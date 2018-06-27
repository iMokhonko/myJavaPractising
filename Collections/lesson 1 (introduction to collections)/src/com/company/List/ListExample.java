package com.company.List;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<> ();
        List<String> listOfContains = new ArrayList<> ();
        listOfContains.add("one");
        listOfContains.add("two");

        list.add("one");
        list.add("two");
        list.add ("three");

       // list.remove ("two");
       // list.remove (1);

        System.out.println ("Contains of all: " + list.containsAll (listOfContains));

        for(int i = 0; i < list.size (); i++) {
            System.out.println (list.get (i));
        }


    }

}
