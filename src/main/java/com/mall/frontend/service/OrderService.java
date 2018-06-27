package com.mall.frontend.service;

import com.mall.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    int saveOrder(Order order);
    List<Order> getOrderList(int userid);
}
