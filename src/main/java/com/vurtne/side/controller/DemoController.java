package com.vurtne.side.controller;

import com.vurtne.side.exception.TokenException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/doError")
    public void error() {
        throw new RuntimeException("Exception");
    }

    @GetMapping("/doTokenError")
    public void tokenError() {
        throw new TokenException();
    }
}
