package com.imokhonko.Enums.MyEnumsSecond;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        List<Colors> colorsSet = new ArrayList<> ();
        List<Colors> colorsSet2 = new ArrayList<> ();

        for (Colors color : Colors.values ()) {
            colorsSet.add (color);
            colorsSet2.add (color);
        }


        System.out.println (colorsSet.get (1).hashCode ());
        System.out.println (colorsSet2.get (1).hashCode ());
    }

}
