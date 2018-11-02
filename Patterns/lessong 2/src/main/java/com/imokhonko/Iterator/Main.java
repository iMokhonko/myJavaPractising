package com.imokhonko.Iterator;


public class Main {

    public static void main(String[] args) {
        MyList<String> myList = new MyList<String>(10);

        for(int i = 0; i < 15; i++) {
            myList.add(i + "");
        }

        myList.setOrdering(MyList.IterationOrder.REVERSE);

        for(String s : myList) {
            System.out.println(s);
        }

    }

}
