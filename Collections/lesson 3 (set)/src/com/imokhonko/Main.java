package com.imokhonko;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<String> stringSet = new HashSet<> ();

        stringSet.add("One");
        stringSet.add("Two");
        stringSet.add("Three");
        stringSet.add("Four");

        // size
        System.out.println ("stringsSet size: " + stringSet.size ());

        // is empty
        System.out.println ("is empty stringsSet: " + stringSet.isEmpty ());

        // contains
        System.out.println ("Is collections contain 'Two': " + stringSet.contains ("Two"));

        // to Array
        System.out.printf ("Array: [");
        String[] stringsArray = stringSet.toArray (new String[stringSet.size ()]);
        for (String s : stringsArray) {
            System.out.printf (" "+s+" ");
        }
        System.out.println("]");

        // contains All of collection
        Collection<String> collection = new ArrayList<> ();
        collection.add("Two");
        collection.add("Three");

        System.out.println ("is stringsSet contains collection: " + stringSet.containsAll(collection));


        // add All
        Collection<String> collectionToAdd = new ArrayList<> ();
        collectionToAdd.add("Five");
        collectionToAdd.add("Six");
        stringSet.addAll(collectionToAdd);
        System.out.printf ("after addAll method: [");
        for (String s : stringSet) {
            System.out.printf (" "+s+" ");
        }
        System.out.println("]");

        // remove All
        stringSet.removeAll(collectionToAdd);
        System.out.printf ("after removeAll method: [");
        for (String s : stringSet) {
            System.out.printf (" "+s+" ");
        }
        System.out.println("]");

        // clear
        collectionToAdd.clear();
        System.out.printf ("after clear method to collectionToAdd: [");
        for (String s : collectionToAdd) {
            System.out.printf (" "+s+" ");
        }
        System.out.println("]");

        // equals
        collectionToAdd.add("One");
        collectionToAdd.add("Two");
        collectionToAdd.add("Three");
        collectionToAdd.add("Four");

        System.out.println ("stringsSet equals to collectionToAdd: " + stringSet.equals(collectionToAdd));

    }
}
