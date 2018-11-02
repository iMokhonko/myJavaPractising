package com.imokhonko.model;

import java.util.ArrayList;
import java.util.List;

public class CreditsUtil {

    public List<Credit> getBestCredits(List<Bank> banks) {
        List<Credit> bestCredits = new ArrayList<>();

        for(Bank bank : banks) {
            bestCredits.addAll(bank.getAvailableCredits());
        }

        bestCredits.sort((o1, o2) -> {
            if(o1.getPercents() - o2.getPercents() > 0) {
                return 1;
            } else if(o1.getPercents() - o2.getPercents() < 0) {
                return -1;
            } else {
                return 0;
            }
        });

        return bestCredits;
    }

}
