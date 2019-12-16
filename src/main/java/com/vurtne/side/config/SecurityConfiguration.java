package com.vurtne.side.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {

    @Bean
    public StandardPBEStringEncryptor propertyEncryptor() {
        return new StandardPBEStringEncryptor();
    }
}
