package kz.kassen.Tour_App.exception;

import kz.kassen.Tour_App.exception.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public String handle404() {
        return "error404";
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handle404Id() {
        return "error404";
    }
}
