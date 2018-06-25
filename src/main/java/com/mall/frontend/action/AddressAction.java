package com.mall.frontend.action;

import com.mall.model.User;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

@Controller(value = "addressAction")
public class AddressAction extends BaseAction {
    public String list() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        this.jsonResult = ResponseTemplate.success(null);
        return SUCCESS;
    }

    public String add() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        this.jsonResult = ResponseTemplate.success(null);
        return SUCCESS;
    }

    public String edit() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        this.jsonResult = ResponseTemplate.success(null);
        return SUCCESS;
    }

    public String delete() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        this.jsonResult = ResponseTemplate.success(null);
        return SUCCESS;
    }
}
