package com.boxfish.lhb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * Created by boxfish on 15/12/14.
 */
@SpringBootApplication
//@EnableOAuth2Client
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}