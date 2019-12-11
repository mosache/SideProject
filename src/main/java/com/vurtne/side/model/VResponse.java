package com.vurtne.side.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 返回json
 * */
@Data
@AllArgsConstructor(staticName = "of")
public class VResponse<T> {
    //是否成功
    private int success;

    //msg
    private String msg = "";

    //数据
    private T data;


    public static<T> VResponse<T> OK(T data) {
        return VResponse.of(1,"",data);
    }

    public static<T> VResponse<T> Error(String msg) {
        return VResponse.of(0,msg,null);
    }

}


