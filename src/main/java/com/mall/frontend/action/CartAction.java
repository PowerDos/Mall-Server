package com.mall.frontend.action;

import com.mall.frontend.service.ShoppingCartService;
import com.mall.model.ShoppingCart;
import com.mall.model.User;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "cartAction")
public class CartAction extends BaseAction {
    @Autowired
    private ShoppingCartService shoppingCartService;
    private ShoppingCart shoppingCart;

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String add() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        shoppingCart.setUserId(tokenData.getUserid());
        int result = shoppingCartService.saveCart(shoppingCart);
        if (result > 0) {
            jsonResult = ResponseTemplate.success( null);
        } else {
            jsonResult = ResponseTemplate.error(301, "添加购物车失败");
        }
        return SUCCESS;
    }

    public String list() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        List<ShoppingCart> list = shoppingCartService.getCartList(tokenData.getUserid());
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }
}
