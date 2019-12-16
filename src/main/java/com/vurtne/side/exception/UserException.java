package com.vurtne.side.exception;

public class UserException extends RuntimeException {
    public UserException(String errorMsg) {
       super(errorMsg);
    }

    public UserException(){
        super("用户不存在！");
    }



}
