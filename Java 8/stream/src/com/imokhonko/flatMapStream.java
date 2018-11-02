package com.imokhonko;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class flatMapStream {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {1,2,3,4});
        list.add(new int[] {15,44,43,23});

        Stream<int[]> stringStream = list.stream();

//        stringStream.flatMap(x -> x.clone()).forEach(x -> System.out.println(Arrays.toString((int[]) x)));
    }

}
