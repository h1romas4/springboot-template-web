package com.example.security;

import com.example.dao.UserDao;
import com.example.entity.base.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
class SigninService implements UserDetailsService {
    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.selectByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User or password invalid.");
        }

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setUserId(String.valueOf(user.userId));
        loginInfo.setEmail(user.email);
        loginInfo.setName(user.name);
        loginInfo.setRole(user.role);
        loginInfo.setPassword(user.password);

        return new LoginUserDetails(loginInfo);
    }
}
