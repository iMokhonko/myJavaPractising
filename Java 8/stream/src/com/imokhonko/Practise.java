package com.imokhonko;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practise {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Ivan", "Lexa", "Viola", "Sanya", "Artem", "Daniil", "Ivan", "Max"));

        String found = names.stream()
                .filter(name -> name.equals("Edik"))
                .findAny()
                .get();

        System.out.println(found);
    }


}
