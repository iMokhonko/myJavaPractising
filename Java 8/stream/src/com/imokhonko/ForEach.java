package com.imokhonko;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ForEach {

    public static void main(String[] args) {
	    List<String> list = new ArrayList<>();
	    list.add("first");
	    list.add("second");
	    list.add("third");

	    // getting stream from list
        Stream<String> stringStream = list.stream();
        // iterate through the list using forEach and lambda
        stringStream.forEach(s -> System.out.println(s));


    }
}
