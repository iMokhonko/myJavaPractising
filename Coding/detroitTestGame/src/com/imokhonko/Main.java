package com.imokhonko;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Player player = new Player ("iMokhonko");
        Game game = new Game ("Detroit: became human");

        List<Decision> list = new ArrayList<> ();

        list.add (new Decision ("Start game", Decision.DecisionType.START));

        list.add (new Decision ("Prepare for exam", Decision.DecisionType.NEXT));
        list.add (new Decision ("Check notebook", Decision.DecisionType.OPTIONAL));
        list.add (new Decision ("Finish preparing", Decision.DecisionType.NEXT));
        list.add (new Decision ("Pass the exam", Decision.DecisionType.FINISH));

        list.add (new Decision ("Do nothing", Decision.DecisionType.NEXT));
        list.add (new Decision ("Play games", Decision.DecisionType.FINISH));

        list.get(0).setNextDecision(list.get(1));
        list.get(0).setNextDecision(list.get(5));
        list.get(1).setNextDecision(list.get(2));
        list.get(1).setNextDecision(list.get(3));
        list.get(3).setNextDecision(list.get(4));
        list.get(5).setNextDecision(list.get(6));


        list.get(2).setNextDecision(list.get(1));


        Scanner in = new Scanner (System.in);
        int a;

        System.out.println ("Choose:");
        System.out.println ("1: " + list.get (0).getName ());
        a = in.nextInt ();

        while(true) {

            List<Decision> nextDecisionsList = new ArrayList<> ();
            nextDecisionsList.addAll (list.get (a).getNextDecisions());

            System.out.println ("\n\n\n\n\n\n\n\n\n\nChoose:");
            for (int i = 0; i < nextDecisionsList.size (); i++) {
                System.out.println (i + ": " + nextDecisionsList.get (i));

                // check if it is finish
                if(nextDecisionsList.get (i).getDecisionType () == Decision.DecisionType.FINISH) {
                    return;
                }
            }
            a = in.nextInt ();
            int b = list.indexOf(nextDecisionsList.get (a));
            a = b;
            System.out.println (a);
        }


    }
}
