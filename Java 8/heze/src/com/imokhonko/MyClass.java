package com.imokhonko;

import com.imokhonko.annotations.MyAnnotation;

public class MyClass {

    @MyAnnotation
    public int x = 5;
    private int y = 6;

    @MyAnnotation
    public int getX() {
        return x;
    }

    private void privateMethod() {

    }

}
