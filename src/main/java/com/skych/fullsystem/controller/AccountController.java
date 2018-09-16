package com.skych.fullsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skych.fullsystem.service.AccountService;

@Controller
@RequestMapping(name="/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @RequestMapping(name="/login")
    @ResponseBody
    public String accountLogin(String account, String pwd) {
        accountService.login(account, pwd);
        return "";
    }
    
    public static int add(int a, int b) {
        return a+b;
    }
}
