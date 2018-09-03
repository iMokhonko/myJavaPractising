package com.imokhonko;

public class Producer implements Runnable {

    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            store.put ();
        } catch (InterruptedException e) {
            System.out.println (this.getClass ().getName () + " interrupted");
        }
    }
}
