package com.vurtne.side;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
public class SideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SideApplication.class, args);
    }

}
