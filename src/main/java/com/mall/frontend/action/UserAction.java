package com.mall.frontend.action;

import com.mall.frontend.service.UserService;
import com.mall.model.User;
import com.opensymphony.xwork2.ActionSupport;

import java.util.HashMap;
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

    public void setUser(User user) {
        this.user = user;
    }
    @Override
    public String execute() throws Exception {
//        post数据
//        {
//            "user": {
//                "username": "Gavin",
//                "phone": "130000000000",
//                "userid": "132546"
//            }
//        }
        System.out.println("work..........");
        Map<String, Object> map = new HashMap<String, Object>();
        User user = new User();
        user.setUsername("Gavin");
        user.setUserid(1);
        user.setPhone("130000000000");
        map.put("user", user);
        map.put("rcode", "0");
        map.put("message", "success");
//        打印数据
//        work..........
//        Gavin
//        130000000000
//        132546
        // 打印接收的数据
        System.out.println(this.user.getUsername());
        System.out.println(this.user.getPhone());
        System.out.println(this.user.getUserid());
        jsonResult = map;

//        返回数据
//        {
//            "rcode": "0",
//            "message": "success",
//            "user": {
//                "createAt": null,
//                "password": null,
//                "phone": "130000000000",
//                "status": 0,
//                "updateAt": null,
//                "userid": 1,
//                "username": "Gavin"
//            }
//        }
        return SUCCESS;
    }

    /**
     * 用户注册
     * @return
     */
    public String add() {
        Map<String, Object> map = new HashMap<String, Object>();
        int result = userService.saveUser(user);
        System.out.println(result);
        map.put("rcode", 0);
        jsonResult = map;
        return SUCCESS;
    }

    public String save() {
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            int result = userService.saveUser(user);
            System.out.println(result);
            map.put("rcode", 0);
            map.put("order", result);
            jsonResult = map;
        } catch (Exception e) {
            System.out.println(e);
        }
        return SUCCESS;
    }
}
