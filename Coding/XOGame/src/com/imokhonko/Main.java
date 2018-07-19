package com.imokhonko;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        final String str = "aaabbcaabc";

        Main main = new Main ();

        main.getLettersCount (str);

    }

    private void getLettersCount(final String str) {

        char[] letters = new char[str.length ()];


        int lettersCount = 0;

        for (int i = 0; i < str.length (); i++) {
            boolean ifFound = false;
            for (int j = 0; j < letters.length; j++) {
                try {
                    if(str.charAt(i) == letters[j]) {
                        ifFound = true;
                        break;
                    }
                } catch (NullPointerException e) {
                    break;
                }
            }
            if(!ifFound)  {
                letters[lettersCount] = str.charAt (i);
                lettersCount++;
            }
        }

        char[] uniqueLetters = new char[lettersCount];
        for(int i = 0; i < lettersCount; i++) {
            uniqueLetters[i] = letters[i];
        }

        for (int i = 0; i < uniqueLetters.length; i++) {
            int letterCount = 0;
            for (int j = 0; j < str.length (); j++) {
                if(uniqueLetters[i] == str.charAt (j)) {
                    letterCount++;
                }
            }
            System.out.println (uniqueLetters[i] + " - " + letterCount);
        }

        
    }

}
