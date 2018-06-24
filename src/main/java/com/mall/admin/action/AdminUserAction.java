package com.mall.admin.action;

import com.mall.admin.service.AdminUserService;
import com.mall.model.AdminUser;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminUserAction extends AdminBaseAction {

    @Autowired
    private AdminUserService adminUserService;

    private AdminUser adminUser;
    private List<AdminUser> adminUsers;

    public Map<String, Object> jsonResult;

    // 列出所有
    public String list() {
        System.out.println("List admin user");
        adminUsers = adminUserService.findAll();

        Map<String, Object> payload = new HashMap<>();
        payload.put("result", adminUsers);
        payload.put("rcode", 0);
        payload.put("message", "success");
        jsonResult = payload;
        return SUCCESS;
    }

    // 列出一个
    public String get() {
        System.out.println("Get admin user");
        adminUser = adminUserService.findById(2);

        Map<String, Object> payload = new HashMap<>();
        payload.put("result", adminUser);
        payload.put("rcode", 0);
        payload.put("message", "success");
        jsonResult = payload;
        return SUCCESS;
    }

    // 添加
    public String add() {
        System.out.println("Add admin user");

        this.adminUser = new AdminUser();
        this.adminUser.setUsername("wjh");
        this.adminUser.setAdmin(false);
        this.adminUser.setEmail("876531738@qq.com");

        int status = adminUserService.save(this.adminUser);

        System.out.println(status);
        if (status == 0) {
            Map<String, Object> payload = new HashMap<>();
            payload.put("result", adminUser);
            payload.put("rcode", 0);
            payload.put("message", "success");
            jsonResult = payload;
        } else {
            Map<String, Object> payload = new HashMap<>();
            payload.put("result", adminUser);
            payload.put("rcode", -1);
            payload.put("message", "Bad request");
            jsonResult = payload;
        }
        return SUCCESS;
    }

    // 更新
    public String update() {
        System.out.println("Update admin user");
        this.adminUser = new AdminUser();
        this.adminUser.setId(1);
        this.adminUser.setUsername("test update");
        this.adminUser.setAdmin(false);
        this.adminUser.setEmail("876531738@qq.com");

        adminUserService.update(adminUser);

        Map<String, Object> payload = new HashMap<>();
        payload.put("result", adminUser);
        payload.put("rcode", 0);
        payload.put("message", "success");
        jsonResult = payload;
        return SUCCESS;
    }

    // 删除
    public String delete() {
        System.out.println("Delete admin user");
        this.adminUser = new AdminUser();
        this.adminUser.setId(1);
        this.adminUser.setUsername("test update");
        this.adminUser.setAdmin(false);
        this.adminUser.setEmail("876531738@qq.com");

        adminUserService.delete(this.adminUser);

        // Set status code
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setStatus(400);

        Map<String, Object> payload = new HashMap<>();
        payload.put("rcode", 0);
        payload.put("message", "success");
        jsonResult = payload;
        return SUCCESS;
    }

}
