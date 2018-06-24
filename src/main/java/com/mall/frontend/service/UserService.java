package com.mall.frontend.service;

import com.mall.model.User;

public interface UserService {
    int saveUser(User user);
    Boolean isExist(String phone);
    User isAllowLogin(String phone, String password);
}
