package com.napptilus.preciostarifas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;

public class DateUtils {

    public static final String FORMAT = "yyyy-MM-dd-HH.mm.ss";

    public static Date createDateFor(String dateString) throws WrongDateFormatException {
        Date date = null;
        try {
            date = new SimpleDateFormat(FORMAT).parse(dateString);
        } catch (ParseException e) {
            throw new WrongDateFormatException("Wrong date format. Example: 1960-12-11-10.00.00");
        }
        return date;
    }
    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }
}
