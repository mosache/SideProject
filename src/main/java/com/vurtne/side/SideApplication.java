package com.vurtne.side;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SideApplication {

    public static void main(String[] args) {
        SpringApplication.run(SideApplication.class, args);
    }

}
