package com.vurtne.side.exception;

public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }

    public TokenException() {
        super();
    }
}
