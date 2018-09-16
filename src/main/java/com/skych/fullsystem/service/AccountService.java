package com.skych.fullsystem.service;

import javax.servlet.http.HttpSession;

public interface AccountService {

    public boolean login(String account, String pwd);
    public boolean logout(HttpSession session);
}
