package com.imokhonko.Collections;


import java.util.HashMap;
import java.util.Map;

public class CollectionsTest {

    public static void main(String[] args) {

        System.out.println (comapringStrings ("abc", "bac"));

    }

    private static boolean comapringStrings(final String str1, final String str2) {
        // if one of the string is null then false
        if(str1 == null | str2 == null) {
            return false;
        }
        // if the length is not equal the false
        if(str1.length () != str2.length ()) {
            return false;
        }
        // maps for strings
        Map<Character, Integer> firstMap = new HashMap<>(str1.length ());
        Map<Character, Integer> secondMap = new HashMap<>(str2.length ());

        for (int i = 0; i < str1.length (); i++) {
            // chars from strings
            char currentCharFirst = str1.charAt (i);
            char currentCharSecond = str2.charAt (i);

            if(firstMap.containsKey (currentCharFirst)) {
                firstMap.replace (currentCharFirst, firstMap.get (currentCharFirst) + 1);
            } else { firstMap.put (currentCharFirst, 1); }

            if(secondMap.containsKey (currentCharSecond)) {
                secondMap.replace (currentCharSecond, secondMap.get (currentCharSecond) + 1);
            } else { secondMap.put (currentCharSecond, 1); }
        }

        return firstMap.equals (secondMap);
    }

}
