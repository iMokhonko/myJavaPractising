package com.company.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedList<> ();

        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");

        queue.peek ();

        System.out.println (queue.element ());


    }

}
