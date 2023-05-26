package com.napptilus.preciostarifas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid parameter values")
public class InvalidParameterException extends Exception {

    public InvalidParameterException(String message) {
        super(message);
    }
}
