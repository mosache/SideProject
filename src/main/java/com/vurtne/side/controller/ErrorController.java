package com.vurtne.side.controller;

import com.vurtne.side.model.VResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(Exception.class)
    public VResponse onError(Exception ex) {
        return VResponse.Error(ex.getMessage());
    }
}
