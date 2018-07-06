package com.imokhonko.Enums.MyEnums;

public enum Tables {

    SMALL(3, 4),
    MEDIUM(4, 12),
    LARGE(3, 15);

    private final double legsCount;
    private final double weight;

    Tables(final double legsCount, final double weight) {
        this.legsCount = legsCount;
        this.weight = weight;
    }

    double getLegsCount() {
        return legsCount;
    }

    double getWeight() {
        return weight;
    }

    double weightPerLeg() {
        return getWeight () / getLegsCount ();
    }

    double customLegsWeight(double legsCount) {
        return getWeight () / legsCount;
    }

}
