package com.mall.frontend.action;

import com.mall.frontend.service.OrderService;
import com.mall.frontend.service.ShoppingCartService;
import com.mall.model.Order;
import com.mall.model.User;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "orderAction")
public class OrderAction extends BaseAction {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    private Order order;

    public void setCart(int[] cart) {
        this.cart = cart;
    }

    private int[] cart;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public String add() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        System.out.println(this.cart.toString());
        order.setUserid(tokenData.getUserid());
        shoppingCartService.delCart(this.cart);
        int result = orderService.saveOrder(order);
        if (result >= 0) {
            jsonResult = ResponseTemplate.success(null);
        } else {
            jsonResult = ResponseTemplate.error(501, "添加订单失败");
        }
        return SUCCESS;
    }

    public String list() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        List<Order> list = orderService.getOrderList(tokenData.getUserid());
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }
}
