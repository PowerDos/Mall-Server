package com.mall.frontend.action;

import com.mall.frontend.service.AddressService;
import com.mall.model.Address;
import com.mall.model.User;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "addressAction")
public class AddressAction extends BaseAction {
    private Address address;

    @Autowired
    private AddressService addressService;

    public void setAddress(Address address) {
        this.address = address;
    }

    public String list() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        List<Address> list = addressService.getAddress(tokenData.getUserid());
        Map<String, Object> data = new LinkedHashMap<String, Object>();
        data.put("data", list);
        this.jsonResult = ResponseTemplate.success(data);
        return SUCCESS;
    }

    public String add() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        System.out.println(this.address.getAddress());
        this.address.setUserid(tokenData.getUserid());
        int result = addressService.saveAddress(this.address);
        if (result > 0) {
            this.jsonResult = ResponseTemplate.success(null);
        } else {
            this.jsonResult = ResponseTemplate.error(201, "增加地址失败");
        }
        return SUCCESS;
    }

    public String edit() {
        User tokenData = (User) ServletActionContext.getRequest().getAttribute("tokenData");
        this.address.setUserid(tokenData.getUserid());
        System.out.println(this.address.getAddress());
        try {
            addressService.editAddress(this.address);
            this.jsonResult = ResponseTemplate.success(null);
        } catch (Exception e) {
            System.out.println(e);
            this.jsonResult = ResponseTemplate.error(202, "删除失败");
        }
        return SUCCESS;
    }

    public String del() {
        System.out.println(this.address.getAddress());
        try {
            addressService.delAddress(this.address);
            this.jsonResult = ResponseTemplate.success(null);
        } catch (Exception e) {
            System.out.println(e);
            this.jsonResult = ResponseTemplate.error(202, "删除失败");
        }
        return SUCCESS;
    }
}
