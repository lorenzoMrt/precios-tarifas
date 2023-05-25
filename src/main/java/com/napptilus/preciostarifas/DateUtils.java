package com.napptilus.preciostarifas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date createDateFor(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss").parse(dateString);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date;
    }
    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }
}
