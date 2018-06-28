package com.imokhonko.toArrayToList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class toArrayToList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<> ();

        list.add("A");
        list.add("C");
        list.add("B");

        // создаем массив по длинне листа
        String[] strings = new String[list.size()];

        // добавляем в переменную strings эллементы листа
        list.toArray (strings);

        list.clear();
        System.out.println ("Cleared list: " + list.size());

        // Пробегаемся по массиву
        System.out.println ("strings array:");
        for(int i = 0; i < strings.length; i++) {
            System.out.println (strings[i]);
        }

        list = Arrays.asList (strings);

        System.out.println ("list elements: " + list.size());
        for(String s: list) {
            System.out.println (s);
        }

//
//        List<String> stringList;
//        stringList = Arrays.asList (strings);
//        System.out.println (list.equals (stringList));

    }

}
