package com.mall.admin.action;

import com.mall.admin.service.AdminUserService;
import com.mall.model.AdminUser;
import com.mall.utils.ResponseTemplate;
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
        // 分页设置
        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            adminUsers = adminUserService.findByPage(page, pageSize);
        } else {
            adminUsers = adminUserService.findAll();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", adminUsers);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 列出一个
    public String get() {
        if (this.adminUser == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminUser is required!");
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<>();
        adminUser = adminUserService.findById(this.adminUser.getId());
        map.put("data", adminUser);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 添加
    public String add() {
        if (this.adminUser == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminUser is required!");
            return SUCCESS;
        }

        int status = adminUserService.save(this.adminUser);
        System.out.println(status);

        if (status > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", adminUser);
            jsonResult = ResponseTemplate.success(map);
        } else {
            jsonResult = ResponseTemplate.error(-1, "添加失败");
        }
        return SUCCESS;
    }

    // 更新
    public String update() {
        if (this.adminUser == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminUser is required!");
            return SUCCESS;
        }

        adminUserService.update(adminUser);

        Map<String, Object> map = new HashMap<>();
        map.put("data", adminUser);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 删除
    public String delete() {
        if (this.adminUser == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminUser is required!");
            return SUCCESS;
        }

        adminUserService.delete(this.adminUser);

        // Set status code
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setStatus(400);

        Map<String, Object> map = new HashMap<>();
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }
}
