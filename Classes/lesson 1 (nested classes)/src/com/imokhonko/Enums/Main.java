package com.imokhonko.Enums;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<WeekDays> daysList = new ArrayList<> ();

        for (WeekDays weekDays : WeekDays.values ()) {
            System.out.println (weekDays);
        }

        for (int i = 0; i < daysList.size (); i++) {
            System.out.println (WeekDays.valueOf (daysList.get(i).toString ()));
        }

    }

}
