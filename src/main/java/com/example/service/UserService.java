package com.example.service;

import com.example.dao.UserDao;
import com.example.entity.base.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> get() {
        return userDao.selectAll();
    }

    public int insert(User user) {
        return userDao.insert(user);
    }
}
