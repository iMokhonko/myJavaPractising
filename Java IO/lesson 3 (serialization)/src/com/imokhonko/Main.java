package com.imokhonko;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        List<GameOrelReshka> experiments = new ArrayList<> (1_000);

        for (int i = 0; i < 1_000; i++) {

            float orel = 0;
            float reshka = 0;

            for (int j = 0; j < 1_000_000; j++) {
                switch (1 + (int) (Math.random() * 2)) {
                    case 1:{
                        orel++;
                        break;
                    }
                    case 2: {
                        reshka++;
                        break;
                    }
                }
            }
            experiments.add (new GameOrelReshka (orel, reshka));
        }


        int orelResult = 0;
        int reshkaResult = 0;

        for (GameOrelReshka experiment : experiments) {
            orelResult += experiment.getOrel ();
            reshkaResult += experiment.getReshka ();
        }

        System.out.println ("Orel ("+ (orelResult / 1_000_000_000 * 100) +"%): " + orelResult);
        System.out.println ("Reshka ("+ (reshkaResult / 1_000_000_000 * 100) +"%): " + reshkaResult);

    }

}
