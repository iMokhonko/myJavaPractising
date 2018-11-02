package com.imokhonko;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ReduceStream {

    public static void main(String[] args) {

//        int intsSum = Stream.of(1,2,3,4).reduce(0, (sum, currentElem) -> sum + currentElem);
//        System.out.println(intsSum);

        List<Integer> ints = new ArrayList<>();
        ints.add(6);
        ints.add(0);
        ints.add(6);
        ints.add(22);
        ints.add(2312);
        ints.add(0);
        ints.add(15);

        Stream<Integer> integerStream = ints.stream();
        integerStream.mapToInt(x -> x+1).forEach(x -> System.out.println(x));

    }

}
