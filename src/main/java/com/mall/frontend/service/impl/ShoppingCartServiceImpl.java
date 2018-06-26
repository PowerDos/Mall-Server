package com.mall.frontend.service.impl;

import com.mall.frontend.dao.ShoppingCartDao;
import com.mall.frontend.service.ShoppingCartService;
import com.mall.model.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartDao shoppingCartDao;
    @Override
    public int saveCart(ShoppingCart shoppingCart) {
        int result = shoppingCartDao.saveShoppingCart(shoppingCart);
        return result;
    }

    @Override
    public List<ShoppingCart> getCartList(int userid) {
        List<ShoppingCart> list = shoppingCartDao.getShoppingCartByUserId(userid);
        return list;
    }
}
