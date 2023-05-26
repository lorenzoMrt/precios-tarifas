package com.napptilus.preciostarifas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.napptilus.preciostarifas.api.exception.WrongDateFormatException;

public class DateUtils {

    public static final String FORMAT = "yyyy-MM-dd-HH.mm.ss";

    public static LocalDateTime createDateFor(String dateString) throws WrongDateFormatException{
        LocalDateTime date = null;
        
        try {
            date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(FORMAT));
            
        } catch (Exception e) {
            throw new WrongDateFormatException("Wrong date format");
        }
        return date;
    }
    private DateUtils() {
        throw new IllegalStateException("Utility class");
    }
}
