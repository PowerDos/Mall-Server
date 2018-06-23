package com.mall.example.service;

import com.mall.example.model.User;

import java.util.List;

/**
 * 商品操作-服务层接口
 *
 */
public interface UserService {

    List<User> getUsers();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(User user);


}
