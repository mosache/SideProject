package com.vurtne.side.controller;

import com.vurtne.side.annotation.PassToken;
import com.vurtne.side.exception.TokenException;
import com.vurtne.side.model.VResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test")
    public VResponse test() {
       return VResponse.OK("success");
    }
}
