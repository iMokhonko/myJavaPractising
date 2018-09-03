package com.imokhonko;


import java.util.ArrayList;
import java.util.List;

public class Store {

    private final static int BUFFER_MAX_SIZE = 5;
    private List<Product> products = new ArrayList<>(BUFFER_MAX_SIZE);

    public synchronized void put() throws InterruptedException {
        while (!Thread.currentThread ().isInterrupted ()) {
            if(products.size () >= BUFFER_MAX_SIZE) {
                System.out.println ("producers waiting for removing products by consumers");
                this.wait ();
            }
            products.add(new Product ());
//            System.out.println ("one product added to store");
            System.out.println ("products: " + products.size ());
            Thread.sleep (200);
            this.notify();
        }
    }

    public synchronized void get() throws InterruptedException {
        while (!Thread.currentThread ().isInterrupted ()) {
            if(products.size () == 0) {
                System.out.println ("consumers waiting for adding products by producers");
                this.wait ();
            }
            products.remove (0);
            System.out.println ("one product removed from store");
            System.out.println ("products: " + products.size ());
            Thread.sleep (200);
            this.notify();
        }
    }

}
