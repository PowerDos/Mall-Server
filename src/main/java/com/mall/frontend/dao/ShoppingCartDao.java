package com.mall.frontend.dao;

import com.mall.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {
    int saveShoppingCart(ShoppingCart shoppingCart);
    List<ShoppingCart> getShoppingCartByUserId(int userid);
}
