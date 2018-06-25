package com.mall.frontend.action;

import com.mall.frontend.service.UserService;
import com.mall.model.User;
import com.mall.utils.ResponseTemplate;
import com.mall.utils.Token;
import com.mall.utils.sign;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller(value = "userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
    @Autowired
    private UserService userService;

    public Map<String, Object> jsonResult;
    public User user;
    public String phone;
    public String password;


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(User user) {
        this.user = user;
    }


    /**
     * 测试demo
     * @return
     */
    public String add() {
        Map<String, Object> map = new HashMap<String, Object>();
//        int result = userService.saveUser(user);
//        System.out.println(result);
        map.put("rcode", 0);
        System.out.println("111");
        map.put("name", "Gavin");
        String str = null;
        try {
            str = Token.createToken(map, 30000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(str);
        String string = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXlsb2FkIjoie1wiY3JlYXRlQXRcIjoxNTI5ODQzMjgwMDAwLFwicGFzc3dvcmRcIjpcImUxMGFkYzM5NDliYTU5YWJiZTU2ZTA1N2YyMGY4ODNlXCIsXCJwaG9uZVwiOlwiMTMyMzg1MTIzNjZcIixcInN0YXR1c1wiOjAsXCJ1cGRhdGVBdFwiOjE1Mjk4NDMyODAwMDAsXCJ1c2VyaWRcIjozMSxcInVzZXJuYW1lXCI6XCJHYXZpblwifSIsImV4cCI6MTUyOTg2NjU2NX0.kC7sTZxTn5-PS2HyYFdm8xJ7J8G81aFZLFZlXS5b50w";
        User obj = Token.validToken(string, User.class);
        System.out.println(obj.getUserid());
        jsonResult = map;
        return SUCCESS;
    }

    /**
     * 判断手机是否存在
     * @return
     */
    public String isExist() {
        Boolean result = userService.isExist(this.phone);
        System.out.println(result);
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("isExist", result);
        jsonResult = ResponseTemplate.success(data);
        return SUCCESS;
    }

    /**
     * 注册
     * @return
     */
    public String signUp() {
        String encodePwd = sign.md5(this.user.getPassword());
        user.setPassword(encodePwd);
        int result = userService.saveUser(user);
        if (result > 0) {
            jsonResult = ResponseTemplate.success( null);
        } else {
            jsonResult = ResponseTemplate.error(101, "注册错误");
        }
        return SUCCESS;
    }

    /**
     * 登陆
     * @return
     */
    public String login() {
        User user =  userService.isAllowLogin(this.phone, this.password);
        if (user != null) {
            String str = Token.createToken(user, 3600 * 60);
            Map<String, Object> data = new LinkedHashMap<>();
            data.put("username", user.getUsername());
            data.put("phone", user.getPhone());
            data.put("mail", user.getMail());
            data.put("token", str);
            jsonResult = ResponseTemplate.success(data);
        } else {
            jsonResult = ResponseTemplate.error(102, "登陆失败");
        }
        return SUCCESS;
    }
}
