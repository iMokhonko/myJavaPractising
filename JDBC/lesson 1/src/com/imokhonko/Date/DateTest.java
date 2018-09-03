package com.imokhonko.Date;

import java.util.Calendar;

public class DateTest {

    public static void main(String[] args) throws InterruptedException {

       Calendar calendar = Calendar.getInstance ();
       System.out.println (calendar.getTimeZone ().getDisplayName ());

    }

}
