package com.mall.admin.action;

import com.mall.admin.service.AdminGroupService;
import com.mall.model.AdminGroup;
import com.mall.utils.ResponseTemplate;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminGroupAction extends AdminBaseAction {

    @Autowired
    private AdminGroupService adminGroupService;

    private AdminGroup adminGroup;
    private List<AdminGroup> adminGroups;

    public Map<String, Object> jsonResult;

    // 列出所有
    public String list() {
        // 分页设置
        if (hasPageSetting()) {
            int page = getPageSetting();
            int pageSize = getPageSizeSetting();

            adminGroups = adminGroupService.findByPage(page, pageSize);
        } else {
            adminGroups = adminGroupService.findAll();
        }

        Map<String, Object> map = new HashMap<>();
        map.put("data", adminGroups);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 列出一个
    public String get() {
        if (this.adminGroup == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminGroup is required!");
            return SUCCESS;
        }

        Map<String, Object> map = new HashMap<>();
        adminGroup = adminGroupService.findById(this.adminGroup.getId());
        map.put("data", adminGroup);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 添加
    public String add() {
        if (this.adminGroup == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminGroup is required!");
            return SUCCESS;
        }

        int status = adminGroupService.save(this.adminGroup);
        System.out.println(status);

        if (status > 0) {
            Map<String, Object> map = new HashMap<>();
            map.put("data", adminGroup);
            jsonResult = ResponseTemplate.success(map);
        } else {
            jsonResult = ResponseTemplate.error(-1, "添加失败");
        }
        return SUCCESS;
    }

    // 更新
    public String update() {
        if (this.adminGroup == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminGroup is required!");
            return SUCCESS;
        }

        adminGroupService.update(adminGroup);

        Map<String, Object> map = new HashMap<>();
        map.put("data", adminGroup);
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    // 删除
    public String delete() {
        if (this.adminGroup == null) {
            jsonResult = ResponseTemplate.error(-1, "Param adminGroup is required!");
            return SUCCESS;
        }

        adminGroupService.delete(this.adminGroup);

        // Set status code
        HttpServletResponse res = ServletActionContext.getResponse();
        res.setStatus(400);

        Map<String, Object> map = new HashMap<>();
        jsonResult = ResponseTemplate.success(map);
        return SUCCESS;
    }

    public void setAdminGroup(AdminGroup adminGroup) {
        this.adminGroup = adminGroup;
    }
}
