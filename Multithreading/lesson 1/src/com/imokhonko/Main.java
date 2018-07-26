package com.imokhonko;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread threadCoordinator = new Thread (new ThreadCoordinator ());
        threadCoordinator.start ();
        threadCoordinator.join ();
    }
}
