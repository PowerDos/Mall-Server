package com.mall.frontend.service.impl;

import com.mall.frontend.dao.UserDao;
import com.mall.frontend.service.UserService;
import com.mall.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int saveUser(User user) {
        int result = userDao.saveUser(user);
        return result;
    }
}
