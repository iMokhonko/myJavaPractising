package com.imokhonko;

import java.util.ArrayList;
import java.util.List;

public class Decision {

    private final String name;
    private final DecisionType decisionType;

    // navigation
    private Decision prevDecision = null;
    private List<Decision> nextDecisions = new ArrayList<> ();

    public Decision(String name, DecisionType decisionType) {
        this.name = name;
        this.decisionType = decisionType;
    }

    public String getName() {
        return name;
    }

    public List<Decision> getNextDecisions() {
        return nextDecisions;
    }

    public Decision getPrevDecision() {
        return prevDecision;
    }

    public DecisionType getDecisionType() {
        return decisionType;
    }

    public void setPrevDecision(Decision prevDecision) {
        this.prevDecision = prevDecision;
    }

    public void setNextDecisions(List<Decision> nextDecisions) {
        this.nextDecisions.addAll (nextDecisions);
    }

    public void setNextDecision(Decision nextDecisions) {
        this.nextDecisions.add (nextDecisions);
    }

    @Override
    public String toString() {
        return name;
    }

    enum DecisionType {
        START,
        OPTIONAL,
        NEXT,
        FINISH;
    }

}
