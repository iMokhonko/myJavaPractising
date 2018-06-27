package com.company.Map;

import java.util.HashMap;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<> ();


        map.put (1, "ivan");
        map.put (2, "lexa");

        System.out.println (map.get (1));


    }

}
