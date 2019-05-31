package com.skych.fullsystem.service.impl;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.skych.fullsystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Override
    public boolean login(String account, String pwd) {
        Subject subject =  SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, pwd);
        subject.login(token);
        return false;
    }

    @Override
    public boolean logout(HttpSession session) {
        // TODO Auto-generated method stub
        return false;
    }

}
