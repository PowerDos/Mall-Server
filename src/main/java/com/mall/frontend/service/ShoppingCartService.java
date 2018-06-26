package com.mall.frontend.service;

import com.mall.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    int saveCart(ShoppingCart shoppingCart);
    List<ShoppingCart> getCartList(int userid);
}
