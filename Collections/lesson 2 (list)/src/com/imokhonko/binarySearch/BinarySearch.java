package com.imokhonko.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("C");
        list.add("B");


        Collections.sort(list);

        System.out.println (list.get(Collections.binarySearch (list, "B")));

    }

}
