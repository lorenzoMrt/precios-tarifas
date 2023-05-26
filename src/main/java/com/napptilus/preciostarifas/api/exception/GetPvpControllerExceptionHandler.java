package com.napptilus.preciostarifas.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice()
public class GetPvpControllerExceptionHandler extends ResponseEntityExceptionHandler {
    

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleProductNotFound(ProductNotFoundException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(WrongDateFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleWrongDateFormat(WrongDateFormatException ex) {
        return ex.getMessage();
    }
    @ExceptionHandler(InvalidParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleInvalidParameterValue(InvalidParameterException ex) {
        return ex.getMessage();
    }
}
