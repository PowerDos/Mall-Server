package com.mall.frontend.dao;

import com.mall.model.User;

import java.util.Set;

public interface UserDao {
    int saveUser(User user);

    Set<User> getUserByPhone(String phone);
}
