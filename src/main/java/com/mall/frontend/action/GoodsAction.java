package com.mall.frontend.action;

import com.mall.model.User;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller(value = "goodsAction")
public class GoodsAction extends BaseAction {
    public String list() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        System.out.println(tokenData.getUsername());
        System.out.println("............");
        this.jsonResult = ResponseTemplate.success(null);
        return SUCCESS;
    }
}
