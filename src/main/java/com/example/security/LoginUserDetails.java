package com.example.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class LoginUserDetails extends User {
    private static final long serialVersionUID = 1L;

    private LoginInfo userInfo;

    public LoginUserDetails(LoginInfo userInfo) {
        super(userInfo.getUserId(), userInfo.getPassword(), AuthorityUtils.createAuthorityList(userInfo.getRole()));
        this.userInfo = userInfo;
    }

    public LoginInfo getUserInfo() {
        return this.userInfo;
    }
}
