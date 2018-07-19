package com.imokhonko;

public class Main {

    public static void main(String[] args) {

        Human human = new Human("Ivan") {

            @Override
            public void getName() {
                System.out.println ("*********");
                super.getName ();
            }
        };

        System.out.println (human instanceof Human);

    }
}
