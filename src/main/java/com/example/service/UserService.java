package com.example.service;

import java.util.List;

import com.example.dao.UserDao;
import com.example.entity.base.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    /**
     * @param User user
     * @return int id
     */
    public int create(User user) {
        return userDao.insert(user);
    }

    public List<User> get() {
        return userDao.selectAll();
    }
}
