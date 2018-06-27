package com.company.ArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Iterator_byFor {

    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<> ();
        collection.add("one");
        collection.add("two");
        collection.add("three");

        // создаем обьект итератора
        Iterator<String> iterator = collection.iterator ();

        // пробегаемся по циклу
        for(String value : collection) {
            System.out.println (value);
        }

    }


}
