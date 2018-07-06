package com.imokhonko.Enums;

public enum WeekDays {

    SUNDAY("Sunday"), MONDAY("Monday"), TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday"),
    SATURDAY("Saturday");

    private final String day;

    WeekDays(final String day) {
        this.day = day;
    }

}
