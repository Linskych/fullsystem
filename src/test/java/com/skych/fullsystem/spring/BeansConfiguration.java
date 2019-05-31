package com.skych.fullsystem.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.skych.fullsystem.controller.AccountController;


@Configuration
public class BeansConfiguration {

    @Bean(name="accountController")
    public AccountController getAccountController() {
        return new AccountController();
    }
}
