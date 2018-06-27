package com.mall.frontend.dao;

import com.mall.model.Order;

import java.util.List;

public interface OrderDao {
    int save(Order order);
    List<Order> list(int userid);
}
