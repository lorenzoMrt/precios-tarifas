package com.napptilus.preciostarifas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String FORMAT = "yyyy-MM-dd-HH.mm.ss";

    public static Date createDateFor(String dateString) {
        Date date = null;
        try {
            date = new SimpleDateFormat(FORMAT).parse(dateString);
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
