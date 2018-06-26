package com.mall.frontend.dao;

import com.mall.model.User;

import java.util.List;
import java.util.Set;

public interface UserDao {
    int saveUser(User user);

    List<User> getUserByPhone(String phone);
}
