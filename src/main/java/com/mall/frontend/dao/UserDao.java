package com.mall.frontend.dao;

import com.mall.model.User;

import java.util.List;

public interface UserDao {
    int saveUser(User user);

    List<User> getUserByPhone(String phone);
}
