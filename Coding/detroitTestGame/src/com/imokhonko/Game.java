package com.imokhonko;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Decision> decisions = new ArrayList<> ();
    private final String gameName;

    public Game(String gameName) {
        this.gameName = gameName;
    }

    public void setDecisions(List<Decision> decisions) {
        this.decisions = decisions;
    }

    public List<Decision> getDecisions() {
        return decisions;
    }

    public boolean confirmDecision(Player player, Decision decision) {

        return true;
    }
}
