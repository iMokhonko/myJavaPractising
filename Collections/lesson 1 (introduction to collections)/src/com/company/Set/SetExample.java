package com.company.Set;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        Set<String> set = new HashSet<> ();

        set.add("one");
        set.add("one");
        set.add("one");

        System.out.println (set.size ());

    }

}
