package com.skych.fullsystem.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.skych.fullsystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public boolean login(String account, String pwd) {
        return false;
    }

    @Override
    public boolean logout(HttpSession session) {
        // TODO Auto-generated method stub
        return false;
    }

}
