package com.napptilus.preciostarifas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Wrong date format")
public class WrongDateFormatException extends Exception{

    public WrongDateFormatException(String errorMessage) {
        super(errorMessage);
    }

}
