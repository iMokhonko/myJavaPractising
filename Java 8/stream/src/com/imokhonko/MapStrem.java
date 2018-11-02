package com.imokhonko;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapStrem {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        list.add("fifth");
        list.add("sixth");

        Stream<String> stringStream = list.stream();

        stringStream.map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));

    }

}
