package com.imokhonko;

import java.util.function.Predicate;

public class FunctionalIntefaces {

    public static void main(String[] args) {

        Operation<Integer> integerOperation = (value1, value2) -> value1 + value2;
        Operation<String> stringOperation = (value1, value2) -> value1.concat(value2);

        System.out.println(integerOperation.getResult(25, 5));
        System.out.println(stringOperation.getResult("Hello", "world"));

    }

}
