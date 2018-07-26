package com.imokhonko;

public class ThreadCoordinator implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {

            Thread printA = new Thread ( new Runnable () {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        try {
                            Thread.sleep (100);
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                        System.out.println ("A .");
                    }
                }
            });

            Thread printB = new Thread ( new Runnable () {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        try {
                            Thread.sleep (90);
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                        System.out.println (". B");
                    }
                }
            });

            printA.start ();
            printB.start ();

            try {
                printA.join ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            try {
                printB.join ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            System.out.println ("---");

            Thread printC = new Thread ( new Runnable () {
                @Override
                public void run() {
                    for (int j = 0; j < 5; j++) {
                        try {
                            Thread.sleep (100);
                        } catch (InterruptedException e) {
                            e.printStackTrace ();
                        }
                        System.out.println (" C ");
                    }
                    System.out.println ("---");
                }
            });
            printC.start ();
            try {
                printC.join ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }
}
