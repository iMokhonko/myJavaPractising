package com.company.ArrayList;

import java.util.*;

public class ArrayList_example {

    public static void main(String[] args) {

        Collection<Integer> collection = new ArrayList<> ();

        collection.add(1);
        collection.add(2);
        collection.add(3);

        System.out.println ("Size: " + collection.size());
        collection.remove (2);
        System.out.println ("Size: " + collection.size());

        for(int i: collection) {
            System.out.println (i);
        }

    }

}
