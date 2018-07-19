package com.imokhonko;

public class Main {

    public static void main(String[] args) {

        Main main = new Main ();

        try {
            main.exptEmaple (1);
        } catch (com.imokhonko.myExcpt myExcpt) {
            myExcpt.printStackTrace ();
        } catch (com.imokhonko.myExcptTwo myExcptTwo) {
            myExcptTwo.printStackTrace ();
        }

    }

    public void exptEmaple(final int exptCode) throws myExcpt, myExcptTwo {

        switch (exptCode) {

            case 1: {
                throw new myExcpt ();
            }
            case 2: {
                throw new myExcptTwo ();
            }

        }

    }

}
