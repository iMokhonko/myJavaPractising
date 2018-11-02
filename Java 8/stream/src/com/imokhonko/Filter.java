package com.imokhonko;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filter {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");
        list.add("sixth");

        Stream<String> stringStream = list.stream();
        stringStream.filter(x -> x.contains("s")).forEach(x -> System.out.println(x));

    }

}
