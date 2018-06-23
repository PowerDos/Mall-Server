package com.mall.example.service.impl;

import com.mall.example.dao.UserDao;
import com.mall.example.model.User;
import com.mall.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "test index", 20));
        return users;
    }

    @Override
    public User getUser(int id) {
        User user = new User(2, "test show", 30);
        return user;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {
    }
}
