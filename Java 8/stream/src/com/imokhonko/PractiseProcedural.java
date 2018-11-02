package com.imokhonko;

import java.util.*;

public class PractiseProcedural {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Ivan", "Lexa", "Viola", "Sanya", "Artem", "Daniil", "Ivan", "Max"));

        Map<String, Integer> map = new HashMap<>(); // map for the result

        // iterate through the items in set
        for(String uniqueName : names) {
            // check if name contain the 'a' letter
            if(uniqueName.length() > 3 && uniqueName.toLowerCase().contains("a")) {
                String name = uniqueName.toUpperCase(); // uppecasing the name
                // check if map already has the current item
                if(!map.containsKey(name))
                    map.put(name, name.length()); // add value to the map
            }
        }

        for(Map.Entry<String,Integer> mapItem : map.entrySet()) {
            System.out.println(mapItem.getKey() + " - " + mapItem.getValue());
        }

    }

}
