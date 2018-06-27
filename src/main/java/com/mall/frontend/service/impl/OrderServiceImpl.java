package com.mall.frontend.service.impl;

import com.mall.frontend.dao.OrderDao;
import com.mall.frontend.service.OrderService;
import com.mall.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Override
    public int saveOrder(Order order) {
        int result = orderDao.save(order);
        return result;
    }

    @Override
    public List<Order> getOrderList(int userid) {
        List<Order> list = orderDao.list(userid);
        return list;
    }
}
