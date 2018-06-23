package com.mall.example.dao;


import com.mall.example.model.User;

/**
 * 商品操作-持久层接口
 *
 */
public interface UserDao {

    void saveUser(User user);

}
