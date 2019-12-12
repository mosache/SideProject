package com.vurtne.side.errorhandler;

import com.vurtne.side.exception.TokenException;
import com.vurtne.side.model.VResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class ErrorHandler{
    /**
     * 其他异常
     * */
    @ExceptionHandler(Exception.class)
    public VResponse onError(Exception ex) {
        return VResponse.Error(ex.getMessage());
    }

    @ExceptionHandler(TokenException.class)
    public VResponse onTokenException(Exception ex) {
        return VResponse.Error(ex.getMessage());
    }

    /**
     * 处理404异常
     * */
    @ExceptionHandler(NoHandlerFoundException.class)
    public VResponse NO_FOUND(NoHandlerFoundException ex) {
        return VResponse.Error(ex.getMessage());
    }
}
