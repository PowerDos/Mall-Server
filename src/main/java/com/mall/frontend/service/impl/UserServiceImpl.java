package com.mall.frontend.service.impl;

import com.mall.frontend.dao.UserDao;
import com.mall.frontend.service.UserService;
import com.mall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int saveUser(User user) {
        int result = userDao.saveUser(user);
        return result;
    }

    @Override
    public Boolean isExist(String phone) {
        List<User> users = userDao.getUserByPhone(phone);
        if (users.size() > 0) {
            return true;
        }
        return false;
    }

    public User isAllowLogin(String phone, String password) {
        List<User> users = userDao.getUserByPhone(phone);
        String pwd = users.size() > 0 ? users.get(0).getPassword() : "xasda";
        System.out.println(pwd);
        if (pwd.equals(password)) {
            return users.get(0);
        }
        return null;
    }
}
